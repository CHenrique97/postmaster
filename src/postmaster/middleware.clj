(ns postmaster.middleware
  (:require [buddy.auth :refer [authenticated?]]
           [buddy.auth.backends :as backends]
           [buddy.auth.middleware :refer [wrap-authentication]]
           [buddy.sign.jwt :as jwt]
             [cheshire.core :as json]))

(def jwt-secret "JWT_SECRET")
(def backend (backends/jws {:secret jwt-secret}))

(defn wrap-jwt-authentication
  [handler]
  (wrap-authentication handler backend))

(defn add-user-header
  [request]
            (let [authorization-header (get-in request [:headers "authorization"])
      token (.substring authorization-header 6)
      unsigned-token (jwt/unsign token jwt-secret)
      user-id (get unsigned-token :user-id)]
  (assoc-in request [:headers "x-user-id"] user-id)))

(defn auth-middleware
  [handler]
  (fn [request]
    (if (authenticated? request)
     ( handler (add-user-header request) )
      {:status 401 :body {:error "Unauthorized"}})))


