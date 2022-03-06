#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>
//läser in två filer en läs och en skriv, allt som inte är aplhabetiskt filtreras bort pch ersätts med mellanslag
void filter(FILE *read, FILE *write);
int main(int argc, char *argv[])
{   

    FILE *read = fopen(argv[1], "r");
	FILE *write = fopen(argv[2], "w+");
  
    //lägget till && write sen
    if(read == NULL){
        printf("Filen kan ej öppnas");
        return 0;
    }

    filter(read,write);

    fclose(read);
    fclose(write);
    
}

void filter(FILE *read, FILE *write){
   char c;
    while ((c = fgetc(read)) != EOF){
    
    if ((isalpha(c) == 0) && c != '\n')
    {
        c =' ';
    }
    fputc(c, write);
    }
}
