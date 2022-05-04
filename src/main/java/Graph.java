import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;
import java.util.Vector;
public class Graph<T>
{
        private boolean[][] edges;
        private T[] labels;
        private int vertices;

        public Graph(int n)
        {
            vertices = n;
            edges = new boolean[vertices][vertices];
            labels = (T[]) new Object[vertices];
        } // end constructor

        // Accessor method to get the label of a vertex of this Graph
        public T getLabel(int vertex)
        {
            return labels[vertex];
        }

        public int getVertex(T label)
        {
            for(int i = 0; i < labels.length; i++)
            {
                if(labels[i] == label)
                {
                    return i;
                }
            }
            return 0;
        }

        // Test whether an edge exists
        public boolean isEdge(int source, int target)
        {
            return edges [source][target];
        }

        // Add an edge
        public void addEdge(int source, int target)
        {
            edges[source][target] = true;
        }

        // Obtain a list of neighbors of a specified vertex of this Graph
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

        // Remove an edge
        public void removeEdge(int source, int target)
        {
            edges[source][target] = false;
        }

        // Change the label of a vertex of this Graph
        public void setLabel(int vertex, T newLabel)
        {
            labels[vertex] = newLabel;
        }

        // Accessor method to determine the number of vertices in this Graph
        public int size()
        {
            return labels.length;
        } // end size


        // @author Frank M. Carrano, Timothy M. Henry
        // @version 5.0
        public QueueInterface<T> getBreadthFirstTraversal(T origin)
        {
            QueueInterface<T> traversalOrder = new LinkedQueue<>();
            QueueInterface<T> vertexQueue = new LinkedQueue<>();

            traversalOrder.enqueue(origin);
            vertexQueue.enqueue(origin);

            while(!vertexQueue.isEmpty())
            {
                T rootNode = vertexQueue.dequeue();
                int rootVertex = getVertex(rootNode);
                int[] neighbors = neighbors(rootVertex);



                for(int i = 0; i < neighbors.length; i++)
                {

                }
            }
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

        public void getDepthFirstTraversal(T origin)//
        {
            StackInterface<VertexInterface<T>> vertexStack = new LinkedStack();
            VertexInterface<T> originVertex = new Vertex(origin);

            vertexStack.push(originVertex);
            originVertex.visit();

            while (!vertexStack.isEmpty()) {
                originVertex = vertexStack.peek();
                vertexStack.pop();
                if (!originVertex.isVisited()) {
                    System.out.print(origin + " ");
                    originVertex.isVisited();
                }

                VertexInterface<T> next = originVertex.getUnvisitedNeighbor();
                while (!next.isVisited()) {
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
}

