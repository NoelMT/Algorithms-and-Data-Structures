
import java.util.Scanner;
import java.time.*;

/**
 * den här classen använder insertion sort, merge sort och quick sort och rupertsort
 * Tanken är man ska sortera större mängder data. sedan testa hur snabba
 * algoritmerna jämfört med varandra
 */

public class four {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        int Nt = scan.nextInt();
        int[] ar = new int[Nt];
        int i = 0;
        while(i < Nt){
            ar[i++] = scan.nextInt();
        }
        insertsort insr = new insertsort(ar);
        //insr.sort();
        //Quick.sort(ar);
        //
        long start = System.currentTimeMillis();
        Merge.sort(ar);
        long end = System.currentTimeMillis();
        long tid = (end - start);
        System.out.println(tid);
    }
}
