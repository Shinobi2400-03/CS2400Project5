import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

//Modified Graph class from lecture slides.
public class Graph<T>
{
    private final int vertices;
    private T[] labels;
    private boolean [][] edges;

    public Graph(int vertices)
    {
        this.vertices = vertices;

        //Initializing edges as a Stack object array.
        edges = new boolean[vertices][vertices];

        //Initializing labels as a Stack object array.
        labels = (T[]) new Object[vertices];
    }

    //addEdge method takes in a source(index) of an array and pushes the target.
    public void addEdge(int source, int target) { edges[source][target] = true; }

    public boolean isEdge(int source, int target) { return edges[source][target]; }
    //addLabel method labels certain indexes with specific number i.e 0 = A, 1 = B ... etc.
    void addLabel(int vertex, T newLabel) { labels[vertex] = newLabel; }

    //getLabel method returns label of the specific index indicated in the array.
    public T getLabel(int vertex) { return labels[vertex]; }

    //reset method reinitialized the boolean array so all its values will be equal to false.
//    //void reset() {
//
//        //Initializing edges as a Stack object array.
//        edges = new boolean[vertices][vertices];
//
//        //Initializing labels as a Stack object array.
//        labels = (T[]) new Object[vertices];}

    public int[] neighbors(int vertex) {

        int count = 0;

        for (int i = 0; i < labels.length; i++) {
            if (edges[vertex][i])
                count++;
        }
        int [] answer = new int[count];
        int newCount = 0;
        for (int i = 0; i < labels.length; i++) {
            if (edges[vertex][i])
            {
                answer[newCount] = i;
                newCount++;
            }
        }
        return answer;
    }

    //getBreadthFirstTraversal method lists the origin, then its neighbors, then their neighbors as well.
    void getBreadthFirstTraversal(int source)
    {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>(); //Creating a queue container to store edges and use the queue methods.

        Queue<Integer> displayQueue = new ConcurrentLinkedQueue<>();
        displayQueue.add(source);
        queue.add(source);
        int count = 0;
        while (!queue.isEmpty())
        {
            source = queue.poll();

            int[] temp = neighbors(source);
            count = 0;
            while (count < (temp.length))
            {
                int target = temp[count];
                if(displayQueue.contains(target))
                    edges[source][target] = false;

                if (isEdge(source, target)) //Condition that will loop as long as we have entries in our queue.
                {
                    if(displayQueue.contains(target))
                        edges[source][target] = false;

                    displayQueue.add(target);
                    edges[source][target] = false;
                    queue.add(target); //Adding the newly visited element back in the queue.
                }
                count++;
            }
        }
        Object[] display = displayQueue.toArray();
        for (int i = 0; i < displayQueue.size(); i++)
            System.out.print(display[i] + " ");
    }

    //getDepthFirstTraversal method that begins at the origin visiting its neighbors and neighbor's neighbors,
    //until it has no unvisited neighbor, while backing up by one vertex it considers another neighbor.
    void getDepthFirstTraversal(int source)
    {
        Stack<Integer> stack = new Stack<>();

        Stack<Integer> displayStack = new Stack<>();

        //int count = 0;
        stack.push(source);
        displayStack.push(source);

        while(!stack.isEmpty())
        {
            source = stack.pop();

//            int target = 0;
//            int[] temp = neighbors(source);
//
//            if(temp.length > 0)
//                target = temp[0];


            Iterator<T> itr = Arrays.asList(labels[source]).iterator();

            while(itr.hasNext())
            {
                int v = (Integer) itr.next();
                if(!displayStack.contains(v))
                {
                    displayStack.push(v);
                    stack.push(v);
                }
            }
            //source++;

//            while(isEdge(source,target))
//            {
//                if(displayStack.contains(target))
//                    break;
//
//                stack.push(target);
//                displayStack.push(target);
//                edges[source][target] = false;
//            }
        }
        Object[] display = displayStack.toArray();
        for (int i = 0; i < displayStack.size(); i++)
            System.out.print(display[i] + " ");
    }
}

