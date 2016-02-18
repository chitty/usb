module Test
  where
x = 5
y = (6, "Hello")
z = x * fst y + x

f x =
  case x of
    0 -> 1
    1 -> 5
    2 -> 2
    _ -> -1

{- Un comentario {- Con otro adentro -} y se 
   acabo -}
roots a b c =
  let det = sqrt (b*b - 4*a*c)
  in ((-b + det) / (2*a),
      (-b - det) / (2*a))

-- 3.7 fibonacci inocente
fib :: Integer -> Integer
fib 1 = 1
fib 2 = 1
fib n = fib (n-1) + fib (n-2)

-- fibonacci smart
fib2 :: Integer -> Integer
fib2 1 = 1
fib2 2 = 1
fib2 n = my_fib 1 1 n

my_fib a b 2 = b
my_fib a b n = my_fib b (a+b) (n-1) 

--3.8
mult :: Integer -> Integer -> Integer
mult a 1 = a
mult a b = a + mult a (b-1)

--3.9
my_map :: (a -> b) -> [a] -> [b]
my_map f []     = []
my_map f (x:xs) = f x : my_map f xs 
