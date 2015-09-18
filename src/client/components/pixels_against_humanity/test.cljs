(ns pixels-against-humanity.test
  (:require [kioo.om :refer [content]]
            [om.core :as om]
            [om.dom :as dom])
  (:require-macros [apraxis.client.template :refer [defsnippet]]))

(defsnippet test-template
  "build/structure/components/test/index.html"
  [:#component-root :> any]
  [val]
  {[:.content] (content (pr-str val))}
  {:resource-wrapper :mini-html})

(defn ^:export test-component
  [props owner]
  (reify
    om/IRender
    (render [_]
      (test-template props))))
