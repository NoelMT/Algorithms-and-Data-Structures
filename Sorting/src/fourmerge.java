import java.util.Scanner;
public class fourmerge {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        int Nt = scan.nextInt();
        int[] ar = new int[Nt];
        int i = 0;
        while(i < Nt){
            ar[i++] = scan.nextInt();
        }
        long start = System.currentTimeMillis();
        Merge.sort(ar);
        long end = System.currentTimeMillis();
        long tid = (end - start);
        System.out.println("Exekverings tiden blir: "+tid+ " ms");
    }
}
class Merge {
    // This class should not be instantiated.
    private Merge() { }

    /**
     * merge tar in två sortrade array halvor sedan lägger in de rätt in arrayen a,
     * @param a
     * @param aux
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        /** kopierar den tidigare halv sortrade arrayen dvs varje halva är sorterad
         *
         */
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        /** merge båda halvorna, i pekaren börjar på nedere halvan och j börjar från mid till hi
         * om j är mindre än i så läggs den in först i arrayen eftersom de sorteras minst till störst,om tvärt om
         * (else) så läggs i innan j, om en sidorna är klara kommer andra sidan att plocka in resten av elementen
         * i den andra arrayen
         */
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }
    /**
     * rekursiv funktion som har basfallet när hi <= lo alltså den sorterar nedre halvan tills de ba ett element kvar
     * sedan backar den och sorterar den övre halvan och sedan mergas de två elementen.
     * @param a vår array
     * @param aux kopia av array
     * @param lo
     * @param hi
     */
    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        //int mid = lo + (hi - lo) / 2;
        int mid = (hi + lo)/2; //räknar ut mitten punkten
        sort(a, aux, lo, mid);//undre halvan
        sort(a, aux, mid + 1, hi);//övre halvan
        merge(a, aux, lo, mid, hi); // merge till slut
    }
    /**
     *  merge sort metoden. är overloadad kommer skapa en kopia av arrayen och sedan kalla den andra
     *  sort metoden med low och hi
     * @param a är en array som tas emot
     */
    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length-1);
    }
    //kollar om första param är mindre än param 2
    private static boolean less(int v, int w) {
        return v < w;
    }
    // funktion som kollar om en attay är sortrad genom att kalla på andra metoden med samma namn
    private static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    /**jämnför varje par av tall och kollar om det första talet är större än det andra om det är det så är arrayen inte
     * sorterad i rätt ordning och retrunerar false
     * @param a
     * @param lo
     * @param hi
     * @return true om arrayen är sorterad från lo til hi
     */
    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    // print array to standard output
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
