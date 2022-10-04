package coen352.list;

/**
 * Array-based list implementation
 * @param <E>
 */
public class AList<E> implements ADTList<E> {

    private static final int DEFAULTSIZE = 10; // Default size
    private int maxSize; // Maximum size of list
    private int currSize = 0;
    private int curr = -1; // Position of current element
    private E[] listArray; // Array holding list elements

    /**
     * Constructors
     */
    /**
     * Create a list with the default capacity.
     */
    public AList() {
        this(DEFAULTSIZE);
    }

    /**
     * Create a new list object.
     *
     * @param size Max # of elements list can contain.
     */
    @SuppressWarnings("unchecked") // Generic array allocation
    public AList(int size) {
        maxSize = size;
        curr = -1;
        currSize = 0;
        listArray = (E[]) new Object[size]; // Create listArray
    }

    /**
     * Reinitialize the list
     */
    @Override
    public void clear() {
        curr = -1;
        currSize = 0;
        listArray = (E[]) new Object[maxSize];
    } // Simply reinitialize values

    /**
     * Insert "it" at current position
     * @param it
     * @param pos
     */
    public void insert(E it, int pos) {

        assert currSize < maxSize : "List capacity exceeded";

        for (int i = currSize; i > pos; i--) // Shift elements up
        {
            listArray[i] = listArray[i - 1]; // to make room
        }
        listArray[pos] = it;
        currSize++; // Increment list size
        curr++;
        
    }
    
    @Override
    public void insert(E it) {
        this.insert(it, curr);
    }

    /**
     * Append "it" to list
     * @param it
     */
    @Override
    public void append(E it) {
        assert currSize < maxSize : "List capacity exceeded";
        listArray[currSize++] = it;
        curr = Math.max(0, curr);
    }

    /**
     * Remove and return the current element
     */
    @Override
    public E remove() {
        if (currSize == 0) // An empty list
        {
            return null;
        }
        
        E it = listArray[curr]; // Copy the element
        for (int i = curr; i < currSize-1; i++) // Shift them down
        {
            listArray[i] = listArray[i + 1];
        }
        currSize--; // Decrement size
        curr--;
        return it;
    }

    @Override
    public void moveToStart() {
        curr = 0;
    } // Set to front

    @Override
    public void moveToEnd() {
        curr = currSize - 1;
    } // Set at end

    @Override
    public void prev() {
        curr = Math.max(0, curr - 1);
    } // Back up

    @Override
    public void next() {
        if (curr == currSize -1) {
            System.err.println("No mode element after");
        }
        curr = Math.min(currSize -1, curr + 1);
    }

    /**
     * @return List size
     */
    @Override
    public int length() {
        return currSize;
    }

    /**
     * @return Current position
     */
    @Override
    public int currPos() {
        return curr;
    }

    /**
     * Set current list position to "pos"
     */
    @Override
    public void moveToPos(int pos) {
        assert (pos >= 0) && (pos < currSize) : "Pos out of range";
        curr = pos;
    }
    
    /**
     * check if our object is empty
     * @return 
     */
    public boolean hasElement() {
        return length() > 0;
    }
    
    public boolean checkPosition(int pos) {
        return (pos >= 0) && (pos < currSize);
    }

    /**
     * @param pos
     * @return Current element
     */
    public E getValue(int pos) {
        assert hasElement() : "No current element";
        assert checkPosition(pos) : "Invalid Position: " + pos;
        return listArray[pos];
    }

    public int find(E k) {
        int pos = 0;
        while (pos < currSize) {
            if (k == listArray[pos]) {
                break;
            }
            pos++;
        }
        return pos; // pos == currSize if not found
    }

    // Extra stuff not printed in the book.
    /**
     * Generate a human-readable representation of this list's contents that
     * looks something like this: < 1 2 3 | 4 5 6 >. The vertical bar represents
     * the current location of the fence. This method uses toString() on the
     * individual elements.
     *
     * @return The string representation of this list
     */
    @Override
    public String toString() {
        // Save the current position of the list
        if (!hasElement()) {
            return "< | >";
        }
        
        int oldPos = currPos();
        StringBuilder out = new StringBuilder();

        moveToStart();
        out.append("< ");
        for (int i = 0; i < oldPos; i++) {
            out.append(getValue(i)).append(" ");
            next();
        }
        out.append("| ");
        for (int i = oldPos; i < length(); i++) {
            out.append(getValue(i)).append(" ");
            next();
        }
        out.append(">");
        moveToPos(oldPos); // Reset the fence to its original position
        return out.toString();
    }

    public E[] toArray() {
        return listArray;
    }

    @Override
    public E getValue() {
        return getValue(curr);
    }

}
