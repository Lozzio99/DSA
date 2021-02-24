import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class GraphAdjacencyList<E> implements Graph<E>
{
    List<Vertex<E>> graphNodes = new ArrayList<>();
    @Override
    public boolean adjacent(E x, E y)
    {
        for (Vertex<E> v : this.graphNodes)
        {
            if (v.getId().equals(x))
                return v.adjacent(y);
        }
        return false;
    }
    @Override
    public List<E> neighbors(E x)
    {
        for (Vertex<E> v : this.graphNodes)
        {
            if (v.getId().equals(x))
                return v.getConnected();
        }
        return new ArrayList<>();
    }

    @Override
    public void addVertex(E x)
    {
        this.graphNodes.add(new Vertex<>(x));
    }

    @Override
    public void removeVertex(E x)
    {
           // this.graphNodes.removeIf(e-> e.getId().equals(x));
        boolean present = false;
        Vertex<E> toRemove = null;
        for (Vertex<E> v : this.graphNodes)
        {
            if (v.getId().equals(x)) {
                toRemove = v;
                present = true;
            }
        }
        if (present)
        {
            this.graphNodes.remove(toRemove);
            for (Vertex<E> v : this.graphNodes)
               v.remove(toRemove.getId());

        }

    }

    @Override
    public void addEdge(E x, E y)
    {
        boolean yPresent = false,xPresent = false;
        for (Vertex<E> v : this.graphNodes)
        {
            if (v.getId().equals(x)){
                v.add(y);
                xPresent = true;
            }
            if (v.getId().equals(y)){
                v.add(x);
                yPresent = true;
            }
        }
        if (!xPresent)
            this.graphNodes.add(new Vertex<>(x,y));
        if (!yPresent)
            this.graphNodes.add(new Vertex<>(y,x));

    }

    @Override
    public void removeEdge(E x, E y) {
        for (Vertex<E> v : this.graphNodes) {
            if (v.getId().equals(x)){
                v.remove(y);
            }
            if (v.getId().equals(y)){
                v.remove(x);
            }
        }
    }
    public List<Vertex<E>> getGraphNodes()
    {
        return this.graphNodes;
    }


    public class Vertex <E>
    {
        private final E id;
        private List<E> connected;
        Vertex(E id) {
            this.id = id;
            this.connected = new ArrayList<>();
        }
        Vertex(E id, E connected) {
            this.id = id;
            this.connected = new ArrayList<>();
            this.connected.add(connected);
        }
        E getId() {
            return this.id;
        }
        boolean adjacent(E y)
        {
            return this.connected.contains(y);
        }
        List<E> getConnected() {
            return this.connected;
        }
        void add(E x) {
            this.connected.add(x);
        }
        void remove(E x) {
            this.connected.remove(x);
        }
    }
}
