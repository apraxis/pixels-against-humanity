(ns pixels-against-humanity.test
  (:require [apraxis.component :refer [defcomponent]]
            [kioo.om :refer [append]]
            [om.dom :as dom]))

(defcomponent test
  [cursor owner]
  {[:body] (append (dom/h1 nil (str cursor)))})
