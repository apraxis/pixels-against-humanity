(ns pixels-against-humanity.landing
  (:require [kioo.om]
            [om.core :as om])
  (:require-macros [apraxis.client.template :refer [defroottemplate]]))

(defroottemplate landing-template
  [])

(defn ^:export landing-component
  [props owner]
  (reify
    om/IRender
    (render [_]
      (landing-template))))
