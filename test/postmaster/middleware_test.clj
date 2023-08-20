(ns postmaster.middleware_test
  (:require [postmaster.middleware :as middleware ]  [clojure.test :refer :all] )
)

(def jwt "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwidXNlcl9pZCI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.AU-yqLvUOleymW6yIgCUcZyOehVhDS-L-Rg6oenX_LM" )

(deftest a-test

  (testing "Middleware accepts token"
    (let [
          jwt-decoded (middleware/verify jwt ) ]
      (is (= jwt-decoded  {:sub "1234567890", :user_id "John Doe", :iat 1516239022}))
   jwt-decoded))
  
)
