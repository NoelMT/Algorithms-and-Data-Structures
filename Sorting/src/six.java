import java.util.Scanner;

public class six {
        public static void main(String[] args)  {
            Scanner scan = new Scanner(System.in);
            int Nt = scan.nextInt();
            int[] ar = new int[Nt];
            int i = 0;
            while(i < Nt){
                ar[i++] = scan.nextInt();
            }
            long start = System.currentTimeMillis();
            Quick.sort(ar);
            long end = System.currentTimeMillis();
            long tid = (end - start);
            System.out.println("Exekverings tiden blir: "+tid+ " ms");
        }
    }
class QuickX{
    // This class should not be instantiated.
    private QuickX() { }
    /**
     * sort tar emot en array och är overloaded till en anna sort metod som tar emot lo och hi  plus arrayen a,
     * dessutom så shufflar man arrayen innan för att få ett bra partions värde
     * @param a the array to be sorted
     */
    public static void sort(int[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    /**
     * här kommer arrayen sorteras, metoden är rekursiv och kommer att har basfallet hi <= lo alltså det är bara ett
     * element kvar. sedan kallas en funktion som väljer partions elemten sedan kallas sort på under delen lo till
     * partions elementet rekursivt och nör man nått basfallet så kommer övre delen sorteras, till slut kommer allt
     * vara sorteras.
     *
     * I de här impovade versionen av quicksort så tar man försa mitten och sista elementet i arrayen och sedan
     * använder elementet med mellesta värdet som pivot element: ska ge 14% mindre jämnförelser och 3% mindre swaps
     * partions metoden är samma som innan
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int m = median3(a, lo, lo + (hi-lo)/2, hi);
        exch(a, m, lo);


        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    /**
     * pväljer ett värde i arayyen a så att man kannanvända det som pivot element, något elemetn i mitten av arreyen
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    //and return the index j.
    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi) break;
            }
            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == lo) break;      // redundant since a[lo] acts as sentinel
            }
            // check if pointers cross
            if (i >= j) break;
            exch(a, i, j);
        }
        // put partitioning item v at a[j]
        exch(a, lo, j);
        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    /**
     * Denna funktion tar emot tre platser på arrayen a och sedan hittar mitten värdet med hjälp av xor
     * mitten värdet returneras och anvädns som return element i metoden sort
     * @param a
     * @param lo
     * @param middle
     * @param high
     * @return
     */
    private static int median3(int[] a, int lo, int middle, int high){
        if(a[lo] > a[middle] ^ a[lo] > a[high]){
            return a[high];
        }
        else if(a[middle] > a[high] ^ a[middle] > a[lo]){
            return a[middle];
        }
        else
            return a[high];
    }
    // kollar om v < w
    private static boolean less(int v, int w) {
        if (v == w) return false;   // går lite snabbare ifall talen e lika, hjälper om det e många equal keys
        return v < w;
    }
    // swap a[i] och a[j]
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    private static void show(int[] a) {
        for (int i : a) {
            System.out.println(i);
        }
    }
}

