(ns pixels-against-humanity.test
  (:require [kioo.om :refer [content]]
            [om.core :as om]
            [om.dom :as dom])
  (:require-macros [apraxis.client.template :refer [defroottemplate]]))

(defroottemplate test-template
  [val]
  [:.content] (content (pr-str val)))

(defn ^:export test-component
  [props owner]
  (reify
    om/IRender
    (render [_]
      (test-template props))))
