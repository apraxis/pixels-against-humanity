(ns pixels-against-humanity.prompt-and-answers
  (:require [kioo.om :refer [do-> substitute content add-class]]
            [om.core :as om]
            [pixels-against-humanity.card :as card])
  (:require-macros [apraxis.client.template :refer [defroottemplate]]))

(defroottemplate prompt-and-answers-template
  [{:keys [user-is-tzar prompt answers waiting-count]}]
  [root] (add-class (when user-is-tzar "user-is-tzar"))
  [:.prompt :.card] (substitute (om/build card/card-component (merge prompt {:type :prompt})))
  [:.cards] (let [answers (map #(merge % {:type :answer}) answers)
                  waiting (when (and waiting-count (pos? waiting-count))
                            [{:type :waiting :count waiting-count}])
                  cards-class (cond
                                (and user-is-tzar
                                     (pos? (count answers))
                                     (empty? (filter :winner answers)))
                                "select-winner"
                                (and (not user-is-tzar)
                                     (pos? (count answers))
                                     (empty? (filter :selected answers))
                                     (empty? (filter :winner answers))
                                     (not (:winner prompt)))
                                "select-to-play")]
              (do-> (add-class cards-class)
                    (content (om/build-all card/card-component (concat answers waiting))))))

(defn ^:export prompt-and-answers-component
  [props owner]
  (reify
    om/IRender
    (render [_]
      (prompt-and-answers-template props))))
