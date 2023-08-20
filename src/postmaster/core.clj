(ns postmaster.core
  (:gen-class)
  (:require 
          [ring.adapter.jetty :as ring-jetty]
          [reitit.ring :as ring]
          [muuntaja.core :as m]
          [reitit.coercion.schema]
          [postmaster.middleware :as middleware]
          [postmaster.handlers.add :as add]
          [reitit.ring.coercion :refer [coerce-exceptions-middleware
                                   coerce-request-middleware
                                   coerce-response-middleware]]
     [reitit.ring.middleware.exception :refer [exception-middleware]]
     [reitit.ring.middleware.muuntaja :refer [format-request-middleware
                                              format-response-middleware
                                              format-negotiate-middleware]]))
   


(def users (atom {}))

(defn string-handler [_]
  {:status 200
   :body "on the code again"})


(defn get-user-by-id [{{:keys [id]} :path-params}]
  {:status 200
   :body (get @users id)})

(def app
  (ring/ring-handler
   (ring/router
    ["/" {:middleware [middleware/wrap-jwt-authentication middleware/auth-middleware]}
     ["add" {:get  add/add-user-header }]
     ["view" get-user-by-id]
     ["edit" get-user-by-id]
     ["delete" get-user-by-id]
     ["" string-handler]]      {:data {
                                       :coercion reitit.coercion.schema/coercion
                                  :muuntaja m/instance
                                  :middleware [format-negotiate-middleware
                                               format-response-middleware
                                               exception-middleware
                                               format-request-middleware
                                               coerce-exceptions-middleware
                                               coerce-request-middleware
                                               coerce-response-middleware]}})
    ))

(defn start []
  (ring-jetty/run-jetty app {:port  3000
                             :join? false}))

(defn -main
  [& args]
  (start))