import java.util.Scanner;

public class seven {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Element "+ i+": ");
            arr[i] = scan.nextInt();
        }
        oldinsertsort ob = new oldinsertsort(arr);
        /**
         * vänder arrayens sortering från lo-hi till hi-lo genom att multiplicera alla elementen med 1 så att det
         * största elementet blir det största
         */
        for (int i = 0; i < N; i++) {
            arr[i] = arr[i] * -1;
        }
        ob.sort();
        for (int i = 0; i < N; i++) {
            arr[i] = arr[i] * -1;
        }
        ob.show();
    }


}
class oldinsertsort{
    int arr[];
    int N;
    public oldinsertsort(int[] arr){
        this.arr = arr;
        this.N = arr.length;
    }
    public void sort(){
        Scanner scan = new Scanner(System.in);
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                swap(arr, j, j - 1);
            }
        }
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
    }

    public void show (){
        System.out.println("-----------------------------------");
        for (int i : this.arr){
            System.out.println(i);
        }
    }
}
