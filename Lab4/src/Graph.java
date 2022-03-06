
public class Graph {

    private final int V; //storleken av graphen antalet noder
    private int E; // antalet kanter
    private Bag<Integer>[] adj; // bag array

    /**
     * konstruktor som skapar graphen med v antalet hörn antalet kanter blir 0 och initierar en bag till varje nod
     * i bag arrayen adj
     */
    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     * returnerar antalet noder i graphen
     */
    public int V() {
        return V;
    }
    //kollar om indexet är mellan 0 och V om inte så kastas ett exception
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }
    /**
     * lägger till en kant mellan de två noderna och eftersom det är graph är undirected så gör man kan åt båda hållen
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }
    /**
     * retunrerar alla närliggande noder i grafen med en iterator till foreach loopar
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
}
