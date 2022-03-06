public class BreadthFirstPaths {
    private boolean[] marked;   // marked[v] = array som hållar koll om en nod har en väg
    private int[] edgeTo;       // edgeTo[v] = tilbaka bägen från index v.
    private int[] distTo;       // distansen från source noden
    /**
     * bredden först sökning som tar reda på den kortaste vägen genom att söka efter noder på bredden alltså i
     * distans till source noden s. Sökningne är inte recursiv utan använder sig utav en queue som lägger till alla
     * subnoderna / närliggande noderna i kön. element som är marked kommer inte att läggas i kön igen därför får
     * man den kortaste vägen, den vägen som markerar en nod först med kortast distTo source kommer att bli
     * marked i edgeTo
     *
     * element som de ej finns en väg till kommer att ha max distans för en int
     */
    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        validateVertex(s);
        bfs(G, s);
    }
    private void bfs(Graph G, int s) {
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Integer.MAX_VALUE;
        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }
    /**
     * returnerar true om de finns en path till noden v
     */
    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }
    /**
     * returnerar distansen från source noden
     */
    public int distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }
    /**
     *
     */
    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }

    /**
     * kollar endast om v är en nod som finns i graphen
     * @param v
     */
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }
}
