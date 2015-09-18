(ns pixels-against-humanity.card
  (:require [kioo.om :refer [content add-class do->]]
            [om.core :as om]
            [om.dom :as dom]
            [goog.string.format]
            [goog.string :as gstring]
            [clojure.string :as str])
  (:require-macros [apraxis.client.template :refer [defsnippet]]))

(defsnippet card-template
  "build/structure/components/card/index.html"
  [:#component-root :> any]
  [type answers selected winner cnt text]
  {[self] #(cond-> %
                   (> (count text) 40) ((add-class "tiny-text"))
                   (= :answer type) ((add-class "answer"))
                   (= :waiting type) ((add-class "waiting"))
                   selected ((add-class "selected"))
                   winner ((add-class "winner")))
   [:.content] (content (if (= :waiting type)
                          (gstring/format "Waiting on %d more..." cnt)
                          (str/replace text #"\[\]" "_______")))
   [:.instructions] (if (or (not= type :prompt)
                            (< answers 2))
                      (constantly nil)
                      identity)
   [:.instructions :.pick :span] (content answers)
   [:.instructions :.draw] (if (= answers 3)
                             identity
                             (constantly nil))}
  {:resource-wrapper :mini-html})

(defn ^:export card-component
  [{:keys [type answers selected winner count text] :as props} owner]
  (reify
    om/IRender
    (render [_]
      (let [prompt? (= type :prompt)
            answers (if (and prompt? (nil? answers))
                      1
                      answers)]
       (card-template type answers selected winner count text)))))
