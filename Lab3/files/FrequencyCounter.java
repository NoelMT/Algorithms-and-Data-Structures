import java.util.Scanner;

/**
 * Denna klass används i klassen two och three, metoderna tar emot 1000 ord från the text och sedan printar ut antalet
 * ord som scannats in
 */
public class FrequencyCounter {

    public void  FrequencyCounter(BinarySearchST<String,Integer> ST,Scanner scan )
    {
        int words = 0;

        for (int i = 0; i < 1000;  i++) {
            ST.put(StdIn.readString().toLowerCase(), 1);
            words++;
        }
        StdOut.println("words  = " + words);
    }
    /*
    for (int i = 0; i < 1000;  i++) {
            String key = StdIn.readString();
            key = key.toLowerCase();
            if (ST.contains(key)) {
                ST.put(key, ST.get(key) + 1);
            } else {
                ST.put(key, 1);
            }
            words++;
        }
        StdOut.println("words  = " + words);
     */



 /*    while (scan.hasNextLine() && words < 1000){
        Scanner sc2 = new Scanner(scan.nextLine());
        while(sc2.hasNext() && words < 1000) {
            String key = sc2.next();
            words++;
            if (ST.contains(key)) {
                ST.put(key, ST.get(key) + 1);
            } else {
                ST.put(key, 1);
            }
        }
    }
        StdOut.println("words  = " + words);
        */

    public void  FrequencyCounter(BST<String,Integer> ST , Scanner scan) {
        int words = 0;

        for (int i = 0; i < 1000;  i++) {
            ST.put(StdIn.readString().toLowerCase(), 1);
            words++;
        }
        StdOut.println("words  = " + words);
    }
}

    /*
        while (scan.hasNextLine() && words < 1000){
        Scanner sc2 = new Scanner(scan.nextLine());
        while(sc2.hasNext() && words < 1000) {
            String key = sc2.next();
            words++;
            if (ST.contains(key)) {
                ST.put(key, ST.get(key) + 1);
            } else {
                ST.put(key, 1);
            }
        }
    }
        StdOut.println("words  = " + words);
        }

        */

/*
for (int i = 0; i < 1000; i++) {
            String key = StdIn.readString();
            key = key.toLowerCase();
            if (ST.contains(key)) {
                ST.put(key, ST.get(key) + 1);
            } else {
                ST.put(key, 1);
            }
            words++;
        }
        StdOut.println("words  = " + words);
    }
 */