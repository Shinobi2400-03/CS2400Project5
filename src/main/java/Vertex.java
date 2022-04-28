import java.util.Iterator;

public class Vertex<T> implements VertexInterface<T>
{

    @Override
    public T getLabel() {
        return null;
    }

    @Override
    public void visit() {

    }

    @Override
    public void unvisit() {

    }

    @Override
    public boolean isVisited() {
        return false;
    }

    @Override
    public boolean connect(VertexInterface<T> endVertex, double edgeWeight) {
        return false;
    }

    @Override
    public boolean connect(VertexInterface<T> endVertex) {
        return false;
    }

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
    }

    @Override
    public VertexInterface<T> getUnvisitedNeighbor() {
        return null;
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
}