package coen352.dictionnary;

import coen352.list.AList;

/**
 * Source code example for "A Practical Introduction to Data Structures and
 * Algorithm Analysis, 3rd Edition (Java)" by Clifford A. Shaffer Copyright
 * 2008-2011 by Clifford A. Shaffer
 */

/**
 * Dictionary implemented by unsorted array-based list.
 */
public class ALDictionary<Key, E> implements ADTDictionary<Key, E> {

    private static final int defaultSize = 100; // Default size

    private AList<Key> klist;
    private AList<E> vlist;

    /**
     * Constructors
     */
    ALDictionary() {
        this(defaultSize);
    }

    ALDictionary(int sz) {
        klist = new AList<Key>(sz);
        vlist = new AList<E>(sz);
    }

    /**
     * Reinitialize
     */
    public void clear() {
        klist.clear();
        vlist.clear();
    }

    /**
     * Find k using sequential search
     *
     * @return Record with key value k
     */
    public E find(Key k) {

        int pos = klist.find(k);
        if (pos < klist.length() && pos >= 0) {
            return vlist.getValue(pos);
        }
        return null;
    }

    /**
     * Insert an element: append to list
     */
    @Override
    public void insert(Key k, E e) {
        if (find(k) == null) {
            klist.append(k);
            vlist.append(e);
        }

    }

    /**
     * Use sequential search to find the element to remove
     */
    @Override
    public E remove(Key k) {
        E temp = find(k);
        int origin = klist.currPos();
        if (temp != null) {
            int pos = klist.find(k);
            klist.moveToPos(pos);
            vlist.moveToPos(pos);
            klist.remove();
            vlist.remove();
        }
        klist.moveToPos(origin);
        vlist.moveToPos(origin);
        return temp;
    }

    /**
     * Remove the current element
     */
    @Override
    public E removeAny() {

        if (size() != 0) {
            klist.remove();
            E temp = vlist.getValue(0);
            vlist.remove();
            return temp;
        } else {
            return null;
        }
    }

    /**
     * @return List size
     */
    @Override
    public int size() {
        return klist.length();
    }

    public E[] toArray() {
        return vlist.toArray();
    }

    @Override
    public String toString() {
        int origin = klist.currPos();
        StringBuilder out = new StringBuilder();
        assert (vlist.length() == klist.length()) : "the dict is inconsistent";
        for (int i = 0; i < klist.length(); i++) {
            out.append(klist.getValue(i).toString());
            klist.next();
            out.append(":");
            out.append(vlist.getValue(i).toString());
            out.append(" , ");
            vlist.next();
        }

        klist.moveToPos(origin);
        vlist.moveToPos(origin);
        return out.toString().trim();

    }

    public int find(AList<Key> klist, Key k) {

        int orgCurr = klist.currPos();
        int pos = 0;
        for (; pos < klist.length(); pos++) {
            klist.moveToPos(pos);
            if (k == klist.getValue(pos)) {
                break;
            }

        }
        klist.moveToPos(orgCurr);
        return pos; // k not found
    }

    /**
     * public int[] createDesendingIndex() { index = new int [klist.length()];
     * // revise sorting algorithm to solve the right position of each record //
     * according to if it is a ascending or descending order. // the original
     * record order must be reserved without any swap.      *
     *
     * return index;      *
     *
     * }
     */
}
