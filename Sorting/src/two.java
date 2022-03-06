import java.util.Scanner;

public class two {
    int count = 0;
    int inv = 0;
    public  int[] sort( int[] arr) {
        int N = arr.length;

        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                swap(arr, j, j - 1);
            }
        }
        return arr;
    }

    /**
     * räknar antalet inversions och sedan skriver ut både positions på båda talen som ska bytas och returnerar
     * antalet inversions. två näslande loopar går igenom men börjar jämnföra från i+1 på inersta loopen för att får
     * mindre jämnförelser vilket ger time complexity (n-1)(n-2)(n-3)....n(n-1)/2
     * @param arr
     * @return
     */

    public int inversions(int arr[]){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < arr.length - 1;i++){
            for(int j = i+1;j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    count++;
                    sb.append("["+i+","+arr[i]+"]"+","+"["+j+","+arr[j]+"]"+"\t");
                }
            }
        }
        System.out.println(sb.toString());
        return count;
    }

    /** kollar om första argumentet är mindre än andra argumentet.
     */
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
        ++count;
    }
}
//Main funktion
class maintwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        two ny = new two();
        System.out.println("Antalet Element: \n");
        int N = scan.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Element "+ i+": ");
            arr[i] = scan.nextInt();
        }
        N = ny.inversions(arr);
        arr = ny.sort(arr);
        System.out.println("\nAntal inversions: " + N);
        for (int g : arr) {
            System.out.println(g);
        }
    }
}


