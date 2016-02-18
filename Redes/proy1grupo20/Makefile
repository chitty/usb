# Makefile para aplicacion "hproxy"

hproxy:		listas.o hproxy.o errors.o sockutil.o funciones.o
		gcc listas.o hproxy.o errors.o sockutil.o funciones.o -o $@

hproxy.o:	hproxy.c listas.h
		gcc -c hproxy.c

funciones.o:	funciones.c funciones.h
		gcc -c funciones.c

errors.o:	errors.c errors.h
		gcc -c errors.c

sockutil.o:	sockutil.c sockutil.h
		gcc -c sockutil.c

listas.o:	listas.c listas.h
		gcc -c listas.c
