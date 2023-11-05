#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>


int main(void) {
	printf("pid:%d ppid:%d\n", getpid(), getppid());
return EXIT_SUCCESS;
}
