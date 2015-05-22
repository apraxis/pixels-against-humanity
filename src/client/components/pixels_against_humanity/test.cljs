(ns pixels-against-humanity.test
  (:require [kioo.om :refer [content]]
            [om.core :as om]
            [om.dom :as dom])
  (:require-macros [kioo.om :refer [defsnippet]]))

(defsnippet test-template
  "structure/components/test/index.html"
  [:#component-root :> any]
  [val]
  {[:.balls] (content (pr-str val))}
  {:resource-wrapper :mini-html})

(defn ^:export test-component
  [props owner]
  (reify
    om/IRender
    (render [_]
      (test-template props))))
