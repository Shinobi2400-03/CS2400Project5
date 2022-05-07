import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

//Modified Graph class from lecture slides.
public class Graph<T>
{
    private final int vertices;
    private T[] labels;
    private boolean [][] edges;
    private String[] label;

    public Graph(int vertices)
    {
        //This is this,
        this.vertices = vertices;

        //Initializing edges as a Stack object array.
        edges = new boolean[vertices][vertices];

        //Initializing labels as a Stack object array.
        labels = (T[]) new Object[vertices];

        label = new String[vertices];

    }

    //addEdge method takes in a source(index) of an array and pushes the target.
    public void addEdge(int source, int target) { edges[source][target] = true; }

    //isEdge method returns true if the edge was added and false if not.
    public boolean isEdge(int source, int target) { return edges[source][target]; }

    //addLabel method returns the target of the source, if the edge is (1, 0) then it returns 0.
    void addLabel(int vertex, T newLabel) { labels[vertex] = newLabel; }

    //addLabel method labels certain indexes with specific number i.e 0 = A, 1 = B ... etc.
    void addLabel(int vertex, String newLabel) { label[vertex] = newLabel; }

    //getLabel method returns label of the specific index indicated in the array.
    public T getLabel(int vertex) { return labels[vertex]; }

    //neighhbors method returns the number of neighbors any vertex would have,
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

    //getBreadthFirstTraversal method visits the origin and the origin’s neighbors.
    //Then, considers each of these neighbors and visits their neighbors.
    public Queue<T> getBreadthFirstTraversal(int source)
    {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>(); //Creating a queue container to store edges and use the queue methods.
        Queue<Integer> displayQueue = new ConcurrentLinkedQueue<>(); //Creating an empty queue to display the path.

        displayQueue.add(source);
        queue.add(source);

        int count = 0;
        while (!queue.isEmpty()) //Condition to loop if queue still have a path to follow.
        {
            source = queue.poll(); //Popping source to fill queue at a later time.

            int[] temp = neighbors(source); //Creating an array of neighbors from the source.
            count = 0;

            while (count < (temp.length))
            {
                int target = temp[count]; //Assigning target as the neighbor of source.

                if(displayQueue.contains(target)) //Condition that checks if the target has been visited.
                    edges[source][target] = false; //If so edge will be marked as visited.

                if (isEdge(source, target)) //Condition that will loop as long as we have entries in our queue.
                {
                    queue.add(target); //Adding the newly visited element into the queue and displayQueue.
                    displayQueue.add(target);
                    edges[source][target] = false; //Marking edge as visited.
                }
                count++; //Incrementing count to visit the next neighbor of the source.
            }
        }

        Object[] display = displayQueue.toArray(); //Creating array of the displayQueue's elements.
        Queue<T> result = new ArrayDeque<>(); //Creating return queue.
        for (int i = 0; i < displayQueue.size(); i++) //Loop to loop through array
            System.out.print(label[(int) display[i]] + " "); //Printing out array.

        for (int i = 0; i < displayQueue.size(); i++) //Loop to add array's contents to the return queue.
        {
            result.add((T) label[(int) display[i]]); //Adding to return queue.
        }
        return result; //Returning return queue.
    }

    //getDepthTraversal method visits the origin, then a neighbor of the origin,
    //and a neighbor of the neighbor. It continues in
    //this fashion until it finds no unvisited neighbor.
    //Backing up by one vertex, it considers another
    //neighbor.
    public Stack<T> getDepthFirstTraversal(int source)
    {
        Stack<Integer> stack = new Stack(); //Creating an empty stack to push and pop through the graph.
        Stack<Integer> displayStack = new Stack(); //Creating an empty stack to display the path.

        int count = 0;
        stack.push(source); //Pushing the source to begin traversal.
        displayStack.push(source); //Pushing the source to indicate this is where the path began,

        while(!stack.isEmpty())
        {
            source = stack.pop(); //Emptying stack to ensure that it will be filled at a later point in time.
            int target = 0;
            int[] tempArr = neighbors(source); //Creating an array of the sources neighbors.

            if(tempArr.length > 0) //Checking to make sure the source has negihbors.
                target = tempArr[0]; //Using the first neighbor of the source.

            if(displayStack.contains(target)) //Condition that checks if the neighbor has already been visited.
            {
                int counter = 0;
                if(tempArr.length > 1)
                    target = tempArr[counter++];//Assigning next neighbor of source if first neighbor has been visited.
                else if(tempArr.length < 1) //Condition if source does not have more than one neighbor.
                {
                    if(displayStack.contains(target)) //Condition to make sure that neighbor indeed has been visited.
                    {
                        for(int i = 0; i < edges.length; i++)
                        {
                            for(int j = 0; j < edges.length; j++)
                            {
                                if(!displayStack.contains(i)) //Looping through to any remaining edges that have yet to be visited.
                                {
                                    if(isEdge(i,j)) //Condition to check if the edge has yet to be visited.
                                    {
                                        stack.push(i); //If not pushing the source to the stack and display stack.
                                        displayStack.push(i);
                                        stack.push(j); //If not pushing the target to the stack and display stack.
                                        displayStack.push(j);
                                        edges[i][j] = false; //Marking the indicted edge as visited.
                                    }
                                }
                            }
                        }
                    }
                }
                else //Final condition that will execute if the above two conditions do not execute.
                {
                    int temp = displayStack.pop(); //Popping previously visited source.
                    source = displayStack.peek(); //Assigning previous vertex to source
                    target = (Integer) getLabel(source); //Obtaining the last target of the source if any.
                    displayStack.push(temp); //Pushing the previous vertex back to the displayStack.
                }
            }

            if(displayStack.contains(target)) //Condition to make sure that neighbor indeed has been visited.
            {
                for(int i = 0; i < edges.length; i++)
                {
                    for(int j = 0; j < edges.length; j++)
                    {
                        if(!displayStack.contains(i)) //Looping through to any remaining edges that have yet to be visited.
                        {
                            if(isEdge(i,j)) //Condition to check if the edge has yet to be visited.
                            {
                                stack.push(i); //If not pushing the source to the stack and display stack.
                                displayStack.push(i);
                                stack.push(j); //If not pushing the target to the stack and display stack.
                                displayStack.push(j);
                                edges[i][j] = false; //Marking the indicted edge as visited.
                            }
                        }
                    }
                }
            }

            while(isEdge(source,target)) //Condition to check if the first neighbor of the source has been visited.
            {
                stack.push(target); //If not pushing the source to the stack and display stack.
                displayStack.push(target);
                edges[source][target] = false; //Marking the indicted edge as visited.

            }
        }

        Object[] display = displayStack.toArray(); //Moving stack elements to stack array.
        for (int i = 0; i < displayStack.size(); i++) //Loop to display stack array.
            System.out.print(label[(int) display[i]] + " "); //Printing out stack array.

        Stack<T> result = new Stack(); //Creating new stack to return for JUnit test.

        for (int i = 0; i < displayStack.size(); i++) //Loop to loop through stack.
        {
            result.add((T) label[(int) display[i]]); //Adding stack elements to new stack.
        }
        return result; //Returning stack.
    }
}