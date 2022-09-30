package coen352.delement;

/**
 * Doubly linked list node
 */
public class DLink<E> {

    private E element; // Value for this node

    private DLink<E> next; // Pointer to next node in list

    private DLink<E> prev; // Pointer to previous node

    /**
     * Constructors
     */
    DLink(E it, DLink<E> p, DLink<E> n) {
        element = it;
        prev = p;
        next = n;
    }

    DLink(DLink<E> p, DLink<E> n) {
        prev = p;
        next = n;
    }

    /**
     * Get and set methods for the data members
     */
    DLink<E> next() {
        return next;
    }

    DLink<E> setNext(DLink<E> nextval) {
        return next = nextval;
    }

    public DLink<E> getPrev() {
        return prev;
    }

    DLink<E> setPrev(DLink<E> prevval) {
        return prev = prevval;
    }

    public E getElement() {
        return element;
    }

    public E setElement(E it) {
        return element = it;
    }
}
