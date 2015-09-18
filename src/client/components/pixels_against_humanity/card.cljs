(ns pixels-against-humanity.card
  (:require [kioo.om :refer [content add-class do->]]
            [om.core :as om]
            [om.dom :as dom]
            [goog.string.format]
            [goog.string :as gstring])
  (:require-macros [apraxis.client.template :refer [defsnippet]]))

(defsnippet card-template
  "build/structure/components/card/index.html"
  [:#component-root :> any]
  [type answers selected winner cnt text]
  {[self] (do->
           (if (> (count text) 40)
             (add-class "tiny-text")
             identity)
           (if (= :answer type)
             (add-class "answer")
             identity)
           (if (= :waiting type)
             (add-class "waiting")
             identity)
           (if selected
             (add-class "selected")
             identity)
           (if winner
             (add-class "winner")
             identity))
   [:.content] (content (if (= :waiting type)
                          (gstring/format "Waiting on %d more..." cnt)
                          text))}
  {:resource-wrapper :mini-html})

(defn ^:export card-component
  [{:keys [type answers selected winner count text] :as props} owner]
  (reify
    om/IRender
    (render [_]
      (card-template type answers selected winner count text))))
