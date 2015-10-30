(ns pixels-against-humanity.prompt-and-answers-scroll
  (:require [om.core :as om]
            [pixels-against-humanity.prompt-and-answers :as prompt-and-answers]
            [goog.dom]
            [goog.dom.query]
            [goog.dom.classes]
            [goog.style]
            [goog.events]))

;; TODO: Instead of manipulating DOM elements directly in the browser, we *should* be using Om/React to re-render the
;;       prompt-and-answers component with correct CSS classes. The scroll event handler should determine whether
;;       `.prompt-off-screen` should be shown/hiddden and update component state accordingly.

(defn handle-scroll [component e]
  (let [offset (goog.style/getPageOffsetTop (goog.dom/getElementByClass "prompt"))]
    (goog.dom.classes/enable (goog.dom/getElementByClass "prompt-off-screen") "show" (< offset (.-scrollY js/window)))))

(defn ^:export prompt-and-answers-scroll-component
  [props owner]
  (reify
    om/IInitState
    (init-state [_] {:scroll-handler-key nil})
    om/IDidMount
    (did-mount [_]
      (let [k (goog.events/listen js/window goog.events/EventType.SCROLL (partial handle-scroll owner))]
        (om/set-state! owner :scroll-handler-key k)))
    om/IWillUnmount
    (will-unmount [_]
      (when-let [k (om/get-state owner :scroll-handler-key)]
        (goog.events/unlistenByKey k)))
    om/IRender
    (render [_]
      (om/build prompt-and-answers/prompt-and-answers-component props))))

