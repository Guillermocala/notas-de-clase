#include <stdio.h>
#include <unistd.h>

int main(int argc, char * argv[]){  
	pid_t pidhijo;
	int valor_a, valor_b;
	
	
	pidhijo = fork();	
	if(pidhijo == 0){
		printf("proceso hijo\n");
		valor_a = 3;
	}
	else{
		valor_b = 5;
		printf("proceso padre %d\n", valor_a+valor_b);
	}

	return 0; 
}