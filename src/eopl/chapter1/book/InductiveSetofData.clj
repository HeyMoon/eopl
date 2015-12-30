(ns eopl.chapter1.book.InductiveSetofData)

(defn in-S? [n]
  (if (zero? n)
    true
    (if (>= (- n 3) 0)
      (in-S? (- n 3))
      false)))

;;(-7 . (3 . (14 . ())))
;;List-Of-Int
;;-->(Int . List-Of-Int)
;;-->(-7 .List-Of-Int)
;;-->(-7 .(Int .List-Of-Int))
;;-->(-7 .(3 .(Int . List-Of-Int)))
;;-->(-7 .(3 .(14 .())))

;; LcExp ::= Identifier
;; ::= (lambda (Identifier) LcExp)
;; ::= (LcExp LcExp)
;;

(defn list-length [coll]
  (if (empty? coll)
    0
    (+ 1 (list-length (rest coll)))))

(defn predicate-check? [coll idx]
  (if (empty? coll)
    (do (println "the coll is empty") false)
     (if (< (list-length coll) idx)
       (do (println coll "does not have" idx "element") false)
       true)))

(defn nth-element [coll idx]
  (if (predicate-check? coll idx)
  (if (zero? idx)
    (first coll)
    (recur (rest coll) (dec idx)))))


(defn remove-first [s los]
  (if ((complement empty?) los)
    (if (= s (first los))
      (rest los)
      (conj (remove-first s (rest los)) (first los))) '()))


(defn my-remove [s los]
  (if (empty? los)
    '()
    (if (= s (first los))
      (my-remove s (rest los))
           (conj (my-remove s (rest los)) (first los)))))

;;LcExp ::= Identifier
;;      ::= (lamdba (Identifier) LcExp)
;;      ::= (LcExp LcExp)

(defn subst-in-s-expression [new old slist]
  (if (sequential? slist)
    (subst new old  slist)
    (if (= old slist) new slist)))

(defn subst [new old slist]
  (if (empty? slist)
    '()
    (cons (subst-in-s-expression new old (first slist)) (subst new old (rest slist)))))











