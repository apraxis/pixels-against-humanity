(ns pixels-against-humanity.player-setup
  (:require [kioo.om :refer [do-> set-attr remove-attr listen remove-class]]
            [om.core :as om])
  (:require-macros [apraxis.client.template :refer [defroottemplate]]))

(defn game-id-change
  [props event]
  (om/update! props :game-id (-> event
                                 .-target
                                 .-value)))

(defn name-change
  [props event]
  (om/update! props :name (-> event
                              .-target
                              .-value)))

(defroottemplate player-setup-template
  [props]
  [:label.game-id :span.transparent] (if (zero? (count (:game-id props)))
                                       identity
                                       (remove-class "transparent"))
  [:label.game-id :input] (do-> (listen :on-change (partial game-id-change props))
                                (set-attr :value (:game-id props)))
  [:label.name :span.transparent] (if (zero? (count (:name props)))
                                    identity
                                    (remove-class "transparent"))
  [:label.name :input] (do-> (listen :on-change (partial name-change props))
                             (set-attr :value (:name props)))
  [:button.play] (if (zero? (count (:name props)))
                   (set-attr :disabled "disabled")
                   (remove-attr :disabled)))

(defn ^:export player-setup-component
  [props owner]
  (reify
    om/IRender
    (render [_]
      (player-setup-template props))))
