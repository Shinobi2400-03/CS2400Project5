import java.util.EmptyStackException;

public class LinkedQueue<T> implements QueueInterface<T>
{
    private Node firstNode;
    private Node lastNode;

    public LinkedQueue()
    {
        firstNode = null;
        lastNode = null;
    }

    @Override
    public void enqueue(T newEntry)
    {
        Node newNode = new Node(newEntry);

        if(isEmpty())
            firstNode = newNode;
        else
            lastNode.setNextNode(newNode);

        lastNode = newNode;
    }

    @Override
    public T dequeue()
    {
        T front = getFront();

        firstNode.setData(null);
        firstNode = firstNode.getNextNode();

        if(firstNode == null)
            lastNode = null;

        return front;
    }

    @Override
    public T getFront()
    {
        if(isEmpty())
            throw new EmptyQueueException();
        else
            return firstNode.getData();
    }

    @Override
    public boolean isEmpty()
    {
        return (firstNode == null) && (lastNode == null);
    }

    @Override
    public void clear()
    {
        firstNode = null;
        lastNode = null;
    }
    private class Node
    {
        private T    data; // Entry in queue
        private Node next; // Link to next node

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node linkPortion)
        {
            data = dataPortion;
            next = linkPortion;
        } // end constructor

        private T getData()
        {
            return data;
        } // end getData

        private void setData(T newData)
        {
            data = newData;
        } // end setData

        private Node getNextNode()
        {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        } // end setNextNode
    } // end Node
}
