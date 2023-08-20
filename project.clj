(defproject postmaster "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [ring/ring-defaults "0.3.2"]
                 [metosin/reitit-ring "0.7.0-alpha5"]
                 [metosin/reitit "0.7.0-alpha5"]
                 [ring/ring-jetty-adapter "1.10.0"]
                 [ring/ring-core "1.10.0"]
                 [metosin/ring-http-response "0.9.3"]
                 [buddy/buddy-auth "2.1.0"]
                 [cheshire "5.10.0"]
                 [buddy/buddy-sign "3.1.0"]]
 
  :main ^:skip-aot postmaster.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
