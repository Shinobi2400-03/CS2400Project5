import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.LinkedList;

public class Vertex<T> implements VertexInterface<T>
{
    private T label;

    private ListIterator<T> edgeList;
    private boolean visited;                          // True if visited
    private VertexInterface<T> previousVertex;        // On path to this vertex
    private double cost;                              // Of path to this vertex
    private T data;


    public Vertex(T vertexLabel)
    {
        label = vertexLabel;
        visited = false;
        previousVertex = null;
        cost = 0;
    } // end constructor


    @Override
    public T getLabel()
    {
        return label;
    }

    @Override
    public void visit()
    {
        visited = true;
    }

    @Override
    public void unvisit()
    {
        visited = false;
    }

    @Override
    public boolean isVisited()
    {
        return visited;
    }

    // @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
    public boolean connect(VertexInterface<T> endVertex, double edgeWeight)
    {
        boolean result = false;

        if (!this.equals(endVertex))
        {  // Vertices are distinct
            Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
            boolean duplicateEdge = false;

            while (!duplicateEdge && neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (endVertex.equals(nextNeighbor))
                    duplicateEdge = true;
            } // end while

            if (!duplicateEdge)
            {
                //edgeList.add(new Edge(endVertex, edgeWeight));
                result = true;
            } // end if
        } // end if

        return result;
    } // end connect

    public boolean connect(VertexInterface<T> endVertex)
    {
        return connect(endVertex, 0);
    } // end connect

    @Override
    public Iterator<VertexInterface<T>> getNeighborIterator() {
        return null;
    }

    @Override
    public Iterator<Double> getWeightIterator() {
        return null;
    }

    @Override
    public boolean hasNeighbor() {
        return false;
    }//

    @Override
    public VertexInterface<T> getUnvisitedNeighbor() {
        VertexInterface<T> result = null;
        Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
        while ( neighbors.hasNext() && (result == null) )
        {
            VertexInterface<T> nextNeighbor = neighbors.next();
            if (!nextNeighbor.isVisited())
                result = nextNeighbor;
        } // end while
        return result;
    }

    @Override
    public void setPredecessor(VertexInterface<T> predecessor) {

    }

    @Override
    public VertexInterface<T> getPredecessor() {
        return null;
    }

    @Override
    public boolean hasPredecessor() {
        return false;
    }

    @Override
    public void setCost(double newCost) {

    }

    @Override
    public double getCost() {
        return 0;
    }



    protected class Edge
    {
        private VertexInterface<T> vertex; // Vertex at end of edge
        private double weight;

        protected Edge(VertexInterface<T> endVertex, double edgeWeight)
        {
            vertex = endVertex;
            weight = edgeWeight;
        } // end constructor

        protected Edge(VertexInterface<T> endVertex)
        {
            vertex = endVertex;
            weight = 0;
        } // end constructor

        protected VertexInterface<T> getEndVertex()
        {
            return vertex;
        } // end getEndVertex

        protected double getWeight()
        {
            return weight;
        } // end getWeight
    } // end Edge

    private class NeighborIterator implements Iterator<VertexInterface<T>>
    {

        private Iterator<Edge> edges;

        private NeighborIterator()
        {
            //edges = edgeList.getIterator();
        }
        @Override
        public boolean hasNext()
        {
            return edges.hasNext();
        }

        @Override
        public VertexInterface<T> next()
        {
            VertexInterface<T> nextNeighbor = null;
            if (edges.hasNext())
            {
                Edge edgeToNextNeighbor = edges.next();
                nextNeighbor = edgeToNextNeighbor.getEndVertex();
            }
            else
                throw new NoSuchElementException();
            return nextNeighbor;
        }
        public void remove()
        {
            throw new UnsupportedOperationException();
        } // end remove
    } // end NeighborIterator
}