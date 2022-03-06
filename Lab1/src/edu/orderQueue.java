package edu;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class orderQueue {
    private Node first;    // Första noden
    private Node last;     // Sista noden
    private int n;         // Antal Noder

    // Nod klassen (linked list)
    private static class Node{
        private int numb;
        private Node next;
    }

    //klassens konstruktor
    public orderQueue() {
        first = null;
        last  = null;
        n = 0;
    }
    //metdod som tar bort en av noderna på platsen man väljer, 1 = first
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
        return size() == 0;
    }
    public int size() {
        return n;
    }
    public void enqueue(int numbr) {
        System.out.println(numbr);
        Node temp,next = new Node();
        Node rikt = new Node();
        rikt.numb = numbr;
        rikt.next = null;

        if (isEmpty()){
            first = rikt;
            last = first;
        }
        else if(numbr > last.numb){
            last.next = rikt;
            last = rikt;
        }
        else if(numbr < first.numb){
            rikt.next = first;
            first = rikt;
        }
        else {
            temp = first;
            while(temp.next != null){
                if(numbr < temp.next.numb){
                    next = temp.next;
                    temp.next = rikt;
                    rikt.next = next;
                    break;
                    }
                temp = temp.next;
                }
            }
        n++;
    }
    public int dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        int numbr = first.numb;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return numbr;
    }
    public String toString() {
        //Iterator iter = iterator();
        ListIterator iterat = new ListIterator();
        if(isEmpty()){return "Empty";}
        StringBuilder sb = new StringBuilder();
        while (iterat.hasNext()){
            int khar = (int) iterat.next();
            sb.append("["+khar+"],");
        }
        sb.append("["+iterat.next()+"]");
        return sb.toString();
    }

    public Iterator iterator() {

        return (Iterator) new ListIterator();
    }
    private class ListIterator {
        private Node current = first;
        public boolean hasNext() {
            return current != last;
        }
        public void remove() {
            throw new UnsupportedOperationException("sluta");
        }
        public int next(){
            int num =  current.numb;
            current   = current.next;
            return num;
        }
    }
}
