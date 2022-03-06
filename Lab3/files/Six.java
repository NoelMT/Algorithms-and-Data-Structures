import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Denna klass läser in text från filtrerad2.txt, alla orden läggs till i en Hash tabell som har seperate chaining
 * vid colision. Ordet används som key och value är antalet ordet har använts.
 */
public class Six {
public static void main (String Args[]) throws FileNotFoundException {
    File file = new File("filtrerad2.txt");
    Scanner sc = new Scanner(file);
    SeparateChainingLiteHashST<String, Integer> SCH = new SeparateChainingLiteHashST<>();
    for (int i = 0; sc.hasNext();  i++){
        String key = sc.next().toLowerCase();
        if (SCH.contains(key)) {
            SCH.put(key, SCH.get(key) + 1);
        }else
            SCH.put(key, 1);
    }
    Scanner scan = new Scanner(System.in);
    String c = "s";
    while (!c.equals("q")){
        System.out.println("Enter a word:");
        String key = scan.next();
        key  = key.toLowerCase();
        if (SCH.contains(key)){
            System.out.println("The word  \""+ key + "\" is used " + SCH.get(key) + " times");
            System.out.println("\n press q to leave:  ");
            c = scan.next();
            if(c.equals("q"))
                c = "q";
        }
        else
            System.out.println(" Ordet finns ej med i tabellen");
        }
    }
}
/*
    Scanner scan = new Scanner(System.in);
    String c = "s";
    while (!c.equals("q")){
        System.out.println("Välj word:");
        String key = scan.next();
        if (SCH.contains(key.toLowerCase())){
            System.out.println("Ordet  \""+ key + "\" dyker upp " + SCH.get(key) + " antal gånger");
            System.out.println("\n Skriv q för att lämna:  ");
            c = scan.next();
            if(c.equals("q"))
                c = "q";
        }
        else
            System.out.println(" Ordet finns ej med i tabellen");
        }

     */