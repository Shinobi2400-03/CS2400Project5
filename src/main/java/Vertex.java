import java.util.Iterator;
import java.util.NoSuchElementException;

public class Vertex<T> implements VertexInterface<T>
{
    private T label;
    private int vertices;
    private T[] vertexArr;
    private ListWithIteratorInterface<T> edgeList;
    private boolean visited;                          // True if visited
    private VertexInterface<T> previousVertex;        // On path to this vertex
    private double cost;                              // Of path to this vertex
    private T data;


    public Vertex(T vertexLabel)
    {
        vertices = 0;
        edgeList = new LinkedListWithIterator<>();
        label = vertexLabel;
        visited = false;
        previousVertex = null;
        cost = 0;
        vertexArr = (T[]) new Object[1000];
    } // end constructor

//    public int getValue(T label)
//    {
//        return edgeList;
//    }
//
//    // @author Frank M. Carrano, Timothy M. Henry
//    // @version 5.0
//    public boolean addVertex(T vertexLabel)
//    {
//        VertexInterface<T> addOutcome = vertices.add(vertexLabel, new Vertex<>(vertexLabel));
//        return addOutcome == null; // Was addition to dictionary successful?
//    } // end addVertex
//
//    public T add(T vertexLabel, Vertex<T> nw)
//    {
//        return vertexArr[vertices++] = vertexLabel;
//    }


//    public boolean hasEdge(T begin, T end)
//    {
//        boolean found = false;
//        VertexInterface<T> beginVertex = vertices.getValue(begin);
//        VertexInterface<T> endVertex = vertices.getValue(end);
//        if ( (beginVertex != null) && (endVertex != null) )
//        {
//            Iterator<VertexInterface<T>> neighbors =
//                    beginVertex.getNeighborIterator();
//            while (!found && neighbors.hasNext())
//            {
//                VertexInterface<T> nextNeighbor = neighbors.next();
//                if (endVertex.equals(nextNeighbor))
//                    found = true;
//            } // end while
//        } // end if
//        return found;
//    } // end hasEdge

//    public boolean addEdge(T begin, T end, double edgeWeight)
//    {
//        boolean result = false;
//        VertexInterface<T> beginVertex = vertices.getValue(begin);
//        VertexInterface<T> endVertex = vertices.getValue(end);
//        if ( (beginVertex != null) && (endVertex != null) )
//            result = beginVertex.connect(endVertex, edgeWeight);
//        if (result)
//            edgeCount++;
//        return result;
//    } // end addEdge

//    public boolean addEdge(T begin, T end)
//    {
//        return addEdge(begin, end, 0);
//    } // end addEdge

//    public boolean addVertex(T vertexLabel)
//    {
//        VertexInterface<T> addOutcome =
//                vertices.add(vertexLabel, new Vertex<>(vertexLabel));
//        return addOutcome == null; // Was addition to dictionary successful?
//    } // end addVertex

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

    @Override
    public boolean connect(VertexInterface<T> endVertex, double edgeWeight) {
        return false;
    }

    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public boolean connect(VertexInterface<T> endVertex, int edgeWeight)
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
    public Iterator<VertexInterface<T>> getNeighborIterator()
    {
        return new NeighborIterator();
    } // end getNeighborIterator

    @Override
    public Iterator<Double> getWeightIterator() {
        return null;
    }

    @Override
    public boolean hasNeighbor() {
        return !edgeList.isEmpty();
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

    public boolean equals(Object other)
    {
        boolean result;
        if ((other == null) || (getClass() != other.getClass()))
            result = false;
        else
        {  // The cast is safe within this else clause
            @SuppressWarnings("unchecked")
            Vertex<T> otherVertex = (Vertex<T>)other;
            result = label.equals(otherVertex.label);
        } // end if
        return result;
    } // end equals

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

        private Iterator<T> edges;

        private NeighborIterator()
        {
            edges = edgeList.getIterator();
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
                T edgeToNextNeighbor = edges.next();
                //nextNeighbor = edgeToNextNeighbor.getEndVertex();
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