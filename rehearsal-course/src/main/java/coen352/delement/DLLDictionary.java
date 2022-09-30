package coen352.delement;

import coen352.delement.DList;
import coen352.delement.DLink;
import coen352.dictionnary.ADTDictionary;

public class DLLDictionary<Key, E> implements ADTDictionary<Key, E> {

    private DList<Key> klist; //declaration of object named klist of type Key
    private DList<E> vlist; //declaration of object named vlist of type E

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        klist.clear();
        vlist.clear();
    }

    //constructor
    public DLLDictionary(int size) {
        klist = new DList<Key>(size);
        vlist = new DList<E>(size);
    }

    @Override
    public void insert(Key k, E e) {
        // TODO Auto-generated method stub
        klist.insert(k); //call insert function from DList
        vlist.insert(e); //call insert function from DList
    }

    @Override
    public E remove(Key k) {
        // TODO Auto-generated method stub
        klist.moveToStart(); //move the curr of klist to index 0
        vlist.moveToStart(); //move the curr of vlist to index 0
        int count = 0; // set a dummy variable to keep track of where curr is in klist, so then we can set curr for vlist to that exact corresponding position

        // while current position is not at tail.next(), which is null,(if curr points to null, meaning that we reach the end of klist) keep traversing through the loop
        while (klist.getCurr() != null) {
            //if the node after where curr is pointing to contain the element we need to find, do the following
            if (klist.getCurr().getElement() == k) {
                count = klist.currPos(); // set the value of count to the index of which curr is pointing at
                klist.remove(); //call the remove function from DList to remove the key

                //use that count to be the upper bound to find the value corresponding to k in vlist
                for (int i = 0; i < count; i++) {
                    vlist.next(); // keep traversing vlist till you get to the position corresponding to where curr is in klist

                }
                return (vlist.remove());// return the element that you are deleting (in vlist only) 
            }
            klist.next(); // if we cant find the element in klist, keep traversing till we find it, then this while loop will break
        }
        return null; // if k is not there, meaning that v is not there, return nothing cuz theres nothing to be found
    }

    @Override
    public E removeAny() {
        // TODO Auto-generated method stub

        DLink<Key> tail = klist.getCurr(); //create a 'tail' to where curr is at. I had to do this cuz her next() function in DList is this [if (curr != tail.getPrev()), then, curr = curr.next();], 
        //so in that sense, curr will never get to tail so if I want to remove the last element, I cant do it if using her next() function, so u see what I mean by her code is so clumsy 

        //if the length of the list is 0, then remove nada
        if (klist.length() == 0) {
            return null;
        }

        klist.moveToStart(); //move curr to index 0
        vlist.moveToStart(); //move curr to index 0 

        int count = 0; // declaration of a integer count
        count = (int) (Math.random() * (klist.length())); //set count to a random number smaller than size of the link list
        //this count will be the index to be removed.
        // so for exp, count = 3, then we r removing the element at index 3
        //now, if curr is one index before tail, do the following
        if (klist.getCurr() == tail.getPrev()) {
            //if count = index where tail is at (which is fked up because her function doesnt let this case to happen, I had to hard code it 
            if (count == (klist.currPos() + 1)) //since curr can only move to the position of 1 index before tail, we had to plus 1 there
            {
                klist.moveToEnd(); // move curr to the end of the list regardless where tail is for klist
                klist.remove(); // call the remove function 
                vlist.moveToEnd(); // move curr to the end of the list regardless where tail is for vlist
                return (vlist.remove()); // remove the value in vlist and return it 
            }
        } //if we are trying to remove anywhere but the tail, do the following 
        else {
            //traversing through the list till you get to a position of an index equal to count
            for (int i = 0; i < count; i++) {
                klist.next();
            }
            klist.remove(); // when get to the position, call the function remove and remove the key

            for (int j = 0; j < count; j++) {
                vlist.next();
            }
            return (vlist.remove()); // when get to the position, call the function remove to remove the value and return that value
        }
        return null;

    }

    @Override
    public E find(Key k) {
        // TODO Auto-generated method stub
        DLink<Key> tail = klist.curr;
        klist.moveToStart(); //move the curr to index 0 of klist
        vlist.moveToStart(); //move the curr to index 0 of klist

        while (klist.curr != null) // while current position is not at tail.next(), which is null,(if curr points to null, meaning that we reach the end of klist) keep traversing through the loop 
        {
            //if curr is pointing to a node that has the element we need to find, do the following
            if (klist.curr.getElement() == k) {
                int index = klist.currPos();//create an integer called index where it stores the index of the node that contains element k

                //use that index to be the upper bound to find the value corresponding to k in vlist
                for (int i = 0; i < index; i++) {
                    vlist.next(); // keep traversing vlist till you get to the mentioned corresponding element 
                }
                return vlist.getValue(); // return that value of vlist
            } //again here if curr = 1 index before tail
            else if (klist.curr == tail.getPrev()) {
                if (tail.getElement() == k) // if tail has the element 
                {
                    vlist.moveToEnd(); // move curr to the end of vlist regardless of where tail is 
                    return vlist.curr.next().getElement(); //return the element, which is at tail
                }
            }
            klist.next(); // if we cant find the element in klist, keep traversing till we find it, then this while loop will break
        }
        if (klist.curr != null && klist.curr == tail.getPrev()) // if the element that we are trying to find is not at tail but curr is one index before tail 
        {
            for (int i = 0; i < (klist.cnt) - 2; i++) //klist.cnt-2 gives the position of where curr at 
            {
                vlist.next();
            }
            return vlist.getValue();
        }
        return null; // if k is not there, meaning that v is not there, return nothing cuz theres nothing to be found
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return klist.length();
    }
}
