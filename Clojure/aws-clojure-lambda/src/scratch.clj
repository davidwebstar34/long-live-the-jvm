(ns scratch
    (:gen-class))

(defn printMe [] println "Test")
(printMe)

(defn doubleMe [x] (* 2 x))
(doubleMe 5)

(defn multiply [x y] (* x y))
(multiply 2 6)

; https://www.tutorialspoint.com/clojure/clojure_recursion.htm
(defn recursion []
    (loop [i 0]
       (when (< i 5)
       (println i)
       (recur (inc i)))))
 (recursion)

; Java interop
(every? #(Character/isUpperCase %) "HELLO")

(def add
    (fn [a b]
        (println "Adding numbers" a "and" b)
        (+ a b)
    )
)

(defn add [a b]
    (println "Adding numbers" a "and" b)
    (+ a b)
)

(add 3 2)


; (doseq [n (range 10)
;                :let [i (-> n
;                            inc
;                            range
;                            rand-nth)]]                    
;          (go
;            (<! (timeout (* i 1000)))
;            (println n)))

