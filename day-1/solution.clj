(ns aoc.day1
    (:require [clojure.java.io :as io])
    (:require [clojure.string :as str]))

(with-open [reader (io/reader (first *command-line-args*))]
    (->> (line-seq reader)
        (filter (complement empty?))
        (map #(str/split % #"\s+"))
        (map #(map Integer/parseInt %))
        (reduce (fn [[xs ys] [x y]] [(conj xs x) (conj ys y)]) [[] []])
        ((fn [[xs ys]] (map - (sort xs) (sort ys))))
        (map Math/abs)
        (reduce +)
        (println)))
