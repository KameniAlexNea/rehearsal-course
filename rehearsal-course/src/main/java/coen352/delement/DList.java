package coen352.delement;

import coen352.delement.DLink;
import coen352.list.ADTList;

/**
 * Source code example for "A Practical Introduction to Data Structures and
 * Algorithm Analysis, 3rd Edition (Java)" by Clifford A. Shaffer Copyright
 * 2008-2011 by Clifford A. Shaffer
 */
//Doubly linked list implementation
public class DList<E> implements ADTList<E> {

    private DLink<E> head;        // Pointer to list header
    private DLink<E> tail;        // Pointer to last element in list 
    protected DLink<E> curr;      // Pointer ahead of current element
    int cnt;		      // Size of list

    //Constructors
    public DList(int size) {
        this();
    }  // Ignore size

    public DList() {
        curr = head = new DLink<E>(null, null); // Create header node
        tail = new DLink<E>(head, null);
        head.setNext(tail);
        cnt = 0;
    }

    public void clear() {         // Remove all elements from list
        head.setNext(null);         // Drop access to rest of links
        curr = head = new DLink<E>(null, null); // Create header node
        tail = new DLink<E>(head, null);
        head.setNext(tail);
        cnt = 0;
    }

    public void moveToStart() // Set curr at list start
    {
        curr = head;
    }

    public void moveToEnd() // Set curr at list end
    {
        curr = tail.getPrev();
    }

    /**
     * Insert "it" at current position
     */
    public void insert(E it) {
        if (this.length() == 0) {
            DLink<E> newNode = new DLink<E>(it, null, null);
            head = newNode;
            curr = head;
            tail = curr.next();
        } else {
            if (curr.next() == null) {
                curr.setNext(new DLink<E>(it, curr, null));
                tail = curr.next();
                //tail.setPrev(curr);
                //this.next();
                curr = curr.next();
            } else {
                DLink<E> temp = curr;
                this.next();
                DLink<E> newNode = new DLink<E>(it, temp, curr);
                temp.setNext(newNode);
                curr.setPrev(newNode);
            }
        }
        //curr.setNext(new DLink<E>(it, curr, curr.next()));  
        //curr.next().next().setPrev(curr.next());
        cnt++;
    }

    /**
     * Append "it" to list
     */
    public void append(E it) {
        tail.setPrev(new DLink<E>(it, tail.getPrev(), tail));
        tail.getPrev().getPrev().setNext(tail.getPrev());
        cnt++;
    }

    /**
     * Remove and return current element
     */
    public E remove() {
        //if (curr.next() == tail) return null; // Nothing to remove
        //E it = curr.next().getElement();      // Remember value
        //curr.next().next().setPrev(curr);
        //curr.setNext(curr.next().next());  // Remove from list

        if (curr == null) {
            return null;
        }

        E it = curr.getElement();

        if (curr == head) {
            head = head.next();
            curr = head;
        } else {
            DLink<E> temp = head;
            while (temp.next() != curr) {
                temp = temp.next();
            }
            temp.setNext(curr.next());
            curr.next().setPrev(temp);
        }
        cnt--;			     // Decrement the count
        return it;                         // Return value removed
    }

    /**
     * Move curr one step left; no change if at front
     */
    public void prev() {
        if (curr != head) // Can't back up from list head
        {
            curr = curr.getPrev();
        }
    }
    //Move curr one step right; no change if at end

    public void next() {
        if (curr != tail.getPrev()) {
            curr = curr.next();
        }
    }

    public int length() {
        return cnt;
    }

    //Return the position of the current element
    public int currPos() {
        DLink<E> temp = head;

        int i;
        for (i = 0; curr != temp; i++) {
            temp = temp.next();
        }
        return i;
    }

    //Move down list to "pos" position
    public void moveToPos(int pos) {
        assert (pos >= 0) && (pos <= cnt) : "Position out of range";
        curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next();
        }
    }

    public E getValue() {   // Return current element
        if (curr.next() == tail) {
            return null;
        }
        return curr.next().getElement();
    }
    //Extra stuff not printed in the book.

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
        int oldPos = currPos();
        int length = length();
        StringBuilder out = new StringBuilder((length() + 1) * 4);

        moveToStart();
        out.append("< ");
        for (int i = 0; i < oldPos; i++) {
            out.append(getValue());
            out.append(" ");
            next();
        }
        out.append("| ");
        for (int i = oldPos; i < length; i++) {
            out.append(getValue());
            out.append(" ");
            next();
        }
        out.append(">");
        moveToPos(oldPos); // Reset the fence to its original position
        return out.toString();
    }

    public DLink<E> getCurr() {
        return curr;
    }
}
