package edu;

import java.util.*;

public class Gqueue <Item> implements Iterable<Item>  {

        private Node<Item> first;    // beginning of queue
        private Node<Item> last;     // end of queue
        private int n;               // number of elements on queue

        // linked list class
        private static class Node<Item> {
            private Item item;
            private Node<Item> next;
        }


        public Gqueue() {
            first = null;
            last  = null;
            n = 0;
        }

    public void remove(int kth){
        if(kth < 1 || kth > size()){
            System.out.println("index saknas");
        }
        else if (kth == 1){
            dequeue();
        }
        else {
            Node newnode1 = first;
            for (int i = size(); i > kth + 1; i--) {
                newnode1 = newnode1.next;
            }
            if (newnode1.next.next != null) {
                newnode1.next = newnode1.next.next;
            } else {
                newnode1.next = null;
            }
        }
        n--;
    }
        public boolean isEmpty() {
            return first == null;
        }
        public int size() {
            return n;
        }
        public void enqueue(Item item) {
            Node<Item> oldlast = last;
            last = new Node<Item>();
            last.item = item;
            last.next = null;
            if (isEmpty()) first = last;
            else           oldlast.next = last;
            n++;
        }
        public Item dequeue() {
            if (isEmpty()) throw new NoSuchElementException("Queue underflow");
            Item item = first.item;
            first = first.next;
            n--;
            if (isEmpty()) last = null;   // to avoid loitering
            return item;
        }
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
            Item item = (Item) current.item;
            current   = current.next;
            return item;
        }
    }
    }
