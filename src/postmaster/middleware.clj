(ns postmaster.middleware
  (:require [buddy.sign.jwt :as jwt]
           [clojure.data.codec.base64 :as b64]
           [clojure.string :as str]
           [cheshire.core :as json]))

(defn decode-b64 [str] (String. (b64/decode (.getBytes str))))
(defn parse-json [s]
  ;; beware, I got some tokens from AWS Cognito where the last '}' was missing in the payload
  (let [clean-str (if (str/ends-with? s "}") s (str s "}"))]
    (json/parse-string clean-str keyword)))

(defn decode [token]
  (let [[header payload _] (clojure.string/split token #"\.")]
    {:header  (parse-json (decode-b64 header))
     :payload (parse-json (decode-b64 payload))}))


(defn verify 
  [token secret-key]
    (try 
     (jwt/unsign token secret-key {:alg :hs256})
       (catch Throwable 
     {:error   true
      :details "Message seems corrupt or manipulated"})))

(defn auth []
  )
