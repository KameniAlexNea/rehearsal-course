package coen352.delement;

import coen352.dictionnary.ADTDictionary;

public class DLLDictionary<Key, E> implements ADTDictionary<Key, E> {

    private final DList<Key> klist; //declaration of object named klist of type Key
    private final DList<E> vlist; //declaration of object named vlist of type E

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        klist.clear();
        vlist.clear();
    }

    //constructor
    public DLLDictionary(int size) {
        klist = new DList<>(size);
        vlist = new DList<>(size);
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
        int pos = 0;
        int currPos = klist.currPos();
        klist.moveToStart(); //move the curr of klist to index 0
        vlist.moveToStart(); //move the curr of vlist to index 0
        
        while (pos < klist.length()) {
            if (klist.getCurr().getElement() == k) {
                klist.remove();
                vlist.moveToPos(pos);
                E result = vlist.remove();
                
                if (pos < currPos) { // we removed an element after currPos
                    currPos = Math.max(0, currPos-1);
                }
                vlist.moveToPos(currPos);
                klist.moveToPos(currPos);
                return result;
            }
            klist.next();
            pos++;
        }
        return null;
    }
    
    public boolean hasElement() {
        return this.klist.length() > 0;
    }

    @Override
    public E removeAny() {
        // TODO Auto-generated method stub
        //if the length of the list is 0, then remove nada
        if (! hasElement()) { // empty dictionnary
            return null;
        }

        int pos = klist.currPos(); //create a 'tail' to where curr is at. I had to do this cuz her next() function in DList is this [if (curr != tail.getPrev()), then, curr = curr.next();], 
        //so in that sense, curr will never get to tail so if I want to remove the last element, I cant do it if using her next() function, so u see what I mean by her code is so clumsy 
        
        int count = (int) (Math.random() * (klist.length())); //set count to a random number smaller than size of the link list
        
        klist.moveToPos(count);
        klist.remove();
        vlist.moveToPos(count);
        
        E result = vlist.remove();
        
        klist.moveToPos(Math.max(pos-1, 0));
        vlist.moveToPos(Math.max(pos-1, 0));
        
        return result;
    }

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

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return klist.length();
    }
}
