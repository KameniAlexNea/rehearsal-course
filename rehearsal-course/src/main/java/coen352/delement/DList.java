package coen352.delement;

import coen352.list.ADTList;

/**
 * Source code example for "A Practical Introduction to Data Structures and
 * Algorithm Analysis, 3rd Edition (Java)" by Clifford A. Shaffer Copyright
 * 2008-2011 by Clifford A. Shaffer
 */
//Doubly linked list implementation : ens de DLINK
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
        cnt = 0;
    }

    @Override
    public void clear() {         // Remove all elements from list
        if (hasElement()) {
            // free memory
            cnt = 0;
            head = null;
            curr = null;
            tail = null;
        }
    }

    public boolean hasElement() {
        return length() > 0;
    }

    @Override
    public void moveToStart() // Set curr at list start
    {
        curr = head;
    }

    @Override
    public void moveToEnd() // Set curr at list end
    {
        curr = tail.getPrev();
    }

    /**
     * Insert "it" at current position
     *
     * @param it
     */
    @Override
    public void insert(E it) {
        if (!hasElement()) { // empty dlist
            DLink<E> newNode = new DLink<>(it, null, null);
            head = newNode;
            curr = head;
            tail = new DLink<>(head, null); // lorsque la mémoire est vide => last == head
            head.setNext(tail);
        } else {
            if (curr.getNext() == tail) { // at end of dict
                curr.setNext(new DLink<>(it, curr, tail));
                this.next();
                tail.setPrev(curr);
            } else {
                DLink<E> temp = curr;
                this.next();
                DLink<E> newNode = new DLink<>(it, temp, curr);
                temp.setNext(newNode);
                curr.setPrev(newNode);
                curr = newNode;
            }
        }
        cnt++;
    }

    /**
     * Append "it" to list
     * @param it
     */
    @Override
    public void append(E it) {
        DLink<E> newNode = new DLink<>(it, null, null);
        if (hasElement()) {
            newNode.setPrev(tail.getPrev());
            tail.getPrev().setNext(newNode);
            
            newNode.setNext(tail);
            tail.setPrev(newNode);
        } else {
            head = newNode;
            curr = newNode;
            tail = new DLink<>(head, null);
            newNode.setNext(tail);
        }
        cnt++;
    }

    /**
     * Remove and return current element
     */
    @Override
    public E remove() {
        if (!hasElement()) {
            return null;
        }
        if (this.length() == 1) { // Un seul element
            E temp = curr.getElement();
            this.clear();
            return temp;
        }

        E it = curr.getElement();

        if (curr == head) { // remove from the head
            this.next();
            head.setNext(null); // free link
            head = curr;
        } else if (curr.getNext() == tail) { // remove from the tail
            this.prev();
            tail.setPrev(null); // free link
            tail = curr;
        } else {
            DLink<E> temp = curr.getPrev(); // move temp behind current element
            temp.setNext(curr.getNext());
            curr.getNext().setPrev(temp);
            // free memory
            curr.setNext(null);
            curr.setPrev(null);
            curr = temp;
        }
        cnt--;			     // Decrement the count
        return it;                         // Return value removed
    }

    /**
     * Move curr one step left; no change if at front
     */
    @Override
    public void prev() {
        if (curr != head) // Can't back up from list head
        {
            curr = curr.getPrev();
        }
    }
    //Move curr one step right; no change if at end

    @Override
    public void next() {
        if (curr.getNext() != tail) {
            curr = curr.getNext();
        }
    }

    @Override
    public int length() {
        return cnt;
    }

    //Return the position of the current element
    @Override
    public int currPos() {
        DLink<E> temp = head;

        int i;
        for (i = 0; curr != temp; i++) {
            temp = temp.getNext();
        }
        return i;
    }
    
    public boolean checkPosition(int pos) {
        return (pos >= 0) && (pos < cnt);
    }

    //Move down list to "pos" position
    @Override
    public void moveToPos(int pos) {
        assert checkPosition(pos) : "Position out of range";
        curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.getNext();
        }
    }

    @Override
    public E getValue() {   // Return current element
        if (!hasElement()) { // empty dlist
            return null;
        }
        return curr.getElement();
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
        if (!hasElement()) {
            return "< | >";
        }
        // Save the current position of the list
        int oldPos = currPos();
        StringBuilder out = new StringBuilder();

        moveToStart();
        out.append("< ");
        for (int i = 0; i < oldPos; i++) {
            out.append(getValue()).append(" ");
            next();
        }
        out.append("| ");
        for (int i = oldPos; i < length(); i++) {
            out.append(getValue()).append(" ");
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
