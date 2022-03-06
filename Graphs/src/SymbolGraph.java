import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolGraph {
    private BinarySearchST<String, Integer> st;  // string -> index
    private String[] keys;           // index  -> string
    private Graph graph;             // the underlying graph
    /**
     * Konstruktor som gör om strängarna i första param till index i en symbol tabell, separerar nycklarna
     * med mellanslag,
     * metoden läser in en rad splitar strängarna och placerar strängarna i en array tills filen har slut på text
     * st.size() blir index siffran efter som det är antalet distinkta nycklar i st
     *
     * @param filename  namnet på filen som ska skapa en graph, filen måste har [X Y] på varje rad då x och y är
     * noder som är separerade med ' '
     */
    public SymbolGraph(String filename) throws FileNotFoundException {
        st = new BinarySearchST<>();
        File fil = new File(filename);
        Scanner in = new Scanner(fil);
        while (in.hasNextLine()) {
            String[] a = in.nextLine().split(" ");
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }
        //här lägga alla nycklarna i en array med deras graph index som index i arrayen
        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }
        // Här skapas en grap, storleken av grafen är antalet distinkta nycklar
        // sedan läser man in rad efter rad som innan hämtar indexet från st och lägger in den i graphen,
        graph = new Graph(st.size());
        File fil2 = new File("text.txt");
        Scanner in2 = new Scanner(fil2);
        while (in2.hasNextLine()) {
            String[] a = in2.nextLine().split(" ");
            int v = st.get(a[0]);
            int w = st.get(a[1]);
            graph.addEdge(v, w);
        }
    }
    /**
     * Kollar om strängen s är en nod i graphen.
     */
    public boolean contains(String s) {
        return st.contains(s);
    }
    /**
     * returnerar indexet som nyckeln har
     * @param s the name of a vertex
     */
    public int indexOf(String s) {
        return st.get(s);
    }
    /**
     * returnerar nyckeln som indexet har
     */
    public String nameOf(int v) {
        validateVertex(v);
        return keys[v];
    }
    /**
     *returner graph
     */
    public Graph graph() {
        return graph;
    }
    //kollar om indexet är mellan 0 och V om inte så kastas ett exception
    private void validateVertex(int v) {
        int V = graph.V();
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }
}
