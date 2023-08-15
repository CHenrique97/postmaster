(defproject postmaster "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"] [clojure.java-time "1.2.0"] [buddy/buddy-core "1.11.423"] [org.clojure/data.codec "0.1.1"]
 [buddy/buddy-sign "3.5.351"]]
  :main ^:skip-aot postmaster.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})