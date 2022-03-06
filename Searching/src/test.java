public class test {
    public static void main (String Args[]){
        BST<String,Integer> test = new BST<String, Integer>();
        test.put("a",5);
        test.put("d",2);
        test.put("e",8);
        test.put("c",1);
        test.put("b",9);


            System.out.println(test.rank("e"));

       // StdOut.println("words  = " + words);
    }
}
