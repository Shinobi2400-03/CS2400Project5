import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

//Modified Graph class from lecture slides.
public class Graph<T>
{
    private final int vertices;
    private T[] labels;
    private boolean [][] edges;
<<<<<<< HEAD
//    private LinkedList<Integer> adjList[];
=======
    private String[] label;
>>>>>>> d312ba09f81d3aee985d765d25cce4f5f511e4c8

    public Graph(int vertices)
    {
        this.vertices = vertices;

        //Initializing edges as a Stack object array.
        edges = new boolean[vertices][vertices];

        //Initializing labels as a Stack object array.
        labels = (T[]) new Object[vertices];

<<<<<<< HEAD
//        adjList = new LinkedList[vertices];
=======
        label = new String[vertices];

>>>>>>> d312ba09f81d3aee985d765d25cce4f5f511e4c8
    }

    //addEdge method takes in a source(index) of an array and pushes the target.
    public void addEdge(int source, int target)
    {
        edges[source][target] = true;
//        adjList[source].add(target);
    }

    public boolean isEdge(int source, int target) { return edges[source][target]; }
    //addLabel method labels certain indexes with specific number i.e 0 = A, 1 = B ... etc.
    void addLabel(int vertex, T newLabel) { labels[vertex] = newLabel; }

    void addLabel(int vertex, String newLabel) { label[vertex] = newLabel; }

    //getLabel method returns label of the specific index indicated in the array.
    public T getLabel(int vertex) { return labels[vertex]; }

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

    public void reset()
    {
        //Initializing edges as a Stack object array.
        edges = new boolean[vertices][vertices];

        //Initializing labels as a Stack object array.
        labels = (T[]) new Object[vertices];
    }

    //getBreadthFirstTraversal method lists the origin, then its neighbors, then their neighbors as well.
    public Queue<T> getBreadthFirstTraversal(int source)
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
//                    if(displayQueue.contains(target))
//                        edges[source][target] = false;

                    displayQueue.add(target);
                    edges[source][target] = false;
                    queue.add(target); //Adding the newly visited element back in the queue.
                }
                count++;
            }
        }
        Object[] display = displayQueue.toArray();
        Queue<T> result = new ArrayDeque<>();
        for (int i = 0; i < displayQueue.size(); i++)
        {
<<<<<<< HEAD
            T entry = getLabel((int)display[i]);
            result.add(entry);
            System.out.print(entry + " ");
=======
            result.add((T) label[(int) display[i]]);
>>>>>>> d312ba09f81d3aee985d765d25cce4f5f511e4c8
        }
        return result;
    }

<<<<<<< HEAD
    public void getDepthFirstTraversal1(int source)
    {
        Queue<T>
    }

    public void getDepthFirstTraversal(int source)
=======
    public Stack<T> getDepthFirstTraversal(int source)
>>>>>>> d312ba09f81d3aee985d765d25cce4f5f511e4c8
    {
        Stack<Integer> stack = new Stack();
        Stack<Integer> displayStack = new Stack();

        int count = 0;
        stack.push(source);
        displayStack.push(source);

        while(!stack.isEmpty())
        {
            source = stack.pop();
            int target = 0;
            int[] tempArr = neighbors(source);

            if(tempArr.length > 0)
                target = tempArr[0];

            if(displayStack.contains(target))
            {
                int counter = 0;
                if(tempArr.length > 1)
                    target = tempArr[counter++];
                else
                {
                    int temp = displayStack.pop();
                    source = displayStack.peek();
                    target = (Integer) getLabel(source);
                    displayStack.push(temp);
                }
            }

            if(displayStack.contains(target))
            {
                for(int i = 0; i < edges.length; i++)
                {
                    for(int j = 0; j < edges.length; j++)
                    {
                        if(!displayStack.contains(i))
                        {
                            if(isEdge(i,j))
                            {
                                stack.push(i);
                                displayStack.push(i);
                                stack.push(j);
                                displayStack.push(j);
                                edges[i][j] = false;
                            }
                        }
                    }
                }
            }

            while(isEdge(source,target))
            {
                stack.push(target);
                displayStack.push(target);
                edges[source][target] = false;

            }
        }
        Object[] display = displayStack.toArray();
        for (int i = 0; i < displayStack.size(); i++)
            System.out.print(label[(int) display[i]] + " ");

        Stack<T> result = new Stack();

        for (int i = 0; i < displayStack.size(); i++)
        {
            result.add((T) label[(int) display[i]]);
        }
        return result;
    }
}

