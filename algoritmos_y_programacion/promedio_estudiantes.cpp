#include <iostream>

using namespace std;

int main(){
	char cal;// variable tipo caracter que le leera por el usuario.
	float calenpuntos;// valor en puntos segun la calificacion.
	float promedio;// variable que halla el promedio total de los estudiantes.
	float sumapuntos=0;// acomulador que suma los puntos de cada estudiante.
	int numestudiantes;//numero de estudiantes.
	cout << "\tPRMOMEDIO DE ESTUDIANTES\nnotas ingresadas deben ser: (A, B, C, D o E)\n";
	cout << "Ingrese el numero de estudiantes: ";
	cin >> numestudiantes;
	cout << "A continuacion digite las notas de los "<<numestudiantes<<" estudiantes que presentaron la prueba \n\n";
	for(int i=0; i<numestudiantes; i++){ // se entraran loas calificaciones de 20 estudiantes
		cout<<"Entre la calificacion del estudiante # "<<i+1<<": ";//mensaje al ususario que indica el # de estudiante al que se le va a leer la calificacion.
		cin>>cal;//lectura de la calficacion.
		if(cal=='a' || cal=='A'){//asignacion a la variable lalepuntos segun la calificacion.
			calenpuntos=4;
		}else if(cal=='b' || cal=='B'){
			calenpuntos=3;
		}else if(cal=='c' || cal=='C'){
			calenpuntos=2;
		}else if(cal=='d' || cal=='D'){
			calenpuntos=1;
		}else if(cal=='e' || cal=='E'){
			calenpuntos=0;
		}else{
			cout<<endl;
			//mensaje de error en caso de digitar un valor que no sea (a, B, C, D, E) o sus minusculas.
			cout<<"Usted a digitado un valor erroneo. Debe ser (a, b, c, d, e)"<<endl;
		}
		sumapuntos=sumapuntos+calenpuntos;//se halla el promedio con la sumatoria de los puntos entre la cantidad de estudiantes (5).
	}
	promedio=sumapuntos/numestudiantes;
	//se muestra el promedio de los estudiantes al usuario
	cout<<"\nEl promedio de puntos de los "<<numestudiantes<<" estudiantes que presentaron la prueba es: "<<promedio<<"\n\n";

system("PAUSE");
return 0;
}
