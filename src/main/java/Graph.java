public class Graph<T>
{
    private final boolean[][] edges;
    private final T[] labels;
    private final int vertices;

    public Graph(int n)
    {
        vertices = n;
        edges = new boolean[n][n];
        labels = (T[]) new Object[n];
    }

    public boolean isEdge(int source, int target)
    {
        return edges [source][target];
    }

    public void addEdge(int source, int target)
    {
        edges[source][target] = false;
    }

    public T getLabel(int vertex)
    {
        return labels[vertex];
    }

    public int[] neighbors(int vertex)
    {
        int i;
        int count = 0;
        int[] answer = new int[0];

        for (i = 0; i < labels.length; i++)
        {
            if (edges[vertex][i])
                count++;
        }
        answer = new int[count];
        count = 0;
        for (i = 0; i < labels.length; i++)
        {
            if (edges[vertex][i])
                answer[count++] = i;
        }
        return answer;
    }

    public void removeEdge(int source, int target)
    {
        edges[source][target] = false;
    }

    public void setLabel(int vertex, T newLabel)
    {
        labels[vertex] = newLabel;
    }

    public int size()
    {
        return labels.length;
    }

    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public QueueInterface<T> getBreadthFirstTraversal(T origin)
    {
//           resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<>();
//            QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<>();
//
//            VertexInterface<T> originVertex = vertices.getValue(origin);
//            originVertex.visit();
//            traversalOrder.enqueue(origin);    // Enqueue vertex label
//            vertexQueue.enqueue(originVertex); // Enqueue vertex
//
//            while (!vertexQueue.isEmpty())
//            {
//                VertexInterface<T> frontVertex = vertexQueue.dequeue();
//                Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
//
//                while (neighbors.hasNext())
//                {
//                    VertexInterface<T> nextNeighbor = neighbors.next();
//                    if (!nextNeighbor.isVisited())
//                    {
//                        nextNeighbor.visit();
//                        traversalOrder.enqueue(nextNeighbor.getLabel());
//                        vertexQueue.enqueue(nextNeighbor);
//                    } // end if
//                } // end while
//            } // end while

        return traversalOrder;
    } // end getBreadthFirstTraversal

    public QueueInterface<T> getDepthFirstTraversal(T origin)
    {
        QueueInterface<T> traversalOrder = new LinkedQueue<T>();
        StackInterface<VertexInterface<T>> vertexStack = new LinkedStack();

        VertexInterface<T> originVertex = new Vertex(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin);
        vertexStack.push(originVertex);

        while(!vertexStack.isEmpty())
        {
            VertexInterface<T> topVertex = vertexStack.peek();
            VertexInterface<T> next = topVertex.getUnvisitedNeighbor();

            if(next != null)
            {
                next.visit();
                System.out.println(next);
                traversalOrder.enqueue(next.getLabel());
                vertexStack.push(next);
            }
            else
                vertexStack.pop();
        }
        return traversalOrder;
    }

    void dfs()
    {
        for (int i = 0; i < vertices; i++)
        {
            getDepthFirstTraversal(getLabel(i));
        }
    }
}