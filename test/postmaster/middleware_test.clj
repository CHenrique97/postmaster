(ns postmaster.middleware_test
  (:require [postmaster.middleware :as middleware ]  [clojure.test :refer :all] )
)


(deftest a-test

  (testing "Middleware accepts token"
    (let [
          jwt "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwidXNlcl9pZCI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.AU-yqLvUOleymW6yIgCUcZyOehVhDS-L-Rg6oenX_LM"
          secret-key "142c10a0-2e39-4d96-98e8-905ecc872b87"
          jwt-decoded (middleware/verify jwt secret-key) ]
      (is (= jwt-decoded  {:sub "1234567890", :user_id "John Doe", :iat 1516239022}))
   jwt-decoded))
  
  (testing "Middleware adds header of user name ")
     (let [ response (middleware/auth)]
  ( is(get-in response [:headers "X-user-id"]) nil)
       response) 
  ); Return jwt-decoded for the linter

