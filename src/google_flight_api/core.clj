(ns google-flight-api.core
  (:require [clojure.set :refer :all])
  (:require [clj-http.client :as client])
  (:require [clojure.data.json :as json]))




(defn extractJson
  "Extract the client_id for now"
  [responseBody]
  (get (json/read-str responseBody) "client_id"))

(defn makeCall
  "Call the url with the auth"
  [url]
  (:body
    (client/get url)))

(defn start
  [url]
  (println
    (extractJson
    (makeCall url
                ))))

(defn -main [] (start "https://api.getmondo.co.uk/ping/whoami"))
;; (defn -main [] (foo "https://api.getmondo.co.uk/ping/whoami"))

(-main)
