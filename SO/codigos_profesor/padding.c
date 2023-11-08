#include <stdio.h>
#include <wait.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

#define MAX_BUFF 1024

struct data{
   char c;
   char d;
   char e;
   char f;
   int a;
   float b;    //sizeof(struct) > (sizeof(int) + sizeof(float))

};

int main(){
   printf("sizeof(struct data)=%d\n", (int)sizeof(struct data));
   printf("sizeof(int)=%d sizeof(float)=%d\n", (int)sizeof(int), (int)sizeof(float));
   printf("sizeof(char)=%d \n", (int)sizeof(char));

   return EXIT_SUCCESS;
}