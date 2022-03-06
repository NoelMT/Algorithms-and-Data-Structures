import java.util.Scanner;

public class fourinsert {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        int Nt = scan.nextInt();
        int[] ar = new int[Nt];
        int i = 0;
        while(i < Nt){
            ar[i++] = scan.nextInt();
        }
        insertsort insr = new insertsort(ar);
        long start = System.currentTimeMillis();
        insr.sort();
        long end = System.currentTimeMillis();
        long tid = (end - start);
        System.out.println("Exekverings tiden blir: "+tid+ " ms");
    }
}
class insertsort{
    int arr[];
    int N;
    public insertsort(int[] arr){
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
}

