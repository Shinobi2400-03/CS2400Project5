import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @org.junit.jupiter.api.Test
    void getBreadthFirstTraversal()
    {
        // Arrange
        Graph<String> testGraph = new Graph<>(9);

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
        Queue<String> actualTraversalOrder = testGraph.getBreadthFirstTraversal(0);
        Queue<String> expectedTraversalOrder = new ConcurrentLinkedQueue<>();

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
        assertEquals(actualTraversalOrder, expectedTraversalOrder);
    }
}