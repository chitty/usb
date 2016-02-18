# Proyecto 1 (Buscador en Resumenes)
# Traductores e Interpretadores (CI-3725)
# Autores: Carlos Jose Chitty   07-41896
#          Alejandro Rodriguez  04-37507

#!/usr/bin/python
import sys
import re

# Arreglo donde almacenaremos los resumenes.
resumenArray = []

# Cantidad de palabras, oraciones y parrafos de cada resumen
def pop():
    
    palabras = re.compile(r'[\S]*[a-zA-Z0-9]+[\S]*')
    oraciones = re.compile(r'[^.\n]*\.\s')
    parrafos = re.compile(r'[^.\n]*\.\n')
    for i in resumenArray:
        print i[0]
        print "#Palabras: %s" % (len(palabras.findall(i[1])))
        print "#Oraciones: %s" % (len(oraciones.findall(i[1])))
        print "#Parrafos: %s" % (len(parrafos.findall(i[1])))
    
def fc():
    # Tratamos de abrir el archivo de palabras claves indicado
    # como tercer argumento.
    try:
        claves = open(sys.argv[3], "r")
    except IOError:
        print "Archivo de palabras claves no valido!"
    # Definicion del arreglo donde se almacenaran las palabras claves
    # y su ocurrencia.
    arreglo = []
    # Expresion regular que lee cada linea del archivo de palabras claves.
    clave = re.compile(r'[^.\n]*\n')
    for match in re.finditer(clave, claves.read()):
        for i in resumenArray:
            # Expresion regular para encontrar la frase clave exacta en
            # el match.group.
            claveExac = re.compile(r'(?<=\s)'+re.sub("\n$","",match.group(0))+'(?=\s)')
            if re.finditer(claveExac, i[1]):
                # Aqui almacenamos las palabras claves encontradas y la
                # ocurrencia de las mismas para ordenarlas.
                temp = [i[0], re.sub("\n$","",match.group(0)), len(claveExac.findall(i[1]))]
                arreglo.append(temp)
    # Llamada al arreglo de ordenamiento.
    sort(arreglo)
    # Impresion en pantalla con el formato indicado.
    for i in range(0, len(arreglo)):
        if arreglo[i][0] != arreglo[i-1][0]:
            print arreglo[i][0]
        print str(arreglo[i][1]) +":"+ str(arreglo[i][2])
    claves.close()

# Algoritmo para ordenar el arreglo por el titulo, por ocurrencia y por ultimo
# por orden lexicografico.
def sort(el):
    while True:
        for i in range(len(el)-1):
            if (el[i+1][0] < el[i][0]) or (el[i+1][0] == el[i][0] and el[i+1][2] > el[i][2]) or (el[i+1][0] == el[i][0] and el[i+1][2] == el[i][2] and el[i+1][1] < el[i][1]):
                el[i], el[i+1] = el[i+1], el[i]
                break
        else: # not swapped
            break
    return el

# Cantidad de siglas y palabras desconocidas de cada resumen
def sd():
    
    sigla = re.compile("[A-Z0-9][.-_A-Z0-9]*[\s]") # regex sigla
    palabra = re.compile(r'[\S]*[a-zA-Z0-9]+[\S]*') # regex palabra
    
    try:
        diccionario = open(sys.argv[2], "r")
    except IOError:
        print "Archivo de diccionario no valido!"

    # Guarda en vocab todas las palabras del diccionario
    # como expresion regular
    vocab = re.sub('\n','|', diccionario.read())
    diccionario.close()

    try:
        claves = open(sys.argv[3], "r")
    except IOError:
        print "Archivo de palabras claves no valido!"

    # Guarda en vocab2 todas las palabras del archivo de
    # frases clave como expresion regular
    vocab2 = re.sub('\n| ','|', claves.read())
    claves.close()

    if (vocab != "" and vocab2 != ""):
        vocab=vocab+'|'+vocab2
    elif vocab == "":
        vocab = vocab2

    knownWords = r'(?<=\s)('+vocab+r')(?=\s)'
    conocidas = re.compile(knownWords)

    for i in resumenArray:
        siglas = len(sigla.findall(i[1]))
        todas = len(palabra.findall(i[1]))
        lasConocidas = len(conocidas.findall(i[1]))
        print i[0]
        print "#Siglas:", siglas
        print "#Desconocidas:", (todas-lasConocidas-siglas)

if __name__ == "__main__":
    # Verificar que se paso la cantidad de parametros correctos
    if (len(sys.argv) < 5):
	print "Debe pasar 4 parametros: la operacion, archivo diccionario, archivo frases claves y archivo de resumenes"
	sys.exit(0)
        
    # Tratamos de abrir el archivo de resumenes indicado como cuarto argumento.
    try:
        resumen = open(sys.argv[4], "r")
    except IOError:
        print "Archivo de resumenes no valido!"
        
    # Creamos un arreglo de tuplas para almacenar el contenido del archivo de
    # resumenes. En el primer argumento se encuentra el titulo del resumen
    # y en el segundo, el resumen.
    resumenArray = [(x[2], x[0]) for x in re.findall(r'(((.+)\n)(.+\n)+)', resumen.read())]
    resumen.close()

    # Llamada a funcion para contar palabras, oraciones y parrafos.
    if(sys.argv[1] == "-pop"):
        pop()
    # Llamada a funcion para calcular la frecuencia de palabras claves.
    elif (sys.argv[1] == "-fc"):
        fc()
    # Llamada a funcion para contar siglas y palabras desconocidas.
    elif (sys.argv[1] == "-sd"):
        sd()
    else:
        print "Las opciones validas como primer parametro son '-pop', '-fc' y '-sd'."
	print "Intente de nuevo pasando un parametro correcto!"