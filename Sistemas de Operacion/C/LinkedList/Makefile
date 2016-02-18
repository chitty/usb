# Makefile para aplicacion "EjemploLista"
CFLAGS	= -pg
CC	= gcc
OBJS	= menu.o listas.o EjemploLista.o 

EjemploLista:	$(OBJS)
		$(CC) $(CFLAGS) $(OBJS) -o $@


EjemploLista.o:	EjemploLista.c listas.h
		$(CC) $(CFLAGS) -c EjemploLista.c

menu.o: 	menu.c listas.h
		$(CC) $(CFLAGS) -c $<

listas.o:	listas.c listas.h
		$(CC) $(CFLAGS) -c listas.c

clean:
		/bin/rm *.o EjemploLista
