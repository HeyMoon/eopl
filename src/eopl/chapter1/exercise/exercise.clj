(ns eopl.chapter1.exercise.exercise)

;;1.15
(defn duple-auxiliary [n x]
  (if (zero? n)
    '()
    (cons x (duple-auxiliary (dec n) x))))

(defn duple [n x]
  (if (zero? n)
    '()
    (duple-auxiliary n x)))

;;1.16
(defn invert-auxiliary [lst]
  (conj '() (first lst) (second lst)))

(defn invert [lst]
  (if (empty? lst)
    '()
    (cons (invert-auxiliary (first lst)) (invert (rest lst)))))

;;1.17
(defn wrap-with-parentheses [s]
  (cons s '()))

(defn down [lst]
  (if (empty? lst)
    '()
    (cons (wrap-with-parentheses (first lst)) (down (rest lst)))))


;;1.18
(declare swapper)
(defn swapper-in-s-expression [s1 s2 slist]
  (if (sequential? slist)
    (swapper s1 s2 slist)
    (condp = slist
      s1 s2
      s2 s1
      slist)))

(defn swapper [s1 s2 slist]
  (if (empty? slist)
    '()
    (cons (swapper-in-s-expression s1 s2 (first slist)) (swapper s1 s2 (rest slist)))))

;;1.19 returns a list like lst, except that the n-th element, using zero-based indexing, is x.
;;return the n elements of the list,using the zero-based indexing.
(defn list-set-in [list n idx x]
  (if (= idx n)
    (cons x (rest list))
    (cons (first list) (list-set-in (rest list) n (inc idx) x))))

(defn list-set [list n x]
  (list-set-in list n 0 x))

;;1.20
(declare count-occurrences)
(defn count-occurrences-in [s list]
  (if (sequential? list)
    (count-occurrences s list)
    (if (= s list) 1 0)))

(defn count-occurrences [s list]
  (if (empty? list)
    0
    (+
      (count-occurrences-in s (first list))
      (count-occurrences s (rest list)))))

;;1.21
(defn product [sos1 sos2]
  (loop [result '() s1 sos1 s2 sos2]
    (if (or (empty? s1) (empty? s2))
      result
      ())))





