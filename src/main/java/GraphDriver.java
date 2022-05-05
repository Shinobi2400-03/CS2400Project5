public class GraphDriver {
    public static void main(String[] args) {
        Graph newGraph = new Graph(9);

        newGraph.addLabel(0,"A");
        newGraph.addLabel(1,"B");
        newGraph.addLabel(2,"C");
        newGraph.addLabel(3,"D");
        newGraph.addLabel(4,"E");
        newGraph.addLabel(5,"F");
        newGraph.addLabel(6,"G");
        newGraph.addLabel(7,"H");
        newGraph.addLabel(8,"I");

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

<<<<<<< HEAD

        newGraph.bfs("A");
        //newGraph.getDepthFirstTraversal(0);
        newGraph.dfs();

=======
        System.out.println("Breadth First Traversal");
        newGraph.getBreadthFirstTraversal(0);

        System.out.println("Depth First Traversal");
        newGraph.getDepthFirstTraversal(0);
>>>>>>> ed1c1acfe6f5040547507c525e48bdabd935fe42
    }
}
