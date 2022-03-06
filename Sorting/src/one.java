import java.util.*;

public class one {
    int fixedsize;
    int count = 0;

    /**
     * fubktione sort använder insert sort för att sortera en array intagers, den tar emot antalet element som
     * ska sorteras och sedan gör en array som man läser in alla elementen till. Sedan sorteras arrayen genom
     * att man kollar på det andra elementet om de är större eller mindre än det elementet före. om det är mindre
     * så swappas elementn i exch funktionen. om inte så avslutas inre loopen.
     * @param N
     * @return
     */
    public  int[] sort(int N) {
        Scanner scan = new Scanner(System.in);
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Element "+ i+": ");
            arr[i] = scan.nextInt();
        }
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                swap(arr, j, j - 1);
            }
        }
        return arr;
    }
    //kollar om första argumentet är mindre än andra argumentet.
    private  boolean less(int v, int w) {
        if(v < w){
            return true;
        }
        return false;
    }

    /**
     * funktionen swap byter plats på två element i en array, här räknas även antalet swaps som görs under sorteringen
     * @param a
     * @param i
     * @param j
     */
    private void swap(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
       // System.out.println("\nAntal Swaps: " + (++count));
        ++count;
    }
}
class mainone {
    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        one ny = new one();
        System.out.println("Antalet Element: \n");
        int[] a = ny.sort(scan.nextInt());
        System.out.println("\nAntal Swaps: " + ny.count);
        for (int g : a) {
            System.out.println(g);
        }
    }
}