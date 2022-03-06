#include <stdlib.h>
#include <stdio.h>

int main(){
    /**
     * skapar ny array och sätter in element med scanf
     * */
printf("ange antalet element: ");
int N;
scanf("%i", &N);
int arr[N];
for(int i = 0; i < N; i++ ){
    printf("Element: %i ",i);
    scanf("%i", &arr[i]);
}

/**
 * en temp variable används för att byta plats på element. 
 * Sedan går man igenom hela listan och letar element vilket ger O(N) 
 * time complexity. Om ett negativ tal hittas så placeras den på första
 * plats och nästa på andra osv. Memory complexity blir O(1); i
 * bästa fall görs inga byten och i värsta så byter man alla element
 * 
 * */
int pos = 0;
int temp;
    for(int i = 0; i < N;i++){
        if(arr[i] < 0){
            temp = arr[pos];
            arr[pos++] = arr[i];
            arr[i] = temp;
        }
    }
 //printar bar att alla elementen i arrayn
    for(int i = 0; i < N;i++){
        printf("%i", arr[i]);
        printf("   ");
    }

}