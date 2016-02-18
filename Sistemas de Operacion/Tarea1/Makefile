# Makefile para aplicacion "reportlog"

reportlog:	reportlog.o users.o apps.o
		gcc reportlog.o users.o apps.o -o reportlog
reportlog.o: 	reportlog.c reportlog.h
		gcc -c reportlog.c
users.o: 	users.c reportlog.h
		gcc -c users.c
apps.o: 	apps.c reportlog.h
		gcc -c apps.c
