monedas = [ 1000, 500, 100, 50, 20, 10 ]

enMonedas 0     = [[]]
enMonedas monto = [ m:ms | m <- monedas, monto >= m, ms <- enMonedas (monto - m) ]

divisores :: Integer -> [Integer]
divisores n = [ i | i <- [1..n], mod n i == 0 ]

perfectos :: [Integer]
perfectos = [ x | x <- [1..], (sum.init.divisores) x == x ]

nub' [] = []
nub' (x:xs)
 | elem x xs = nub' xs
 | otherwise = x:nub' xs
