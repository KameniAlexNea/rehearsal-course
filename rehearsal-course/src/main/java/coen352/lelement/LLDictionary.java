package coen352.lelement;

import coen352.dictionnary.ADTDictionary;
import java.util.Objects;

public class LLDictionary<Key, E> implements ADTDictionary<Key, E> {

    //declaration of objects key and value
    private final LList<Key> klist;
    private final LList<E> vlist;

    //set size (constructor) of the two objects, they should have the same size
    public LLDictionary(int size) {
        klist = new LList<>(size);
        vlist = new LList<>(size);
    }

    // clear the klist and vlist
    @Override
    public void clear() {
        // TODO Auto-generated method stub
        klist.clear();
        vlist.clear();
    }

    //insert function 
    @Override
    public void insert(Key k, E e) {
        // TODO Auto-generated method stub
        klist.insert(k); // call insert function from  LList
        vlist.insert(e); // call insert function from  LList

    }

    //remove function 
    @Override
    public E remove(Key k) {
        // TODO Auto-generated method stub
        klist.moveToStart(); //move the curr of klist to index 0
        vlist.moveToStart(); //move the curr of vlist to index 0
        int count; // set a dummy variable to keep track of where curr is in klist, so then we can set curr for vlist to that exact corresponding position

        // while current position is not at tail.next(), which is null,(if curr points to null, meaning that we reach the end of klist) keep traversing through the loop 
        while (klist.getCurr().getNext() != null) {
            //if the node after where curr is pointing to contain the element we need to find, do the following
            if (klist.getCurr().getElement() == k) {
                count = klist.currPos(); // set the value of count to the index of which curr is pointing at
                klist.remove(); // call the remove function 

                //use that count to be the upper bound to find the value corresponding to k in vlist
                for (int i = 0; i < count; i++) {
                    vlist.next(); // keep traversing vlist till you get to the position corssponding to where curr is in klist
                }

                return (vlist.remove()); // return the element that you are deleting (in vlist only) 
            }
            klist.next();// if we cant find the element in klist, keep traversing till we find it, then this while loop will break 
        }
        return null;// if k is not there, meaning that v is not there, return nothing cuz theres nothing to be found 
    }

    @Override
    public E removeAny() {
        
        if (klist.length() == 0) {
            return null;
        }
        klist.moveToStart(); //move the curr of klist to index 0
        vlist.moveToStart();
        int count = (int) (Math.random() * (klist.length())); //set count to a random number smaller than size of the link list

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

    //find function 
    @Override
    public E find(Key k) {
        // TODO Auto-generated method stub
        int pos = 0;
        int currPos = klist.currPos();
        klist.moveToStart(); //move the curr of klist to index 0
        vlist.moveToStart(); //move the curr of vlist to index 0
        
        while (pos < this.size()) {
            if (klist.getCurr().getElement() == k) { // element found
                vlist.moveToPos(pos);
                E result = vlist.getValue();
                
                // then position
                vlist.moveToPos(currPos);
                klist.moveToPos(currPos);
                
                return result;
            }
            klist.next();
            pos++;
        }
        return null; // if k is not there, meaning that v is not there, return nothing cuz theres nothing to be found
    }
    
    public String toString() {
        return "Keys: " + klist + " : Values: " + vlist;
    }

    @Override
    //return size of klist. Here the time complexity is O(1) cuz it just returns the lenght of the list
    public int size() {
        // TODO Auto-generated method stub
        return klist.length();
    }
}
