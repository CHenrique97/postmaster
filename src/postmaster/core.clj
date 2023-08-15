(ns postmaster.core
  (:gen-class) 
  (:require [postmaster.middleware :as middleware]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Im a test"))
(= 3 3)
         ( def jwt "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwidXNlcl9pZCI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.AU-yqLvUOleymW6yIgCUcZyOehVhDS-L-Rg6oenX_LM")
( def secret-key "142c10a0-2e39-4d96-98e8-905ecc872b87")
( def jwt-decoded (middleware/verify  jwt secret-key))
(println jwt-decoded)





