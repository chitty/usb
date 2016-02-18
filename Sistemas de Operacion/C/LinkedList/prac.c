#include <stdio.h>
#include <fcntl.h> // para los del open
#include <unistd.h> // para el STDOUT_FILENO

int main(int argc, char **argv){

  int fd;
  fd = open(argv[1],O_CREAT | O_TRUNC | O_WRONLY, 0600);
  dup2(fd,STDOUT_FILENO);
  close(fd);
  execvp(argv[2],&argv[2]);
  perror("main");

  return 0;
}
