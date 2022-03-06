public class DepthFirstPaths {
    private boolean[] marked;    // marked[v] = array som hållar koll om en nod har en väg
    private int[] edgeTo;        // edgeTo[v] = tilbaka bägen från index v.
    private final int s;         // source noden

    /**
     * kontruktor som tar emot en graph och e start node och intitiderar klassens atributer. desutom kollar
     * att start noden är korrekt
     * sedan kallas dfs med grafen och startnoden
     */
    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        validateVertex(s);
        dfs(G, s);
    }

    /** depth first search från noden v,
     *första noden markeras som true alltså att man kommit till noden, sedan går man igenom alla nodernas närligande
     * kör dfs från den noden om den inte har blivit markerad innan. edge to kollar vägen som man har gått, alltså
     * vilken nod som man komfrån. sedan kallas dfs igenfrån noden man var på tills man kommer till en nod man redan
     * har vart på eller tills det är slut på närligande noder. (om det tar slut på närliggande noder så går man
     * ett steg.
     */
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    /**
     * kollar om det finns en path till en specifik nod, om det finns en path ska det va true på index v i makred
     */
    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }

    /**
     * returnerar vägen till en specifik nod från startnoden med en iterator.
     * om det inte finns en väg returneras null
     * eftersom vi har sparat vilken nod man kommer i från i edgeTo[] så börjar man från noden man vill komma till
     *
     *
     */
    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }
}
