import java.util.List;

public class test {
    public static void main(String[] args) {
        GraphAdjacencyList<Integer> g = new GraphAdjacencyList<>();

        printNeighbours(g);
        g.addEdge( 1,  2);
        g.addEdge( 3,  2);
        g.addEdge( 4,  2);
        g.addEdge( 5,  2);
        g.addEdge( 6,  2);
        g.addEdge( 7,  2);
        g.addEdge( 8,  2);

        printNeighbours(g);

        g.removeEdge(7,2);
        printNeighbours(g);

        g.removeVertex(2);
        printNeighbours(g);

    }
    public static void printNeighbours(GraphAdjacencyList<Integer> g)
    {
        for (List<Integer> i : g.E)
                System.out.println(i);
    }
}
