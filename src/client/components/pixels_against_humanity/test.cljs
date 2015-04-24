(ns pixels-against-humanity.test
  (:require [kioo.om :refer [append]]
            [om.core :as om]
            [om.dom :as dom])
  (:require-macros [kioo.om :refer [defsnippet]]))

(defsnippet test-template
  "structure/components/test/index.html"
  [:body]
  [val]
  {[root] (append (dom/h1 nil (pr-str val)))}
  {:resource-wrapper :mini-html})

(defn test-component
  [props owner]
  (reify
    om/IRender
    (render [_]
      (test-template props))))

(defn ^:export -main
  []
  (.log js/console "I'm alive")
  (om/root test-component (atom {})
           {:target (.-body js/document)}))
