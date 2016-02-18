createpart: createpart.o tiempo.o
	gcc -o createpart createpart.o tiempo.o
createpart.o: createpart.c inode.h tiempo.h
	gcc -c createpart.c tiempo.c
tiempo.o: tiempo.c tiempo.h
	gcc -c tiempo.c

