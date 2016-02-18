import Data.List

permutacion [] = [[]]
permutacion xs = [x:ys | x <- xs, ys <- permutacion (delete x xs)]
