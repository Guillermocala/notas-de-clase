#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

extern char **environ;

int main(void) {
	

	//obtener toda la lista de variables de entorno
	char **list = environ;
	char *var;
	//while(*list!=NULL){
	//	printf("%s\n", *list);
	//	list ++;
	//}
	
	//obtener el valor de una variable especifica
	var = getenv("PATH");
	printf("%s\n", var);
	return EXIT_SUCCESS;
}
