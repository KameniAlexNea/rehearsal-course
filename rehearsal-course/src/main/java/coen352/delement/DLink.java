package coen352.delement;

/**
 * Doubly linked list node
 * @param <E>
 */
public class DLink<E> {

    private E element; // Value for this node

    private DLink<E> next; // Pointer to next node in list

    private DLink<E> prev; // Pointer to previous node

    /**
     * Constructors
     * @param it
     * @param p
     * @param n
     */
    public DLink(E it, DLink<E> p, DLink<E> n) {
        element = it;
        prev = p;
        next = n;
    }

    public DLink(DLink<E> p, DLink<E> n) {
        this(null, p, n);
    }

    /**
     * Get and set methods for the data members
     * @return 
     */
    public DLink<E> getNext() {
        return next;
    }

    public DLink<E> setNext(DLink<E> nextval) {
        return next = nextval;
    }

    public DLink<E> getPrev() {
        return prev;
    }

    public DLink<E> setPrev(DLink<E> prevval) {
        return prev = prevval;
    }

    public E getElement() {
        return element;
    }

    public E setElement(E it) {
        return element = it;
    }
}
