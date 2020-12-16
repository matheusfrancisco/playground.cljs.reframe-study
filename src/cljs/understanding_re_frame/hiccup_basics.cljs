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
    [:div#main-content.content.row {:id "main-content"
           :class (when active?
                         "active")
           :style {:padding-left "10%"
                   :border (when border-color
                             (str "4px solid " border-color))}}
     [:h1#hiccup.big "Hiccup"]
     [:div.wrapper
      {:style {:width 100}
       :on-click (fn [e]
                   (js/console.log "Wrapper Dive"))}
      [:div.container
       [:div.inner
        {:on-click (fn [e]
                     (.stopPropagation e)
                     (js/console.log "Inner div")
                     (js/console.log (.-target e)))}
        [:p "some content"]
        [:p "other content"]]]]
     [:div.wrapper>div.container>di.inner
        [:p "some content"]
        [:p "other content"]]
     [:p "This is a message. "]
     [:input {:type :checkbox
              :checked true}]
     [:p "another paragraph."]
     [:input {:type :email }]
     [:p [:a {:href "#/"
              :on-click (fn [e]
                          (.preventDefault e)
                          (.stopPropagation e)
                          (js/console.log "Link"))} "Home"]]
     [:p "Some more. " [:b "And this is bold"]]]))
