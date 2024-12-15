(ns aoc.day1
    (:require
        [clojure.java.io :as io]
        [clojure.string :as str]))

(with-open [reader (io/reader (first *command-line-args*))]
    (->> (line-seq reader)
        (filter (complement empty?))
        (map #(str/split % #"\s+"))
        (apply map vector)
        (map (comp (partial map Integer/parseInt) sort))
        (apply map -)
        (map Math/abs)
        (reduce +)
        (println)))
