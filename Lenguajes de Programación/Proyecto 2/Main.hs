{------------------------------------------------------- 
   Proyecto 2 - Dibujando en Funcional
   CI3661 - Laboratorio de Lenguajes de Programación I 
   Carlos Chitty 07-41896
   Martin Freytes 06-39553

   Intérprete utilizado: GHC

   Parte III: Entrada y Salida
--------------------------------------------------------}

import System.IO
import Lienzo
import Instrucciones

ejecutarPrograma :: FilePath -> IO Lienzo 
ejecutarPrograma path = do
                     var <- leer path
		     (x,y) <- dim var
		     insts <- funcion var
		     return $ interpretarBatch (read x, read y) insts

leer path = do
    file <- readFile path
    return $ map words $ lines file

dim var = return $ (head(tail(head var)),head(tail(tail(head var))))

crearInsts :: [[String]] -> [Instruccion]
crearInsts [] = []
crearInsts (v:vs) = (crearInst v):(crearInsts vs)

funcion var = return $ crearInsts $ init (tail var)
	
crearInst :: [String] -> Instruccion
crearInst ("color":c:_) = EstablecerColor (head c)
crearInst ("get":x:y:_) = ObtenerColor (read x + 1, read y + 1)
crearInst ("point":x:y:_) = DibujarPunto (read x + 1, read y + 1)
crearInst ("line":x1:y1:x2:y2:_) = DibujarLinea (read x1 + 1, read y1 + 1) (read x2 + 1, read y2 + 1)
crearInst ("circle":x:y:r:_) = DibujarCirculo (read x + 1, read y + 1) (read r)
crearInst ("fill":x:y:_) = Llenar (read x + 1, read y + 1)
crearInst ("curve":x:y:r:a:_) = DibujarCurva (read x + 1, read y + 1) (read r) (read a)
crearInst ("cpolygon":n:ls) = DibujarPoligono (getPos ls (read n)) True
crearInst ("polygon":n:ls) = DibujarPoligono (getPos ls (read n)) False
crearInst ("rpolygon":x:y:n:l:_) = DibujarPoligonoRegular (read x + 1, read y + 1) (read n) (read l)
crearInst ("triangularize":n:ls) = Triangularizar (getPos ls (read n))

getPos :: [String] -> Integer -> [Posicion]
getPos [] _ = []
getPos (x:y:_) 1 = [(read x, read y)]
getPos (x:y:ls) n = (read x, read y):(getPos ls (n-1))

--exportarLienzo :: Lienzo -> FilePath -> IO ()
