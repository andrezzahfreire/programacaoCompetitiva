/*
#include <iostream> // biblioteca
using namespace std; //

int main(){ // funcao principal
  cout << "Hello World!";  // cout == seeout objeto, << recebe
  return 0; // final da fun��o
}
 */

 /*#include <iostream>

 int main (){
    // o std :: pode substituir o unsing namespace std
 std::cout << "Hello World!";
 std::cout << "I am learning C++";
 return 0;
 }
*/

/*#include <iostream>
using namespace std;
int main (){

 cout << "Hello World!\n"; // quebra de linha /n
 cout << "I am learning c++" << endl; // /t d� um tab
 return 0;
}
*/

#include <iostream>
using namespace std;
int main (){
    // declara��o de vari�veis
    int myNum = 2;
    double myDouble = 2.1;
    char myChar = 'o';
    string myString = "oi";
    bool myBool = true;
    int myAge = 18;
    int soma;
    // operador de soma
    soma = myNum+ myDouble;

    cout << myNum <<endl;
    cout << myChar <<endl;
    cout << myDouble <<endl;
    cout << myString <<endl;
    cout << myBool <<endl;
    cout <<"I am " << myAge <<" Years old" << endl;
    cout << soma;
    return 0;
}
