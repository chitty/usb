{------------------------------------------------------- 
   Proyecto 2 - Dibujando en Funcional
   CI3661 - Laboratorio de Lenguajes de Programación I 
   Carlos Chitty 07-41896
   Martin Freytes 06-39553

   Intérprete utilizado: GHC

   Parte II: Lenguaje de Dibujo
--------------------------------------------------------}
module Instrucciones(
  Magnitud
, Instruccion(..)
, interpretarComando
, interpretarBatch
) where

import Lienzo

type Magnitud = Integer

data Instruccion = Limpiar
                 | EstablecerColor Char
                 | ObtenerColor Posicion
                 | DibujarPunto Posicion
                 | DibujarLinea Posicion Posicion
                 | DibujarCirculo Posicion Magnitud
                 | Llenar Posicion
                 | DibujarCurva Posicion Magnitud Magnitud
                 | DibujarPoligono [Posicion] Bool
                 | DibujarPoligonoRegular Posicion Integer Integer
                 | Triangularizar [Posicion]

interpretarComando :: (Lienzo, Char) -> Instruccion -> (Lienzo, Char)
interpretarComando (l,c) Limpiar             = (lienzoVacio (tam l),c)
interpretarComando (l,_) (EstablecerColor n) = (l,n)
interpretarComando (l,_) (ObtenerColor p)    = (l,obtenerColor l p)
interpretarComando (l,c) (DibujarPunto p)    = (dibujarPunto l p c,c)
interpretarComando (l,c) (DibujarLinea p q)  = (dibujarLinea l p (angulo p q) (longitud p q) c,c)
interpretarComando (l,c) (DibujarCirculo p m) = (dibujarCirculo l p m c,c)
interpretarComando (l,c) (Llenar p)           = (llenar l p c,c)
--interpretarComando (l,c) (DibujarCurva p m n)          = (dibujarCurva l p m n c,c)
interpretarComando (l,c) (DibujarPoligono ps b) 
	| (length ps > 2) && b == True  = (dibujarP l (head ps) (ordenar ps) c,c)
	| (length ps > 2) && b == False = (dibujarP l (head ps) ps c,c)
	| otherwise = error "Poligono con menos de 3 lados"
interpretarComando (l,c) (DibujarPoligonoRegular p n m) 
  | n > 2 = (poligonoRegular l p n 0 m c, c)
  | otherwise = error "Poligono con menos de 3 lados"
interpretarComando (l,c) (Triangularizar pts)       
  | length pts >=3 = (triangularizar l (qs pts) c, c) 
  | otherwise = error "deben haber al menos 3 puntos para triangulizar!" 

-- dibujarP dibuja el polígono con el orden dado de posiciones
dibujarP :: Lienzo -> Posicion -> [Posicion] -> Char -> Lienzo
dibujarP l p (p1:[]) c    = dibujarLinea l p1 (angulo p1 p) (longitud p1 p) c
dibujarP l p (p1:p2:ps) c = dibujarP (dibujarLinea l p1 (angulo p1 p2) (longitud p1 p2) c) p (p2:ps) c

-- funcion auxiliar 
-- ordenar, ordena los puntos para dibujar un polígono
ordenar :: [Posicion] -> [Posicion]
ordenar lista =  qs l3 ++ l4 
  where
    l2 = voltearTupla $ qs $ voltearTupla lista -- lista ordenada segun y's
    tam = length lista
    l3 = take (div tam 2) l2
    l4 = drop (div tam 2) l2

-- Quicksort
qs :: (Ord a) => [a] -> [a]
qs [] = []
qs (x:xs) = 
  let menSorted = qs [a | a <- xs, a <= x]
      maySorted = qs [a | a <- xs, a > x]
  in menSorted ++ [x] ++ maySorted 

-- voltearTupla
voltearTupla :: [Posicion] -> [Posicion]
voltearTupla [] = []
voltearTupla ((x,y):xs) = [(y,x)] ++ voltearTupla(xs)

-- poligonoRegular haya los incrementos de los angulos para dibujar
-- un polígono regular
poligonoRegular :: Lienzo -> Posicion -> Integer -> Integer -> Integer -> Char -> Lienzo
poligonoRegular l (x,y) nlados n long c 
  | n < nlados = poligonoRegular l2 (x2,y2) nlados (n+1) long c 
  | otherwise  = l
    where
      l2 = dibujarLinea l (x,y) newAng long c
      beta = pi*(fromInteger nlados-2)/(fromInteger nlados)
      inc = 2*pi / (fromInteger nlados) 
      ang2 = if mod nlados 2 == 0 then 0 else pi/2 - beta/2
      newAng = ang2 + inc*(fromInteger n)
      x2 = x + (round (fromInteger long*(sin newAng)))
      y2 = y + (round (fromInteger long*(cos newAng)))

-- triangularizar
triangularizar :: Lienzo -> [Posicion] -> Char -> Lienzo 
triangularizar l (p1:p2:p3:pts) c 
  | parada = dibujarLinea l2 p3 (angulo p3 p1) (longitud p3 p1) c
  | not parada = triangularizar l4 (p2:p3:pts) c
    where
      parada = null pts
      l2 = dibujarLinea l3 p2 (angulo p2 p3) (longitud p2 p3) c
      l3 = dibujarLinea l p1 (angulo p1 p2) (longitud p1 p2) c
      l4 = dibujarLinea l2 p3 (angulo p3 p1) (longitud p3 p1) c

--función auxiliar angulo
angulo :: Posicion -> Posicion -> Float
angulo (x0,y0) (x1,y1) 
  | (x1-x0) >= 0 && (y1-y0) >= 0 = ang
  | (x1-x0) < 0 && (y1-y0) >= 0  = ang + 2*pi
  | otherwise                    = ang + pi
    where
      undefined = (x1-x0) == 0 && (y1-y0) == 0
      ang = if undefined 
              then 0 
              else atan ((fromInteger (x1-x0)) / (fromInteger (y1-y0)))

--función auxiliar longitud
longitud :: Posicion -> Posicion -> Integer
longitud (x0,y0) (x1,y1) = round (sqrt d2)
  where
    d2 = fromInteger (((x1-x0)*(x1-x0)) + ((y1-y0)*(y1-y0)))

--Interpretamos todas las funciones sobre un lienzo vacio utilizando la funcion
--foldl el cual le efectua a la lista 'is' la funcion interpretarComando
interpretarBatch :: (Integer, Integer) -> [Instruccion] -> Lienzo
interpretarBatch (x,y) is = fst $ foldl interpretarComando (lienzoVacio (x,y),' ') is
