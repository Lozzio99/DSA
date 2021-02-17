import java.util.List;
import java.util.ArrayList;


public class GraphAdjacencyList<E> implements Graph<E>
{
    List<List<E>> E;

    GraphAdjacencyList()
    {
        E = new ArrayList<>();
    }

    @Override
    public boolean adjacent(E x, E y)
    {
        if (e.findIndex(x)==-1||e.findIndex(y)==-1)
            return false;
        for (E v : this.E.get(e.findIndex(x)))
            if (v.equals(y))
                return true;
        return false;

    }

    @Override
    public List<E> neighbors(E x)
    {
        return this.E.get(e.findIndex(x));
    }

    @Override
    public void addVertex(E x)
    {
        List<E> e = new ArrayList<>();
        e.add(x);
        this.E.add(e);
    }

    @Override
    public void removeVertex(E x)
    {
        if (e.findIndex(x)==-1)
            return;
        this.E.remove((int) e.findIndex(x));
        for (List<E> v : this.E)
            v.remove(x);
    }

    @Override
    public void addEdge(E x, E y)
    {
        if (e.findIndex(x)==-1&&e.findIndex(y)==-1)
        {
            List<E> vx =  new ArrayList<>();
            vx.add(x);    vx.add(y);
            List<E> vy =  new ArrayList<>();
            vy.add(y);    vy.add(x);
            E.add(vx);    E.add(vy);
        }
        else if (e.findIndex(x)!= -1)
            addToExisting(x,y);
        else
            addToExisting(y,x);

    }

    private void addToExisting(E x, E y)
    {
        int i = e.findIndex(x);
        List<E> vx = this.E.get(i);
        this.E.remove(vx);
        vx.add(y);
        this.E.add(vx);

        if (e.findIndex(y)==-1)
        {
            List<E> vy = new ArrayList<>();
            vy.add(y); vy.add(x);
            this.E.add(vy);
        }

    }


    @Override
    public void removeEdge(E x, E y)
    {
        if (e.findIndex(x)==-1||e.findIndex(y)==-1)
            return;

        this.E.get(e.findIndex(x)).remove(y);
        this.E.get(e.findIndex(y)).remove(x);

    }

    functional e = x -> {
        int index = -1;
        for (List<E> v : E)
            if (v.get(0).equals(x))
                return E.indexOf(v);
        return index;
    };

    @FunctionalInterface
    interface functional
    {
        int findIndex(Object x);
    }

}
