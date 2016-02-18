# Makefile para aplicacion "Difumensajes II"

# Autor: Carlos Chitty 07-41896


all: 			difuImpl.class usu.class difu.class difuImpl_Stub.class auteImpl.class auteImpl_Stub.class aute.class

difuImpl_Stub.class:	difuImpl.java difuInterfaz.java
			rmic difuImpl
difu.class:		difu.java
			javac difu.java 
difuImpl.class:		difuImpl.java difuInterfaz.java
			javac difuImpl.java

auteImpl_Stub.class:	auteImpl.java auteInterfaz.java
			rmic auteImpl
aute.class:		aute.java funcionesXML.java
			javac aute.java 
auteImpl.class:		auteImpl.java auteInterfaz.java funcionesXML.java Cuenta.java
			javac auteImpl.java
funcionesXML.class:	funcionesXML.java
			javac funcionesXML.java
Cuenta.class:		Cuenta.java
			javac Cuenta.java

usu.class:		usu.java Console.java MD5.java
			javac usu.java 
MD5.class:		MD5.java
			javac MD5.java
Console.class:		Console.java
			javac Console.java
