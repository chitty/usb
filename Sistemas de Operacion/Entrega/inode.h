/* Archivo: Inode.h
   Descripción: contiene definiciones de tipos y constantes utilizadas para crear las particiones. 
   Realizado por: M. Curiel
   Fecha: May 13 2009.

*/


#define BLOCKSIZE 5120  // Tamaño de Bloque en Bytes (5K) 
#define BLOCKDATA (5120 - sizeof(int)) // Tamaño del área de datos.

/* Flags para el campo i_mode del inode */
#define I_REGULAR       0100000
#define I_DIRECTORY     0040000
#define I_BLOCK_SPECIAL 0060000 
#define I_CHAR_SPECIAL  0020000

/* Utilizados para identificar el último bloque de un archivo y un bloque libre. Supongo que una partición 
no va a tener un millon de bloques lógicos  */

#define EMPTY           -1
#define LAST            1000000

/* Definicion de tipos */
typedef  int block_nr;
typedef int real_time;
typedef long file_size;
typedef short int uid;


/* Registro que representa un bloque de datos en el disco */
typedef struct block {
   block_nr next_block;
   char datos[BLOCKDATA];
} tiny_block;

/* Estructura auxiliar para almacenar en memoria la lista de bloques lógicos de un determinado archivo */
typedef struct link_block {
   block_nr nblock;
   struct link_block *next;  
} l_block;

/* Registro del Inodo en disco. noten que sólo tiene el número del primer bloque lógico */
typedef struct inoded {
  unsigned short i_mode;
  uid i_uid;
  real_time i_creattime;
  block_nr first_block;
  file_size fsize;  
} tiny_inodeD;

/* Registro del inodo en la memoria, contiene una lista con los bloques lógicos del archivo */
typedef struct inodem {
  unsigned short i_mode;
  uid i_uid;
  real_time i_creattime;
  l_block *Lblocks, *last;
  file_size fsize;  
} tiny_inodeM;



