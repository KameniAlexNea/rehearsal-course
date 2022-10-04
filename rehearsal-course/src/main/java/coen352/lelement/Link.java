package coen352.lelement;

/**
 * Singly linked list node
 *
 * @param <E>
 */
public class Link<E> {

    private E element; // Value for this node

    private Link<E> next; // Pointer to next node in list

    // Constructors
    public Link(E it, Link<E> nextval) {
        element = it;
        next = nextval;
    }

    public Link(Link<E> nextval) {
        next = nextval;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    //get /set values and link to the next node; 
    public Link<E> getNext() {
        return next;
    } // Return next field

    public Link<E> setNext(Link<E> nextval) // Set next field
    {
        return next = nextval;
    } // Return element field

    public E getElement() {
        return element;
    } // Set element field

    public E setElement(E it) {
        return element = it;
    }
    
    public void release() {
        if (this.hasNext())
            this.next = null;
    }

}
