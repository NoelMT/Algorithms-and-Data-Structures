package com.company;
import java.util.*;
import edu.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        String test = "";
        System.out.println("------------------------------------------------");
        System.out.println("välj labb!");
        System.out.println("1:Reverse recursive\t 2:Reverse Itarative \t3:Double Cirkular linked list queue\n4:Cirkular linked list queue \t5:Generelized Queue with remove \t6:Ordered Queue");
        System.out.println("------------------------------------------------");
            switch (scan.nextLine()){
                case "1":
                        recursive();
                    System.out.println("\n");
                    break;
                case "2":
                    itarative();
                    System.out.println("\n");
                    break;
                case "3":
                    DlcQue();
                    System.out.println("\n");
                    break;
                case "4":
                    Cll();
                    System.out.println("\n");
                    break;
                case "5":
                    Gqueue();
                    System.out.println("\n");
                    break;
                case "6":
                    orderQueue();
                    System.out.println("\n");
                    break;
        }
    }
    public static void recursive() {
        char f = StdIn.readChar();
        if (f != '\n') {
            recursive();
        }
        StdOut.print(f);
    }
//valde Stack med linked list implementering
    public static void itarative() {
        Stacken Stak = new Stacken();
        char c = StdIn.readChar();
        while (c != '\n'){
            Stak.push(c);
            c = StdIn.readChar();
        }
        while(!Stak.isEmpty()){
            StdOut.print(Stak.pop());
        }
    }
    //generic iterable FIFO-queue based on a double linked circular list
    public static void DlcQue(){
        DLCQueue<Character> ko = new DLCQueue<>();

        Scanner scan = new Scanner(System.in);
        String test = "";
        while(!test.equals("q")){
            System.out.println("1 = size : 2 = enqueue : 3 = dequeue: 4 = print : 5 = leave");
            switch (scan.next()){
                case "1":
                    System.out.println("The size is: "+ko.size());
                    break;
                case "2":
                    System.out.println("Enter Char:");
                    ko.enqueue(StdIn.readChar());
                    StdIn.readChar();
                    break;
                case "3":
                    ko.dequeue();
                    break;
                case "4":
                    System.out.println(ko.toString());
                    break;
                case "5":
                    test = "q";
                    break;
            }
        }
    }

    public static void Cll(){
    Cll<Character> ko = new Cll<>();
        Scanner scan = new Scanner(System.in);
        String test = "";
        while(!test.equals("q")) {
            System.out.println("1 = size : 2 = enqueue : 3 = enqueueFirst  : 4 = dequeue : 5 = dequeueLast : 6 = print : 7 = leave");
            switch (scan.next()) {
                case "1":
                    System.out.println("The size is: " + ko.size());
                    break;
                case "2":
                    System.out.println("Enter Char:");
                    ko.enqueue(StdIn.readChar());
                    StdIn.readChar();
                    break;
                case "3":
                    System.out.println("Enter Char:");
                    ko.enqueueFirst(StdIn.readChar());
                    StdIn.readChar();
                    break;
                case "4":
                    ko.dequeue();
                    break;
                case "5":
                    ko.dequeueLast();
                    break;
                case "6":
                    System.out.println(ko.toString());
                    break;
                case "7":
                    test = "q";
                    break;
            }
        }
    }
    public static void Gqueue() {
        Gqueue<Character> ko = new Gqueue<>();
        Scanner scan = new Scanner(System.in);
        String test = "";
        while (!test.equals("q")) {
            System.out.println("1 = size : 2 = enqueue : 3 = dequeue: 4 = remove:  5 = print : 6 = leave");
            switch (scan.next()) {
                case "1":
                    System.out.println("The size is: " + ko.size());
                    break;
                case "2":
                    System.out.println("Enter Char:");
                    ko.enqueue(StdIn.readChar());
                    StdIn.readChar();
                    break;
                case "3":
                    ko.dequeue();
                    break;
                case "4":
                    System.out.println("Vilken ska bort: ");
                    ko.remove(scan.nextInt());
                    break;
                case "5":
                    System.out.println(ko.toString());
                    break;
                case "6":
                    test = "q";
                    break;
            }
        }
    }
    public static void orderQueue() {
        orderQueue ko = new orderQueue();
        Scanner scan = new Scanner(System.in);
        String test = "";
        while (!test.equals("q")) {
            System.out.println("1 = size : 2 = enqueue : 3 = dequeue: 4 = remove:  5 = print : 6 = leave");
            switch (scan.next()) {
                case "1":
                    System.out.println("The size is: " + ko.size());
                    break;
                case "2":
                    System.out.println("Enter int:");
                    ko.enqueue(StdIn.readInt());
                    break;
                case "3":
                    ko.dequeue();
                    break;
                case "4":
                    System.out.println("Vilken ska bort: ");
                    ko.remove(scan.nextInt());
                    break;
                case "5":
                    System.out.println(ko.toString());
                    break;
                case "6":
                    test = "q";
                    break;
            }
        }
    }
}