(ns pixels-against-humanity.service
  (:require [io.pedestal.http :as bootstrap]
            [io.pedestal.http.route :as route]
            [io.pedestal.http.body-params :as body-params]
            [io.pedestal.http.route.definition :refer [expand-routes]]
            [io.pedestal.http.ring-middlewares :refer [resource]]
            [apraxis.service :as aservice]
            [ring.util.response :as ring-resp]
            [clojure.string :as str]))

(defn routes
  []
  (expand-routes
   `[[["/js/*grob-gob-glob-grod" {:get ~(resource "")}]]]))

;; Consumed by pixels-against-humanity.server/create-server
;; See bootstrap/default-interceptors for additional options you can configure
(defn service
  []
  {:env :prod
   ;; You can bring your own non-default interceptors. Make
   ;; sure you include routing and set it up right for
   ;; dev-mode. If you do, many other keys for configuring
   ;; default interceptors will be ignored.
   ;; :bootstrap/interceptors []
   ::bootstrap/routes routes

   ;; Uncomment next line to enable CORS support, add
   ;; string(s) specifying scheme, host and port for
   ;; allowed source(s):
   ;;
   ;; "http://localhost:8080"
   ;;
   ;;::bootstrap/allowed-origins ["scheme://host:port"]

   ;; Root for resource interceptor that is available by default.
   ::bootstrap/resource-path "/build"

   ;; Either :jetty, :immutant or :tomcat (see comments in project.clj)
   ::bootstrap/type :jetty
   ;;::bootstrap/host "localhost"
   ::bootstrap/port 8080})

(aservice/apraxis-service!)
