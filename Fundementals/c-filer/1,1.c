#include <stdio.h>
//funktions declaration 
void reverse();
void iterative();
//global varibler 
int fixedsize = 5;
int main()
{
//reverse();
iterative();
return 0;
}
/**
 * recursiv funktion som läser igenom en rad text tills nyrad läses in, funktionen kallar sig själv 
 * så länge ny rad inte läses in. sedan backar funktonen och printar ut tecken en efter en
 * **/
void reverse(){
    char c = getchar();
    if(c != '\n'){
        reverse(); 
        }
    putchar(c);
    /** 
     * funktionen har en fixad array storlek och hela arrayen fylls med chars tills den är full eller om ny rad läses in,
     * varje gång en ny char läses in så så öker g (antalet element) om ny rad läses in så minskar en g eftersom ny rad räknas inte som element
     * sedan printas arrayen ut bakifrån för att få strängen reverse
     * **/
}
void iterative(){
    char c[fixedsize];
    int g = 0;
    for (int i = 0; i < fixedsize; i++){
        c[i] = getchar();
        g++;
        if(c[i] == '\n'){
            g--;
            break;   
        }
    }
    
    for (int i =  g - 1; i >= 0; i--){
        //printf("3\t");
        putchar(c[i]);
    }
}
    

