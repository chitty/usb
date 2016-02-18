# Makefile para aplicacion Disk Doctor

dd:		dd.o mostrar.o formatear.o
		gcc dd.o mostrar.o formatear.o -o dd
dd.o: 		dd.c dd.h
		gcc -c dd.c
formatear.o: 	formatear.c dd.h
		gcc -c formatear.c
mostrar.o: 	mostrar.c dd.h
		gcc -c mostrar.c
