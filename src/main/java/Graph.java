public class Graph<E>
{
    private boolean[][] edges;
    private E[] labels;

    public Graph(int n)
    {
        edges = new boolean[n][n];
        labels = (E[]) new Object[n];
    }

    public E getLabel(int vertex)
    {
        return labels[vertex];
    }

}
