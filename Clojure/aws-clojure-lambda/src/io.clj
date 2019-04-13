(ns io
    (:gen-class))

; Clojure Read from file one using clojure method other using java libs
(defn Slurper []
    (def string1(slurp "Example.txt"))
    (println string1))
(Slurper)

(defn Reader []
    (with-open [rdr (clojure.java.io/reader "Example.txt")]
    (reduce conj [] (line-seq rdr))))
(Reader)

; Clojure Write to file one using clojure method other using java libs
(defn Spitter []
    (spit "Example.txt"
        "Space Invaders"))

(defn Writer []
    (with-open [w (clojure.java.io/writer "Example.txt" :append true)]
        (.write w (str "\n" "Space" " " "Invaders"))))
(Writer)

(defn Exists [] 
    (println (.exists(clojure.java.io/file "Example.txt"))))
(Exists)
