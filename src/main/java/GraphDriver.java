public class GraphDriver {
    public static void main(String[] args) {
        Graph graph1 = new Graph(9);

        graph1.addLabel(0,1);
        graph1.addLabel(0,3);
        graph1.addLabel(0,4);

        graph1.addLabel(1,4);

        graph1.addLabel(2,1);

        graph1.addLabel(3,6);

        graph1.addLabel(4,5);
        graph1.addLabel(4,7);

        graph1.addLabel(5,2);
        graph1.addLabel(5,7);

        graph1.addLabel(6,7);

        graph1.addLabel(7,8);

        graph1.addLabel(8,5);




//        graph1.addLabel(0,"A");
//        graph1.addLabel(1,"B");
//        graph1.addLabel(2,"C");
//        graph1.addLabel(3,"D");
//        graph1.addLabel(4,"E");
//        graph1.addLabel(5,"F");
//        graph1.addLabel(6,"G");
//        graph1.addLabel(7,"H");
//        graph1.addLabel(8,"I");

        graph1.addEdge(0,1);
        graph1.addEdge(0,3);
        graph1.addEdge(0,4);

        graph1.addEdge(1,4);

        graph1.addEdge(2,1);

        graph1.addEdge(3,6);

        graph1.addEdge(4,5);
        graph1.addEdge(4,7);

        graph1.addEdge(5,2);
        graph1.addEdge(5,7);

        graph1.addEdge(6,7);

        graph1.addEdge(7,8);

        graph1.addEdge(8,5);

//        System.out.println("Breadth First Traversal");
//        graph1.getBreadthFirstTraversal(0);

        System.out.println("\nDepth First Traversal");
        graph1.getDepthFirstTraversal(0);
//
//        Graph graph2 = new Graph(3);
//
//
//        graph2.addLabel(0,"A");
//        graph2.addLabel(1,"B");
//        graph2.addLabel(2,"C");
//
//        graph2.addEdge(0,0);
//        graph2.addEdge(1,0);
//        graph2.addEdge(1,2);
//        graph2.addEdge(2,1);
//
//        System.out.println("\nBreadth First Traversal");
//        graph2.getBreadthFirstTraversal(0);

//        System.out.println("Depth First Traversal");
//        graph2.getDepthFirstTraversal(0);

//        Graph graph3 = new Graph(5);
//
//        graph3.addLabel(0,"A");
//        graph3.addLabel(1,"B");
//        graph3.addLabel(2,"C");
//        graph3.addLabel(3,"D");
//        graph3.addLabel(4,"E");
//
//        graph3.addEdge(0,3);
//        graph3.addEdge(1,4);
//        graph3.addEdge(3,1);
//        graph3.addEdge(4,2);
//        graph3.addEdge(4,3);
//
//        System.out.println("\nBreadth First Traversal");
//        graph3.getBreadthFirstTraversal(0);

//        System.out.println("Depth First Traversal");
//        graph3.getDepthFirstTraversal(0);

    }
}