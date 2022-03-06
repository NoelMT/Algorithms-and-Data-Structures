import java.io.FileNotFoundException;

public class two {
    public static void main(String Args[]) throws FileNotFoundException {
        SymbolGraph sg = new SymbolGraph("text.txt");
        Graph graph = sg.graph();

        System.out.println("Chose start");
        String source = StdIn.readString().toUpperCase();
        System.out.println("Chose end");
        String end = StdIn.readString().toUpperCase();
        if (sg.contains(source) && sg.contains(end)){
            int s = sg.indexOf(source);
            int e = sg.indexOf(end);
            BreadthFirstPaths bfs = new BreadthFirstPaths(graph,s);
            if(bfs.hasPathTo(e)){
                for (int x : bfs.pathTo(e)) {
                    if (x == e) StdOut.print(sg.nameOf(x));
                    else StdOut.print(sg.nameOf(x) + "-");
                }
            }
            else{
                System.out.println("No path :(");
            }
        }else {
            StdOut.println("input does not exist!" );
        }
    }
}
