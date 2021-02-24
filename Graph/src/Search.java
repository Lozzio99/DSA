import java.util.*;

public class Search<E>
{
    Queue <E> queue ;
    List<E> result ;
    Graph<E> g ;
    public void Search()
    {
        E visited = this.queue.poll();
        if (visited!= null)
        {
            for (E v : g.neighbors(visited))
            {
                if (!result.contains(v))
                {
                    queue.add(v);
                    result.add(v);
                }
            }
            this.Search();
        }

    }
    public List<E> BFS(Graph<E> g, E startnode)
    {
        this.result = new ArrayList<>();
        this.queue = new LinkedList<>();
        this.g = g;
        queue.add(startnode);
        result.add(startnode);
        this.Search();
        return this.result;
    }
}