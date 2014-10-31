(ns example.http.server
  (:require [vertx.http :as http]
            [vertx.http.route :as rm]))

(def routes
  (-> (rm/get "/currenttime"
              #(http/end (http/server-response %)
                         (str (System/currentTimeMillis))))
      (rm/all #".*"
              #(http/send-file (http/server-response %) "index.html"))))

(let [port (Integer. (or (System/getenv "PORT") "3000"))]
  (-> (http/server)
      (http/on-request routes)
      (http/listen port))
  (println (str "Starting Http server on port " port)))

