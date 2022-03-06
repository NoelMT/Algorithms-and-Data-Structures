import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class one {
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
                DepthFirstPaths dfs = new DepthFirstPaths(graph,s);
                if(dfs.hasPathTo(e)){
                    for (int x : dfs.pathTo(e)) {
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



