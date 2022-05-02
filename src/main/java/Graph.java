<<<<<<< HEAD
import java.util.Iterator;
public class Graph<T>
{
    private boolean[][] edges;
    private T[] labels;

    public Graph(int n)
    {
        edges = new boolean[n][n];
        labels = (T[]) new Object[n];
=======
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;
import java.util.Vector;

public final class Graph<E>
{
    private boolean[][] edges;
    private E[] labels;
    private int vertices;

    public Graph(int n)
    {
        vertices = n;
        edges = new boolean[vertices][vertices];
        labels = (E[]) new Object[vertices];
>>>>>>> 4580f9c3d2b0a55b8a06cda12dc5665eb4892989
    }

    public T getLabel(int vertex)
    {
        return labels[vertex];
    }

    public boolean isEdge(int source, int target)
    {

        return edges [source][target];
    }

    public void addEdge(int source, int target)
    {
        edges[source][target] = false;
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

    public void setLabel(int vertex, E newLabel)
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
<<<<<<< HEAD
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<>();
        QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<>();

        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin);    // Enqueue vertex label
        vertexQueue.enqueue(originVertex); // Enqueue vertex

        while (!vertexQueue.isEmpty())
        {
            VertexInterface<T> frontVertex = vertexQueue.dequeue();
            Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();

            while (neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (!nextNeighbor.isVisited())
                {
                    nextNeighbor.visit();
                    traversalOrder.enqueue(nextNeighbor.getLabel());
                    vertexQueue.enqueue(nextNeighbor);
                } // end if
            } // end while
        } // end while

        return traversalOrder;
    } // end getBreadthFirstTraversal


=======
        return null;
    }

    public void getDepthFirstTraversal(E origin)
    {
        StackInterface<VertexInterface<E>> vertexStack = new LinkedStack();
        VertexInterface<E> originVertex = new Vertex(origin);

        vertexStack.push(originVertex);
        originVertex.visit();

        while(!vertexStack.isEmpty())
        {
            originVertex = vertexStack.peek();
            vertexStack.pop();
            if(!originVertex.isVisited())
            {
                System.out.print(origin + " ");
                originVertex.isVisited();
            }

            VertexInterface<E> next = originVertex.getUnvisitedNeighbor();
            while(!next.isVisited())
            {
                vertexStack.push(next);
            }
        }

//        QueueInterface<E> traversalOrder = new LinkedQueue<E>();
//        StackInterface<VertexInterface<E>> vertexStack = new LinkedStack();
//
//        VertexInterface<E> originVertex = new Vertex(origin);
//        originVertex.visit();
//        traversalOrder.enqueue(origin);
//        vertexStack.push(originVertex);
//
//        while(!vertexStack.isEmpty())
//        {
//            originVertex = vertexStack.peek();
//            vertexStack.pop();
//
//            if(!originVertex.isVisited())
//            {
//                System.out.println(origin + " ");
//                originVertex.visit();
//            }
//
//            VertexInterface<E> topVertex = vertexStack.peek();
//            VertexInterface<E> next = topVertex.getUnvisitedNeighbor();
//
//            while(next != null)
//            {
//                if(!next.isVisited())
//                {
//                    next.visit();
//                    traversalOrder.enqueue(next.getLabel());
//                    vertexStack.push(next);
//                }
//                vertexStack.pop();
//            }
//        }
//        return traversalOrder;
    }
>>>>>>> 4580f9c3d2b0a55b8a06cda12dc5665eb4892989
}

