(ns postmaster.handlers.add 
  (:require [cheshire.core :as json]

            ))
(def jwt-secret "JWT_SECRET")



(defn add-user-header
 [request]
 
          {:status 200 :body {json/encode (:headers request)}}
)