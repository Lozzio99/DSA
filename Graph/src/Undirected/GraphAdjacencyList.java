package Undirected;

import java.util.List;
import java.util.ArrayList;


public class GraphAdjacencyList<E> implements Graph<E>
{
    public List<List<E>> E;

    public GraphAdjacencyList()
    {
        E = new ArrayList<>();
    }

    @Override
    public boolean adjacent(E x, E y)
    {
        if (findIndex(x)==-1||findIndex(y)==-1||x.equals(y))
            return false;
        for (E v : this.E.get(findIndex(x)))
            if (v.equals(y))
                return true;
        return false;

    }

    @Override
    public List<E> neighbors(E x)
    {
        List<E> neighbours = this.E.get(findIndex(x));
        neighbours.remove(0);
        return neighbours;
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
        if (findIndex(x)==-1)
            return;
        this.E.remove((int) findIndex(x));
        for (List<E> v : this.E)
            v.remove(x);
    }

    @Override
    public void addEdge(E x, E y)
    {
        if (findIndex(x)==-1&&findIndex(y)==-1)
        {
            List<E> vx =  new ArrayList<>();
            vx.add(x);    vx.add(y);
            List<E> vy =  new ArrayList<>();
            vy.add(y);    vy.add(x);
            E.add(vx);    E.add(vy);
        }
        else if (findIndex(x)!= -1)
            addToExisting(x,y);
        else
            addToExisting(y,x);

    }

    private void addToExisting(E x, E y)
    {
        int i = findIndex(x);
        List<E> vx = this.E.get(i);
        this.E.remove(vx);
        vx.add(y);
        this.E.add(vx);

        if (findIndex(y)==-1)
        {
            List<E> vy = new ArrayList<>();
            vy.add(y); vy.add(x);
            this.E.add(vy);
        }

    }


    @Override
    public void removeEdge(E x, E y)
    {
        if (findIndex(x)==-1||findIndex(y)==-1)
            return;

        this.E.get(findIndex(x)).remove(y);
        this.E.get(findIndex(y)).remove(x);

    }
    int findIndex(Object x)
    {
        int index = -1;
        for (List<E> v : E)
            if (v.get(0).equals(x))
                return E.indexOf(v);
        return index;
    }

}
