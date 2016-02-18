module Main
  where

import IO

main = do
  hSetBuffering stdin LineBuffering
  lista <- funcion
  let sum = foldl (+) 0 (map read lista)
  let pro = foldl (*) 1 (map read lista)
  let fact = map (factorial) (map read lista)
  putStrLn("la suma es: " ++ (show sum) )
  putStrLn("el producto: " ++ (show pro) )
  putStrLn("factoriales: " ++ (show fact) )
  
factorial :: Integer -> Integer
factorial 0 = 1
factorial n 
 | n > 0 = n * factorial(n - 1)
 | otherwise = error "Negative number!"

funcion = do
  putStrLn "Give me a number (or 0 to stop)"
  num <- getLine
  if read num == 0
    then return []
    else do
      rest <- funcion
      return (num:rest)
