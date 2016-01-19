(defproject org.apraxis/pixels-against-humanity "0.0.1-SNAPSHOT"
  :description "The Pixels Against Humanity Apraxis Demo Project"
  :url "github.com/apraxis/apraxis"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.apraxis/apraxis "0.0.1-SNAPSHOT"]
                 [io.pedestal/pedestal.jetty "0.3.1"]
                 [ch.qos.logback/logback-classic "1.1.2" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "1.7.7"]
                 [org.slf4j/jcl-over-slf4j "1.7.7"]
                 [org.slf4j/log4j-over-slf4j "1.7.7"]
                 [org.omcljs/om "0.9.0"]
                 [kioo "0.4.1" :exclusions [org.clojure/tools.reader com.keminglabs/cljx]]]
  :source-paths ["src/service" "src/client/components"]
  :resource-paths ["target/middleman"
                   "target/apraxis-js"
                   "../apraxis/resources"
                   "resources"]
  :plugins [[org.apraxis/apraxis "0.0.1-SNAPSHOT"]])
