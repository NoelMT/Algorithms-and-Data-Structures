package edu;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Cll<Item> implements Iterable<Item>{

    private Node first; // link to least recently added node
    private Node last; // link to most recently added node
    private int N; // number of items on the queue


    private class Node
    {
        Item item;
        Node next ;
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return N;
    }
    public void enqueue(Item item)
    {

        Node oldlast = last;
        last = new Node();
        last.item = item;

        if (isEmpty()) {
            first = last;
            last.next = first;
        }
        else{
            oldlast.next = last;
            last.next = first;
        }
        N++;
    }
    public void enqueueFirst(Item item)
    {

        Node oldfirst = first;
        first = new Node();
        first.item = item;
        if (isEmpty()) {
            first = last;
            last.next = first;
        }
        else{
            first.next = oldfirst;
            last.next = first;
        }
        N++;
    }
    public Item dequeue()
    {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        if(first !=last){
            last.next = first;
        }
        else if (first == last){
            first = null;
            last = null;
        }
        N--;
        return item;
    }
    public Item dequeueLast()
    { // Remove item from the beginning of the list.
        if (isEmpty()){
            throw new NoSuchElementException("sluta");
        }
        Item item = last.item;
        Node newlast = first;
        while(newlast.next != last){
            newlast = newlast.next;
        }
        if(first !=last){
            last.next = first;
        }
        last = newlast;
        last.next = first;
        N--;
        return item;
    }

    @Override
    public String toString() {
        Iterator<Item> iter = iterator();
        // ListIterator iterat = new ListIterator();
        if(isEmpty()){return "Empty";}
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
