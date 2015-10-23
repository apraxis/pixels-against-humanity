(ns pixels-against-humanity.prompt-and-answers
  (:require [kioo.om :refer [substitute content add-class]]
            [om.core :as om]
            [pixels-against-humanity.card :as card])
  (:require-macros [apraxis.client.template :refer [defsnippet]]))

(defsnippet prompt-and-answers-template
  "build/structure/components/prompt-and-answers/index.html"
  [:#component-root :> any]
  [{:keys [user-is-tzar prompt answers waiting-count]}]
  {[root] (add-class (when user-is-tzar "user-is-tzar"))
   [:.prompt :.card] (substitute (om/build card/card-component (merge prompt {:type :prompt})))
   [:.cards] (let [answers (map #(merge % {:type :answer}) answers)
                   waiting (when (and waiting-count (pos? waiting-count))
                             [{:type :waiting :count waiting-count}])]
               (content (om/build-all card/card-component (concat answers waiting))))}
  {:resource-wrapper :mini-html})

(defn ^:export prompt-and-answers-component
  [props owner]
  (reify
    om/IRender
    (render [_]
      (prompt-and-answers-template props))))
