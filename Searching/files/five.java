import java.io.*;
import java.util.*;
/**
 * klassen five intierar en SeparateChainingHashST sedan läser in hela textem, sedam kallas table från
 * SeparateChainingHashST och den printar ut antalet element i varje index som finns i tabellen alltså
 * antalet collisions i varje index.
 */
public class five {
    public static void main (String Args[]) throws FileNotFoundException {
        File file = new File("filtrerad2.txt");
        SeparateChainingHashST<String,Integer> test = new SeparateChainingHashST<>();
        Scanner sc = new Scanner(file);
        for (int i = 0; sc.hasNext();  i++) {
            String key = sc.next().toLowerCase();
            if (test.contains(key)) {
                test.put(key, test.get(key) + 1);
            }else
                test.put(key, 1);
        }
        test.table();
    }
}
