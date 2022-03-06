import java.util.NoSuchElementException;
import java.util.Scanner;

/*
klass som skapar en Binary search tree och sedan kallar på funktionen FrequencyCounter i klassen
FrequencyCounter som lägger in 1000 ord i tabellen. Sedan mäts tiden på hur lång tid det att stoppa in alla orden
 */
public class three {
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        BST<String, Integer> symbolTable = new BST<>();
        FrequencyCounter FC = new FrequencyCounter();

        System.out.print("Symbol Table: \n\n");
        long start = System.currentTimeMillis(); //start measure time for ST
        FC.FrequencyCounter(symbolTable,scan);
        long stop = System.currentTimeMillis();
        long tid = stop - start;
        System.out.println("\nExcekveringstiden: " + tid);
    }
}

