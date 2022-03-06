import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
lägger in alla orden från the text sedan används två metoder i BST klassen för att traversera trädet å skriva ut i
alphabetisk ordning eller i omvänd aplhabetisk ordning.
 */
public class Seven {
    public static void main (String Args[]) throws FileNotFoundException {

        int words = 0;
        File file = new File("filtrerad2.txt");
        Scanner scan = new Scanner(file);
        BST<String,Integer> ST = new BST<>();
        //!StdIn.isEmpty();
        for (int i = 0; i < 200;  i++) {
            String key = scan.next();
            key = key.toLowerCase();
            ST.put(key, i);
            words++;
        }
        StdOut.println("words  = " + words);
        System.out.println("\nPrint in Alphabetic order or in Reverse Alphabetic order");
        System.out.println("\"A\" = Alphabetic order \t \"R\" = Reverse Alphabetic order");
        String pick = StdIn.readString();
        switch(pick){
            case "A":
                ST.orderedprint();
                break;
            case "R":
                ST.reverse();
                break;
        }
    }
}
