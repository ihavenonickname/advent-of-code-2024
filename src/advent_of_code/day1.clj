(ns advent_of_code.day1
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]))

(defn solution [filepath]
  (println "Day 1")
  (with-open [reader (io/reader filepath)]
    (->> (line-seq reader)
         (filter (complement empty?))
         (map #(str/split % #"\s+"))
         (apply map vector)
         (map (comp (partial map Integer/parseInt) sort))
         (apply map -)
         (map Math/abs)
         (reduce +)
         (println "Part 1:")))
  (with-open [reader (io/reader filepath)]
    (->> (line-seq reader)
         (filter (complement empty?))
         (map #(str/split % #"\s+"))
         (apply map vector)
         (map (partial map Integer/parseInt))
         ((fn [[list1 list2]]
            (let [freq-table (frequencies list2)
                  freq (map #(get freq-table % 0) list1)]
              (map * freq list1))))
         (reduce +)
         (println "Part 2:"))))
