(ns example2.core
  (:require [vertx.http :as http]
            [vertx.http.route :as rm]
            [clj-time.core :as t]
            [clj-time.coerce :as tc]))

(def routes
  (-> (rm/get "/currenttime"
              #(http/end (http/server-response %)
                         (-> (t/now) tc/to-long str)))
      (rm/all #".*"
              #(http/send-file (http/server-response %) "index.html"))))

(defn init
  []
  (let [port (Integer. (or (System/getenv "PORT") "3000"))]
    (-> (http/server)
        (http/on-request routes)
        (http/listen port))
    (println (str "Starting Http server on port " port))))
