import java.util.Arrays;
import java.util.Iterator;

/**
 A class that implements the ADT list by using a resizable array and
 gives it an iterator.

 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 5.0
 */
public class ArrayListWithListIterator<T> implements ListWithIteratorInterface<T>
{
    private T[] list; // Array of list entries; ignore list[0]
    private int numberOfEntries;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public ArrayListWithListIterator()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public ArrayListWithListIterator(int initialCapacity)
    {
        integrityOK = false;

        // Is initialCapacity too small?
        if (initialCapacity < DEFAULT_CAPACITY)
            initialCapacity = DEFAULT_CAPACITY;
       // else // Is initialCapacity too big?
            //checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempList = (T[])new Object[initialCapacity + 1];
        list = tempList;
        numberOfEntries = 0;
        integrityOK = true;
    } // end constructor

/* < Implementations of the methods of the ADT list go here;
     you can see them in Chapter 11, beginning at Segment 11.5. */

    public Iterator<T> iterator()
    {
        return new IteratorForArrayList();
    } // end iterator

    public Iterator<T> getIterator()
    {
        return iterator();
    } // end getIterator



    @Override
    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public void add(T newEntry)
    {
        //checkIntegrity();
        list[numberOfEntries + 1] = newEntry;
        numberOfEntries++;
        ensureCapacity();
    } // end add

    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public void add(T newEntry, int givenPosition)
    {
        //checkIntegrity();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1))
        {
            if (givenPosition <= numberOfEntries)
                makeRoom(givenPosition);
            list[givenPosition] = newEntry;
            numberOfEntries++;
            ensureCapacity(); // Ensure enough room for next add
        }
        else
            throw new IndexOutOfBoundsException(
                    "Given position of add's new entry is out of bounds.");
    } // end add

    private void makeRoom(int givenPosition)
    {
        int newIndex = givenPosition;
        int lastIndex = numberOfEntries;
        for (int index = lastIndex; index >= newIndex; index--)
            list[index + 1] = list[index];
    }  // end makeRoom

    @Override
    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public T remove(int givenPosition)
    {
        //checkIntegrity();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            // Assertion: The list is not empty
            T result = list[givenPosition]; // Get entry to be removed
            // Move subsequent entries towards entry to be removed,
            // unless it is last in list
            if (givenPosition < numberOfEntries)
                removeGap(givenPosition);
            list[numberOfEntries] = null;
            numberOfEntries--;
            return result; // Return reference to removed entry
        }
        else
            throw new IndexOutOfBoundsException(
                    "Illegal position given to remove operation.");
    } // end remove

    // Shifts entries that are beyond the entry to be removed to the
    // next lower position.
    // Precondition: 1 <= givenPosition < numberOfEntries;
    //               numberOfEntries is list's length before removal;
    //               checkIntegrity has been called.
    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    private void removeGap(int givenPosition)
    {
        int removedIndex = givenPosition;
        for (int index = removedIndex; index < numberOfEntries; index++)
            list[index] = list[index + 1];
    } // end removeGap

    @Override
    public void clear() {

    }

    @Override
    public T replace(int givenPosition, T newEntry) {
        return null;
    }

    @Override
    public T getEntry(int givenPosition) {
        return null;
    }

    @Override
    public T[] toArray()
    {
        //checkIntegrity();

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
        for (int index = 0; index < numberOfEntries; index++)
        {
            result[index] = list[index + 1];
        } // end for

        return result;
    } // end toArray

    @Override
    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public boolean contains(T anEntry)
    {
        //checkIntegrity();
        boolean found = false;
        int index = 1;
        while (!found && (index <= numberOfEntries))
        {
            if (anEntry.equals(list[index]))
                found = true;
            index++;
        } // end while
        return found;
    } // end contains

    @Override
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0; // Or getLength() == 0;
    }

    // Doubles the capacity of the array list if it is full.
    // Precondition: checkIntegrity has been called.
    private void ensureCapacity()
    {
        int capacity = list.length - 1;
        if (numberOfEntries >= capacity)
        {
            int newCapacity = 2 * capacity;
            //checkCapacity(newCapacity); // Is capacity too big?
            list = Arrays.copyOf(list, newCapacity + 1);
        } // end if
    } // end ensureCapacity

    private class IteratorForArrayList implements Iterator<T>
    {
        private int     nextIndex;     // Index of next entry in the iteration
        private boolean wasNextCalled; // Needed by remove

        private IteratorForArrayList()
        {
            nextIndex = 1;         // Iteration begins at list's first entry
            wasNextCalled = false;
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

    } // end IteratorForArrayList
} // end ArrayListWithIterator

