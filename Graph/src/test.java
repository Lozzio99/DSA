import java.util.List;

public class test {
    public static void main(String[] args) {
        GraphAdjacencyList<Integer> g = new GraphAdjacencyList<>();

        g.addEdge( 1,  2);
        g.addEdge( 3,  2);
        g.addEdge( 4,  2);
        g.addEdge( 5,  2);
        g.addEdge( 6,  2);
        g.addEdge( 7,  2);
        g.addEdge( 8,  2);

        printNeighbours(g);
        System.out.println(g.neighbors(5));


        Search<Integer> s = new Search<>();
        System.out.println(s.BFS(g,3));

    }
    public static void printNeighbours(GraphAdjacencyList<Integer> g)
    {
        for (GraphAdjacencyList.Vertex v : g.getGraphNodes())
        {
            System.out.println(v.getConnected());
        }
    }
}
