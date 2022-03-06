import java.io.FileNotFoundException;

public class three {
    public static void main(String Args[]) throws FileNotFoundException {
        SymbolGraph sg = new SymbolGraph("text.txt");
        Graph graph = sg.graph();

        System.out.println("Chose start");
        String source = StdIn.readString().toUpperCase();
        System.out.println("Chose middle");
        String middle = StdIn.readString().toUpperCase();
        System.out.println("Chose end");
        String end = StdIn.readString().toUpperCase();

        if (sg.contains(source) && sg.contains(end) && sg.contains(middle)){
            int s = sg.indexOf(source);
            int m = sg.indexOf(middle);
            int e = sg.indexOf(end);
            BreadthFirstPaths first = new BreadthFirstPaths(graph,s);
            BreadthFirstPaths second = new BreadthFirstPaths(graph,m);
            if(first.hasPathTo(m) && second.hasPathTo(e)){
                for (int x : first.pathTo(m)) {
                    StdOut.print(sg.nameOf(x) + "-");
                }
                for (int x : second.pathTo(e)) {
                    if (x == e) {StdOut.print(sg.nameOf(x));}
                    else if(x == m){}
                    else {StdOut.print(sg.nameOf(x) + "-");}
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
