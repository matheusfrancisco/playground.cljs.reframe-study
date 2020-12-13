(ns understanding-re-frame.hiccup-basics
  (:require [reagent.core :as reagent]
            [clojure.string :as str]))


(defn cs [& args]
  (str/join " " (map name (filter identity args))))

;;the basics about hiccup
(defn hiccup-panel []
  (let [title "Hello"
        border-color "green"
        active? false]
    [:div {:class (cs "content"
                       "row "
                       (when active?
                         "active"))
           :style {:padding-left "10%"
                   :border (when border-color
                             (str "4px solid " border-color))}}
     [:h1 "Hiccup"]
     [:p "This is a message. "]
     [:input {:type :checkbox
              :checked true}]
     [:p "another paragraph."]
     [:input {:type :email }]
     [:p [:a {:href "#/"} "Home"]]
     [:p "Some more. " [:b "And this is bold"]]]))
