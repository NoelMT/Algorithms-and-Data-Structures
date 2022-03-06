package edu;
//stacken tar emot chars som item istället för strings
public class Stacken {
    private Node first = null;
    private class Node {
        char item;
        Node next;
    }
    public boolean isEmpty() {
        if (first == null)
            return true;
        return false;
    }
    public void push(char item){
        Node oldfirst= first;
        first = new Node();
        first.item= item;
        first.next= oldfirst;
    }
    public char pop(){
        char item = first.item;
        first = first.next;
        return item;
    }
}
