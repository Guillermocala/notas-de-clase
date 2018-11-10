//mostrar la suma de los num pares e impares entre 50 y 500
#include <iostream>

using namespace std;

int main(){
	int suma_pares=0, suma_impares=0, i;
	for(i=50; i <= 60; i++){
		if(i%2==0){
			suma_pares += i;
		}
		else if(i%2==1)
			suma_impares +=i ;
	}
	cout << "suma de pares: " << suma_pares << endl; 
	cout << "suma de impares: " << suma_impares << endl;

system("pause");
return 0;
}
