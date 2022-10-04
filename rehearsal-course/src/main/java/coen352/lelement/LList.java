package coen352.lelement;

import coen352.list.ADTList;

/**
 * Linked list implementation
 *
 * @param <E>
 */
public class LList<E> implements ADTList<E> {

    private Link<E> head; // Pointer to list header

    private Link<E> tail; // Pointer to last element

    private Link<E> curr; // Access to current element

    private int size;

    private int cnt; // length of list

    public Link<E> getCurr() {
        return curr;
    }

    public LList() {
    }

    public LList(int size) {
        this.size = size;
    }

    /**
     * Remove all elements
     */
    @Override
    public void clear() {
        if (this.length() == 0) {
            return;
        }
        head.setNext(null); // Drop access to links
        curr = tail = head = null; // Create header
        cnt = 0;
    }

    /**
     * Insert "it" at current position
     *
     * @param it
     */
    @Override
    public void insert(E it) {
        Link<E> newNode = new Link<>(it, null);
        if (hasElement()) // if the list is not empty
        {
            if (!hasNext()) // insert at the end
            {
                curr.setNext(newNode); //set curr to point to a new node and that node is pointing to null
                tail = newNode; //set tail to be that new element
                this.next();
            } else {
                Link<E> temp = curr; //create a copy of pointer curr called temp and set that to the node where curr is pointing at
                this.next(); // move curr to the next node (but temp is not moved)
                newNode.setNext(curr);
                temp.setNext(newNode);//set temp to point to that new node
                curr = newNode;
            }

        } else {
            head = newNode; //set head to the new node
            curr = head; //set curr to head
            tail = curr; // set tail to be the next node of curr, which is null for this case
        }
        cnt++;
    }

    public boolean hasElement() {
        return this.length() > 0;
    }

    /**
     * Append "it" to list
     *
     * @param it
     */
    @Override
    public void append(E it) {
        Link<E> newNode = new Link<>(it, null); // create a node where its next element is null
        if (hasElement()) {
            tail.setNext(newNode);
            tail = newNode;
        } else { // empty list => initialization
            head = newNode; //set head to the new node
            curr = newNode; //set curr to head
            tail = newNode; // set tail to be the next node of curr, which is null for this case
        }
        cnt++;
    }

    /**
     * Remove and return current element
     */
    @Override
    public E remove() {
        if (!hasElement()) {
            return null; // Nothing to remove
        }
        E it = curr.getElement(); // Remember value
        
        if (length() == 1) {
            this.clear();
            return it;
        }

        if (curr == head) // if we want to remove the first element
        {
            head = head.getNext(); //set head to the next element
            curr.release(); // doesnt matter, just for the safety of memory leaks 
            curr = head; // set curr to head
        } else {
            Link<E> temp = head; //set temp = head 
            while (temp.getNext() != curr)// move temp to element bef head
            {
                temp = temp.getNext();
            }
            temp.setNext(curr.getNext()); // set temp to point to 1 index behind where curr is pointing at. this is the removal of the node where curr is at 
            curr.release(); // just for the safety sake of memory leak
            curr = temp; //move curr back to where temp is 
        }

        cnt--; // Decrement count
        return it; // Return value
    }

    /**
     * Set curr at list start
     */
    @Override
    public void moveToStart() {
        curr = head;
    }

    /**
     * Set curr at list end
     */
    @Override
    public void moveToEnd() {
        curr = tail;
    }

    /**
     * Move curr one step left; no change if now at front
     */
    @Override
    public void prev() {
        if (curr == head) {
            System.err.println("no more element behind");
            return; // No previous element => nothing to change
        }
        Link<E> temp = head;
        // March down list until we find the previous element
        while (temp.getNext() != curr) {
            temp = temp.getNext();
        }
        curr = temp;
    }

    /**
     * Move curr one step right; no change if now at end
     */
    @Override
    public void next() {
        if (hasNext()) {
            curr = curr.getNext();
        } else {
            System.err.println("no more element after");
        }
    }

    public boolean hasNext() {
        return curr.getNext() != null;
    }

    /**
     * @return List length
     */
    @Override
    public int length() {
        return cnt;
    }

    /**
     * @return The position of the current element
     */
    @Override
    public int currPos() {
        Link<E> temp = head;
        int i = 0;
        while (temp != curr) {
            temp = temp.getNext();
            i++;
        }
        return i;
    }
    
    public boolean checkPosition(int pos) {
        return (pos >= 0) && (pos < cnt);
    }

    /**
     * Move down list to "pos" position
     */
    @Override
    public void moveToPos(int pos) {
        assert checkPosition(pos) : "Position out of range : " + pos;
        curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.getNext();
        }
    }

    /**
     * @return Current element value
     */
    @Override
    public E getValue() {

        if (!hasElement()) { // no element
            return null;
        }
        return curr.getElement();
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

}
