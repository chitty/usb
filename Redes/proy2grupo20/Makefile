# Makefile para aplicacion "DIFUMENSAJES"

all: 			difu usu

# PROGRAMA difu
difu:			difu.o chapProtocol.o difuThread.o MD5.o funcionesXML.o nanoxml-lite-2.2.3.o Console.o
			gcj --main=difu -o difu difu.o chapProtocol.o difuThread.o MD5.o funcionesXML.o nanoxml-lite-2.2.3.o Console.o
difu.o: 		difu.java 
			gcj -c -g -O difu.java 
chapProtocol.o: 	chapProtocol.java 
			gcj -c -g -O chapProtocol.java 
difuThread.o: 		difuThread.java 
			gcj -c -g -O difuThread.java 
funcionesXML.o:		funcionesXML.java
			gcj -c funcionesXML.java
nanoxml-lite-2.2.3.o:	nanoxml-lite-2.2.3.jar
			gcj -c nanoxml-lite-2.2.3.jar

# PROGRAMA usu
usu:			usu.o MD5.o Console.o
			gcj --main=usu -o usu usu.o MD5.o Console.o
usu.o: 			usu.java 
			gcj -c -g -O usu.java 
MD5.o:		 	MD5.java 
			gcj -c -g -O MD5.java
Console.o:		Console.java 
			gcj -c -g -O Console.java
