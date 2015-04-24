(defproject org.apraxis/pixels-against-humanity "0.0.1-SNAPSHOT"
  :description "The Pixels Against Humanity Apraxis Demo Project"
  :url "github.com/apraxis/apraxis"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2727"]
                 [org.apraxis/apraxis "0.0.1-SNAPSHOT"]
                 [io.pedestal/pedestal.jetty "0.3.1"]
                 [ch.qos.logback/logback-classic "1.1.2" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "1.7.7"]
                 [org.slf4j/jcl-over-slf4j "1.7.7"]
                 [org.slf4j/log4j-over-slf4j "1.7.7"]
                 [om "0.8.0-alpha1"]
                 [kioo "0.4.1-SNAPSHOT" :exclusions [com.keminglabs/cljx]]]
  :source-paths ["src/service" "src/client/components"]
  :resource-paths ["target/middleman/build" "target/apraxis-js" "../apraxis/resources"]
  :plugins [[org.apraxis/apraxis "0.0.1-SNAPSHOT"]
            [lein-cljsbuild "1.0.4"]]
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src/client/components"]
                        :compiler {:output-to "target/apraxis-js/js/pixels_against_humanity_client.js"
                                   :output-dir "target/apraxis-js/js/out"
                                        ;:libs ["target/middleman/build"]
                                   :optimizations :none
                                   ;;:source-map "target/apraxis-js/pixels_against_humanity_client.js.map"
                                   :pretty-print true
                                   :preamble ["react/react.js"]
                                   :externs ["react/externs/react.js"]
                                   }}]})
