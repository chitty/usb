# Makefile para aplicacion "EjemploLista"
CFLAGS	= -pg
CC	= gcc
OBJS	= listas.o prueba.o 

prueba:		$(OBJS)
		$(CC) $(CFLAGS) $(OBJS) -o $@


prueba.o:	prueba.c listas.h
		$(CC) $(CFLAGS) -c prueba.c

listas.o:	listas.c listas.h
		$(CC) $(CFLAGS) -c listas.c

clean:
		/bin/rm *.o EjemploLista
