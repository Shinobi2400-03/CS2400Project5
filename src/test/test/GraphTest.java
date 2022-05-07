import org.junit.jupiter.api.Assertions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {

    @org.junit.jupiter.api.Test
    void getBreadthFirstTraversal()
    {
        // Arrange
        Graph testGraph = new Graph(9);

        testGraph.addLabel(0,1);
        testGraph.addLabel(0,3);
        testGraph.addLabel(0,4);

        testGraph.addLabel(1,4);

        testGraph.addLabel(2,1);

        testGraph.addLabel(3,6);

        testGraph.addLabel(4,5);
        testGraph.addLabel(4,7);

        testGraph.addLabel(5,2);
        testGraph.addLabel(5,7);

        testGraph.addLabel(6,7);

        testGraph.addLabel(7,8);

        testGraph.addLabel(8,5);


        testGraph.addLabel(0,"A");
        testGraph.addLabel(1,"B");
        testGraph.addLabel(2,"C");
        testGraph.addLabel(3,"D");
        testGraph.addLabel(4,"E");
        testGraph.addLabel(5,"F");
        testGraph.addLabel(6,"G");
        testGraph.addLabel(7,"H");
        testGraph.addLabel(8,"I");

        testGraph.addEdge(0,1);
        testGraph.addEdge(0,3);
        testGraph.addEdge(0,4);

        testGraph.addEdge(1,4);

        testGraph.addEdge(2,1);

        testGraph.addEdge(3,6);

        testGraph.addEdge(4,5);
        testGraph.addEdge(4,7);

        testGraph.addEdge(5,2);
        testGraph.addEdge(5,7);

        testGraph.addEdge(6,7);

        testGraph.addEdge(7,8);

        testGraph.addEdge(8,5);

        // Act
        Queue actualTraversalOrder = testGraph.getBreadthFirstTraversal(0);
        Queue expectedTraversalOrder = new ArrayDeque();

        expectedTraversalOrder.add("A");
        expectedTraversalOrder.add("B");
        expectedTraversalOrder.add("D");
        expectedTraversalOrder.add("E");
        expectedTraversalOrder.add("G");
        expectedTraversalOrder.add("F");
        expectedTraversalOrder.add("H");
        expectedTraversalOrder.add("C");
        expectedTraversalOrder.add("I");

        // Assert
        assertEquals(expectedTraversalOrder, actualTraversalOrder);
    }

    @org.junit.jupiter.api.Test
    void getDepthFirstTraversal()
    {
        Graph testGraph = new Graph(9);

        testGraph.addLabel(0,1);
        testGraph.addLabel(0,3);
        testGraph.addLabel(0,4);

        testGraph.addLabel(1,4);

        testGraph.addLabel(2,1);

        testGraph.addLabel(3,6);

        testGraph.addLabel(4,5);
        testGraph.addLabel(4,7);

        testGraph.addLabel(5,2);
        testGraph.addLabel(5,7);

        testGraph.addLabel(6,7);

        testGraph.addLabel(7,8);

        testGraph.addLabel(8,5);

        testGraph.addEdge(0,1);
        testGraph.addEdge(0,3);
        testGraph.addEdge(0,4);

        testGraph.addEdge(1,4);

        testGraph.addEdge(2,1);

        testGraph.addEdge(3,6);

        testGraph.addEdge(4,5);
        testGraph.addEdge(4,7);

        testGraph.addEdge(5,2);
        testGraph.addEdge(5,7);

        testGraph.addEdge(6,7);

        testGraph.addEdge(7,8);

        testGraph.addEdge(8,5);

        testGraph.addLabel(0,"A");
        testGraph.addLabel(1,"B");
        testGraph.addLabel(2,"C");
        testGraph.addLabel(3,"D");
        testGraph.addLabel(4,"E");
        testGraph.addLabel(5,"F");
        testGraph.addLabel(6,"G");
        testGraph.addLabel(7,"H");
        testGraph.addLabel(8,"I");

        // Act
        Stack actualTraversalOrder = testGraph.getDepthFirstTraversal(0);
        Stack expectedTraversalOrder = new Stack<>();

        expectedTraversalOrder.add("A");
        expectedTraversalOrder.add("B");
        expectedTraversalOrder.add("E");
        expectedTraversalOrder.add("F");
        expectedTraversalOrder.add("C");
        expectedTraversalOrder.add("H");
        expectedTraversalOrder.add("I");
        expectedTraversalOrder.add("D");
        expectedTraversalOrder.add("G");

        assertEquals(actualTraversalOrder, expectedTraversalOrder);


    }
}