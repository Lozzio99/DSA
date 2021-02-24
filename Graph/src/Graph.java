import java.util.List;

//Graph interface// Simplication: There are no duplicate values in T
public interface Graph<T>
{
    // whether there’s an edge from x to y
    boolean adjacent(T x, T y);

    //all vertices y s.t. there’s an edge from x to y
    List<T> neighbors(T x);

    //adds the vertex x
    void addVertex(T x);

    //removes the vertex x
    void removeVertex(T x);

    //adds edge from the vertices x to y
    void addEdge(T x, T y);

    //removes edge from the vertices x to y
    void removeEdge(T x, T y);}
