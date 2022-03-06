package edu;

import java.util.*;
import java.util.NoSuchElementException;

public class DLCQueue<Item> implements Iterable<Item> {

        //klassen Första och sista nod
        private Node first;
        private Node last;
        private int N = 0; // Nod räknare


    private class Node
        { // inre nod klass
            Item item;
            Node next ;
            Node prev;
        }
        public boolean isEmpty() {
        return size() == 0;
        }
        public int size() {
        return N;
        }
        //lägger till Item sist i kön
        public void enqueue(Item item)
        {

            Node oldlast = last;
            last = new Node();
            last.item = item;

            if (isEmpty()) {
                first = last;
                last.next = first;
                last.prev = last;
            }
            else{
                oldlast.next = last;
                last.prev = oldlast;
                last.next = first;
                first.prev = last;
            }
            N++;
        }
        public Item dequeue()
        { // Tar bort en nod från början av kön
            if (isEmpty()){
                    throw new NoSuchElementException();
            }
            Item item = first.item;
            first = first.next;
            if(first !=last){
            last.next = first;
            first.prev = last;
            }
            N--;
            return item;
        }
    @Override
    public String toString() {
        Iterator<Item> iter = iterator();
        if(isEmpty()){
            return "Empty";
        }
        StringBuilder sb = new StringBuilder();
        while (iter.hasNext()){
            Item khar =  iter.next();

            sb.append("["+khar+"],");
    }
        sb.append("["+iter.next()+"]");
        return sb.toString();
    }
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    //iteratorn
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext() {
            return current != last;
        }
            public void remove() {
            throw new UnsupportedOperationException("sluta");
        }
            public Item next(){
                Item item = current.item;
                current   = current.next;
                return item;
            }
    }
}
