import java.util.*;
//Modified Graph class from lecture slides.
public class Graph<T>
{
    private final int vertices;
    private final Stack<T>[] labels;
    private final Stack<T>[] edges;
    private boolean[] visited;

    public Graph(int vertices)
    {
        this.vertices = vertices;

        //Initializing edges as a Stack object array.
        edges = new Stack[vertices];
        for(int i = 0; i < vertices; i++)
            edges[i] = new Stack<>();

        //Initializing labels as a Stack object array.
        labels = new Stack[vertices];
        for(int i = 0; i < vertices; i++)
            labels[i] = new Stack<>();

        //Initializing visited as boolean array.
        visited = new boolean[vertices];
    }

    //addEdge method takes in a source(index) of an array and pushes the target.
    void addEdge(int source, T target) { edges[source].push(target); }

    //addLabel method labels certain indexes with specific number i.e 0 = A, 1 = B ... etc.
    void addLabel(int vertex, T newLabel) { labels[vertex].push(newLabel); }

    //getLabel method returns label of the specific index indicated in the array.
    public Stack getLabel(int vertex) { return labels[vertex]; }

    //reset method reinitialized the boolean array so all its values will be equal to false.
    void reset() { visited = new boolean[vertices];}

    //getBreadthFirstTraversal method lists the origin, then its neighbors, then their neighbors as well.
    void getBreadthFirstTraversal(int source)
    {
        reset(); //Resets boolean array so al entries are false.
        Queue<Integer> queue = new ArrayDeque<>(); //Creating a queue container to store edges and use the queue methods.

        visited[source] = true; //Changes indicated origin to true, as visited.
        System.out.print(getLabel(source)); //Prints indicated origin.
        queue.add(source); //Adds source to the front of the queue.

        while(queue.size() > 0) //Condition that will loop as long as we have entries in our queue.
        {
            source = queue.poll(); //Retrieves the first element in the queue.

            //Enhanced for loop that iterates to the neighbor of the indicated source, while simultaneously
            //assigning the neighbor to nextVertex.
            for (int nextVertex : (Iterable<Integer>) edges[source])
            {
                if (!visited[nextVertex]) //Condition to check if the source was visited or not.
                {
                    System.out.print(" -> " + getLabel(nextVertex)); //Printing out the vertex that was visited.
                    visited[nextVertex] = true; //Assigning the neighbor as true or visited.
                    queue.add(nextVertex); //Adding the newly visited element back in the queue.
                }
            }
        }
        System.out.println(); //Printing a new line to display the correct order of outputs.
    }
    //getDepthFirstTraversal method that begins at the origin visiting its neighbors and neighbor's neighbors,
    //until it has no unvisited neighbor, while backing up by one vertex it considers another neighbor.
    void getDepthFirstTraversal(int source)
    {
        reset(); //Resets boolean array so al entries are false.
        while(source < vertices) //In order to iterate through each of the established vertexes a while loop is used.
        {
            Stack<Integer> stack = new Stack<>(); //Creating a stack container to store edges and use stack methods.

            stack.push(source); //Pushing the vertex to the top of the stack.

            while (!stack.isEmpty()) //Condition to loop if the stack is not empty.
            {
                source = stack.peek(); //source is assigned the top of the stack.
                stack.pop(); //top of the stack is removed

                if (!visited[source]) //Condition to check if the indicated vertex has not been visited,
                    visited[source] = true; //If condition is true then that indicated vertex has been visited
                //and needs to be visited or marked true.

                //Enhanced for loop that iterates to the neighbor of the indicated source, while simultaneously
                //assigning the neighbor to nextVertex.
                for (int nextVertex : (Iterable<Integer>) edges[source])
                {
                    System.out.print(getLabel(source) + " -> "); //Printing out each vertex
                    System.out.print(getLabel(nextVertex)); //and its corresponding neighbor.
                    System.out.print("\t\t"); //Printing tabs for aesthetic purposes.

                    if (!visited[source]) //Condition that checks if the indicated source has been visited.
                        stack.push(nextVertex); //If true push the unvisited source to the stack.
                }
            }
            source++; //Iterates to the next vertex.
            System.out.println(); //Prints a new line to indicate a new source and its neighbors.
        }
    }
}