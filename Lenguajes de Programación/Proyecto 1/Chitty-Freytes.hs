{-------------------------------------------------------- 
   Proyecto 1 - Codificación y decodificación de mensajes
   CI3661 - Laboratorio de Lenguajes de Programación I 
   Carlos Chitty 07-41896
   Martin Freytes 06-39553
---------------------------------------------------------}

type Mensaje a = [a]
type Codificador  a b = [(a,b)]

-- obtenerCodificador origen destino, es la codificación que se puede obtener de origen a destino.
obtenerCodificador :: Mensaje a -> Mensaje b -> Codificador a b
obtenerCodificador [] [] = []
obtenerCodificador (a:ax) (b:bx) 
 | length ax == length bx = (a, b) : obtenerCodificador ax bx
 | otherwise = error "ERROR: Los tamaños de los mensajes no coinciden!"

-- codificadorValido c, determina si c es un codificador válido o no.
codificadorValido :: (Eq a, Eq b) => Codificador a b -> Bool
codificadorValido [] = True
codificadorValido ((x,y):xs) = valido (x,y) xs && codificadorValido xs

-- funcion auxiliar
-- valido x cod, determina si x es válido según cod
valido :: (Eq a, Eq b) => (a,b) -> Codificador a b -> Bool
valido _ [] = True
valido t (x:xs) 
 | fst t == fst x = snd t == snd x && valido t xs
 | otherwise = valido t xs

-- inversoCodificador c, es el codificador inverso de c
inversoCodificador :: Codificador a b -> Codificador b a
inversoCodificador [] = []
inversoCodificador ((x,y):xs) = [(y,x)] ++ inversoCodificador(xs)

-- codificadorInvertible c, determina si c es un codificador invertible
codificadorInvertible :: (Eq a, Eq b) => Codificador a b -> Bool
codificadorInvertible [] = True
codificadorInvertible (x) = codificadorValido x && codificadorValido(inversoCodificador x)

-- codificarMensaje msg cod, es el mensaje resultande de aplicar cod a msg
codificarMensaje :: (Eq a) => Mensaje a -> Codificador a b -> Mensaje b
codificarMensaje [] _ = []
codificarMensaje (x:xs) y = encontrar x y : codificarMensaje xs y

-- funcion auxiliar 
-- encontrar x cod, es la codificación de x según cod
encontrar :: (Eq a) => a -> Codificador a b -> b
encontrar _ [] = error "ERROR: No se pudo codificar el mensaje!"
encontrar y (x:xs) 
 | y == fst x = snd x
 | otherwise = encontrar y xs
