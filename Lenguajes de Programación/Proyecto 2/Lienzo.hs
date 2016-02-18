{------------------------------------------------------- 
   Proyecto 2 - Dibujando en Funcional
   CI3661 - Laboratorio de Lenguajes de Programación I 
   Carlos Chitty 07-41896
   Martin Freytes 06-39553

   Intérprete utilizado: GHC

   Parte I: Definición de tipos de datos
--------------------------------------------------------}
module Lienzo(
  Lienzo
, Posicion
, lienzoValido
, lienzoVacio
, dibujarPunto
, dibujarLinea
, llenar
, dibujarCirculo
, obtenerColor
, tam
, extremoIzquierdo
, longitudD
, posVal
) where

data Lienzo = MkLienzo (Integer, Integer) [[Char]]
instance Show Lienzo where
  show (MkLienzo (x,y) z) = borde ++ showLienzo z ++ borde
    where showLienzo []     = "\n"
          showLienzo (r:rs) = "\n*" ++ r ++ "*" ++ (showLienzo rs)
          borde             = replicate (fromInteger y+2) '*'

type Posicion = (Integer, Integer)

--lienzoValido l, si el lienzo l es válido o no
lienzoValido :: Lienzo -> Bool
lienzoValido (MkLienzo (x,y) z) = fromInteger x == length z && lienzoVal y z

--Función auxiliar
--lienzoVal, si el ancho del lienzo es válido
lienzoVal :: Integer -> [[Char]] -> Bool
lienzoVal y [] = True
lienzoVal y (z:zs) = fromInteger y == length z && lienzoVal y zs

--lienzoVacio (x, y) crea un lienzo de altura x y ancho y
lienzoVacio :: (Integer, Integer) -> Lienzo
lienzoVacio (x,y) 
 | x > 0 && y > 0 = MkLienzo (fromInteger x, fromInteger y) (replicate (fromInteger x) (replicate (fromInteger y) ' '))
 | otherwise = error "Las dimensiones del lienzo no son válidas!"

--dibujarPunto l pos c, dibuja en la posicion pos el caracter c en el lienzo l
dibujarPunto :: Lienzo -> Posicion -> Char -> Lienzo
dibujarPunto (MkLienzo t z) (x,y) c 
  | fst t >= x && snd t >= y = MkLienzo t $ (take (fromInteger x-1) z) ++ (dibujarC (z!!(fromInteger x-1)) y c) : (drop (fromInteger x) z)
  | otherwise = error "No se puede dibujar el punto ya que está fuera del lienzo!"

--Función auxiliar
--dibujarC z y c, coloca el caracter c en la posicion y de la lista z
dibujarC :: [Char] -> Integer -> Char -> [Char]
dibujarC z y c = (take (fromInteger y-1) z) ++ c : (drop (fromInteger y) z)

--dibujarLinea l pos a c, dibuja en el lienzo l, partiendo desde pos, una línea
--                        de longitud l y ángulo a (en radianes), usando c
dibujarLinea :: Lienzo -> Posicion -> Float -> Integer -> Char -> Lienzo
dibujarLinea lienzo (x0,y0) a l c 
  | (posVal lienzo (x0,y0)) && enX && x1  > x0 = dda  lienzo (x0,y0) (x1,y1) (fromInteger x0,fromInteger y0) c
  | (posVal lienzo (x0,y0)) && enX && x1 <= x0 = dda  lienzo (x1,y1) (x0,y0) (fromInteger x1,fromInteger y1) c
  | (posVal lienzo (x0,y0)) && enY && y1  > y0 = dda2 lienzo (x0,y0) (x1,y1) (fromInteger x0,fromInteger y0) c
  | (posVal lienzo (x0,y0)) && enY && y1 <= y0 = dda2 lienzo (x1,y1) (x0,y0) (fromInteger x1,fromInteger y1) c
  | otherwise = error "La línea no puede se dibujada, se sale del lienzo!"
    where
      enX = abs (x1-x0) >= abs (y1-y0)
      enY = abs (x1-x0) <  abs(y1-y0)
      x1 = (x0 + (round (fromInteger l*(sin a))))
      y1 = (y0 + (round (fromInteger l*(cos a))))

-- funcion auxiliar dda
-- Implementación del algoritmo DDA para dibujar linea cuando deltaX >= deltaY
dda :: Lienzo -> Posicion -> Posicion -> (Integer,Float) -> Char -> Lienzo
dda lienzo (x0,y0) (x1,y1) (x,y) c
  | parar = dibujarPunto lienzo (x,round y) c
  | otherwise = dda l2 (x0,y0) (x1,y1) (x+1,y2) c
    where
      deltaX = fromInteger (x1 - x0)
      deltaY = fromInteger (y1 - y0)
      parar = x == x1
      y2 = y + deltaY/deltaX
      l2 = dibujarPunto lienzo (x,round y) c

-- funcion auxiliar dda2
-- Implementación del algoritmo DDA para dibujar linea cuando deltaY > deltaX
dda2 :: Lienzo -> Posicion -> Posicion -> (Float,Integer) -> Char -> Lienzo
dda2 lienzo (x0,y0) (x1,y1) (x,y) c
  | parar = dibujarPunto lienzo (round x,y) c
  | otherwise = dda2 l2 (x0,y0) (x1,y1) (x2,y+1) c
    where
      deltaX = fromInteger (x1 - x0)
      deltaY = fromInteger (y1 - y0)
      parar = y == y1
      x2 = x + deltaX/deltaY
      l2 = dibujarPunto lienzo (round x,y) c

--llenar
llenar :: Lienzo -> Posicion -> Char -> Lienzo
llenar lienzo (x,y) c
  | posVal lienzo (x,y) = llenarAbajo lienzoAr (x,y) c (obtenerColor lienzo (x,y))
  | otherwise = error "La posición dada es inválida!"
    where
      lienzoAr = llenarArriba lienzo (x-1,y) c (obtenerColor lienzo (x,y))

llenarArriba :: Lienzo -> Posicion -> Char -> Char -> Lienzo
llenarArriba l (x,y) c o
  | posVal l (x,y) && (obtenerColor l (x,y) == o) = llenarArriba lx (x-1,y) c o 
  | otherwise = l
    where
      lx = dibujarLinea l (extremoIzquierdo l (x,y) o) 0 (longitudD l (extremoIzquierdo l (x,y) o) o 0) c

llenarAbajo :: Lienzo -> Posicion -> Char -> Char -> Lienzo
llenarAbajo l (x,y) c o
  | posVal l (x,y) && (obtenerColor l (x,y) == o) = llenarAbajo lx (x+1,y) c o 
  | otherwise = l
    where
      lx = dibujarLinea l (extremoIzquierdo l (x,y) o) 0 (longitudD l (extremoIzquierdo l (x,y) o) o 0) c

extremoIzquierdo :: Lienzo -> Posicion -> Char -> Posicion
extremoIzquierdo l (x,y) o
  | posVal l (x,y) && obtenerColor l (x,y) == o = extremoIzquierdo l (x,y-1) o
  | otherwise = (x,y+1)

posVal :: Lienzo -> Posicion -> Bool
posVal l (x,y) = x <= fst (tam l) && x > 0 && y > 0 && y <= snd (tam l)

longitudD :: Lienzo -> Posicion -> Char -> Integer -> Integer
longitudD l (x,y) o i
  | posVal l (x,y) && obtenerColor l (x,y) == o = longitudD l (x,y+1) o (i+1)
  | otherwise = i-1
   
--dibujarCirculo l pos r c, dibuja un circulo con centro pos y radio r en 
--                          el lienzo l usando c 
dibujarCirculo :: Lienzo -> Posicion -> Integer -> Char -> Lienzo
dibujarCirculo lienzo (x,y) r c = drawCircle lienzo (x,y) (-r) r c

-- función auxiliar drawCircle
-- dibuja el círculo tomando 8 puntos de simetría
drawCircle l (x0,y0) x r c
  | x < y = drawCircle l2 (x0,y0) (x+1) r c  
  | otherwise = dibujarPunto l2 (x0+x,y0+y) c
    where
      r2 = fromInteger (r*r)
      y = round (sqrt ((r2 - fromInteger(x*x) ) + 0.5))
      l2 = dibujarPunto l3 (x0+x,y0-y) c
      l3 = dibujarPunto l4 (x0+x,y0+y) c
      l4 = dibujarPunto l5 (x0-x,y0+y) c
      l5 = dibujarPunto l6 (x0-x,y0-y) c
      l6 = dibujarPunto l7 (x0+y,y0-x) c
      l7 = dibujarPunto l8 (x0+y,y0+x) c
      l8 = dibujarPunto l9 (x0-y,y0+x) c
      l9 = dibujarPunto l (x0-y,y0-x) c

--obtenerColor l pos, es el color ubicado en pos dentro del lienzo l.
obtenerColor :: Lienzo -> Posicion -> Char
obtenerColor (MkLienzo t z) (x,y) 
  | posiVal   = (z !! (fromInteger x-1)) !! (fromInteger y-1)
  | otherwise = error "La posición dada es inválida!"
    where
      posiVal = x>0 && y>0 && x <= fst t && y <= snd t

-- función auxiliar para obtener las dimensiones de un lienzo
tam :: Lienzo -> (Integer, Integer)
tam (MkLienzo l s) = l
