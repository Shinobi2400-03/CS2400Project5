import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 A class that implements the ADT list by using a chain of linked nodes.
 The list has an iterator. The class is similar to LList.

 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 5.0
 */
public class LinkedListWithIterator<T> implements ListWithIteratorInterface<T>
{
    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    private Node firstNode;       // Head reference to first node
    private Node lastNode;        // Tail reference to last node
    private int  numberOfEntries; // Number of entries in list

    public LinkedListWithIterator()
    {
        initializeDataFields();
    } // end default constructor

/*	< Implementations of the methods of the ADT list go here;
     you can see them in Chapter 12, beginning at Segment 12.7 >
   . . . */

    // @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
    private void initializeDataFields()
    {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    } // end initializeDataFields


    public Iterator<T> iterator()
    {
        return new IteratorForLinkedList();
    } // end iterator

    public Iterator<T> getIterator()
    {
        return iterator();
    } // end getIterator

    @Override
    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0

    public void add(T newEntry)
    {
        Node newNode = new Node(newEntry);

        if (isEmpty())
            firstNode = newNode;
        else                              // Add to end of nonempty list
        {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode); // Make last node reference new node
        } // end if

        numberOfEntries++;
    } // end add



    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public void add(T newEntry, int givenPosition)
    {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1))
        {
            Node newNode = new Node(newEntry);
            if (givenPosition == 1)                // Case 1
            {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            }
            else									         // Case 2: list is not empty
            {                                      // and givenPosition > 1
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            } // end if
            numberOfEntries++;
        }
        else
            throw new IndexOutOfBoundsException(
                    "Illegal position given to add operation.");
    } // end add

    // Returns a reference to the node at a given position.
    // Precondition: The chain is not empty;
    //               1 <= givenPosition <= numberOfEntries.
    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    private Node getNodeAt(int givenPosition)
    {
        // Assertion: (firstNode != null) &&
        //            (1 <= givenPosition) && (givenPosition <= numberOfEntries)
        Node currentNode = firstNode;
        // Traverse the chain to locate the desired node
        // (skipped if givenPosition is 1)
        for (int counter = 1; counter < givenPosition; counter++)
            currentNode = currentNode.getNextNode();
        // Assertion: currentNode != null
        return currentNode;
    } // end getNodeAt

    @Override
    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public T remove(int givenPosition)
    {
        T result = null;                           // Return value
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            // Assertion: !isEmpty()
            if (givenPosition == 1)                 // Case 1: Remove first entry
            {
                result = firstNode.getData();        // Save entry to be removed
                firstNode = firstNode.getNextNode(); // Remove entry
            }
            else                                    // Case 2: Not first entry
            {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                result = nodeToRemove.getData();    // Save entry to be removed
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);  // Remove entry
            } // end if
            numberOfEntries--;                     // Update count
            return result;                         // Return removed entry
        }
        else
            throw new IndexOutOfBoundsException(
                    "Illegal position given to remove operation.");
    } // end remove

    @Override
    public void clear()
    {
        initializeDataFields();
    } // end clear

    @Override
    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public T replace(int givenPosition, T newEntry)
    {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            // Assertion: !isEmpty()
            Node desiredNode = getNodeAt(givenPosition);
            T originalEntry = desiredNode.getData();
            desiredNode.setData(newEntry);
            return originalEntry;
        }
        else
            throw new IndexOutOfBoundsException(
                    "Illegal position given to replace operation.");
    } // end replace

    @Override
    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public T getEntry(int givenPosition)
    {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            // Assertion: !isEmpty()
            return getNodeAt(givenPosition).getData();
        }
        else
            throw new IndexOutOfBoundsException(
                    "Illegal position given to getEntry operation.");
    } // end getEntry

    @Override
    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public T[] toArray()
    {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        } // end while

        return result;
    } // end toArray

    @Override
    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        } // end while

        return found;
    } // end contains

    @Override
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public boolean isEmpty()
    {
        boolean result;

        if (numberOfEntries == 0) // Or getLength() == 0
        {
            // Assertion: firstNode == null
            result = true;
        }
        else
        {
            // Assertion: firstNode != null
            result = false;
        } // end if

        return result;
    } // end isEmpty


    private class IteratorForLinkedList implements Iterator<T>
    {
        private Node nextNode;

        private IteratorForLinkedList()
        {
            nextNode = firstNode;
        } // end default constructor

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }

        // Implementations of the methods in the interface Iterator go here.

    } // end IteratorForLinkedList

    private class Node
    {
        private T    data; // Entry in list
        private Node next; // Link to next node

        private Node(T dataPortion)
        {
            data = dataPortion;
            next = null;
        } // end constructor

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
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
} // end LinkedListWithIterator



