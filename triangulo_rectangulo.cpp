#include <iostream>

using namespace std;

int contfilas = 0;
int base, cuenta = 0;

int main(){
	cout << "\tTRIANGULO CON BASE O ALTURA" << endl;
	cout << "Entre la base o altura: ";
	cin >> base;
	contfilas = base;
	while(contfilas >= 1){
		while(cuenta < contfilas){
			cout << "*";
			cuenta = cuenta + 1;
		}
		contfilas = contfilas - 1;
		cuenta = 0;
		cout << "\n";
	}
system("pause");
return 0;
}
