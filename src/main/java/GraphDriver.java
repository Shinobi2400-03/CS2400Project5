import java.io.IOException;

public class GraphDriver
{
    public static void main(String[] args) throws IOException
    {
        Graph<String> newGraph = new Graph<>(9);

        newGraph.setLabel(0, "A");
        newGraph.setLabel(1, "B");
        newGraph.setLabel(2, "C");
        newGraph.setLabel(3, "D");
        newGraph.setLabel(4, "E");
        newGraph.setLabel(5, "F");
        newGraph.setLabel(6, "G");
        newGraph.setLabel(7, "H");
        newGraph.setLabel(8, "I");

        newGraph.addEdge(0,1);
        newGraph.addEdge(0,3);
        newGraph.addEdge(0,4);
        newGraph.addEdge(1,4);
        newGraph.addEdge(3,6);
        newGraph.addEdge(4,5);
        newGraph.addEdge(4,7);
        newGraph.addEdge(6,7);
        newGraph.addEdge(5,2);
        newGraph.addEdge(5,7);
        newGraph.addEdge(7,8);
        newGraph.addEdge(2,1);
        newGraph.addEdge(8,5);

        newGraph.getDepthFirstTraversal("A");//

    }


}
