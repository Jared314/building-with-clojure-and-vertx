(defproject example2 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-time "0.8.0"]]
  :plugins [[lein-vertx "0.3.1"]]
  :vertx {:main example2.core/init
          :author "FIXME: Your name"
          :keywords ["FIXME: keywords"]
          :developers ["FIXME: other developers"]})
