package graph;
/*
 Queue class methods for enqueue, dequeue, test for empty queue
 uses Queuenode class
 ' Data Structures with Java'
 Copyright © David Cousins 2009
*/

import java.io.*;

public class Queue {
    static Queuenode head, tail;
    public Queue() {
        head = null;
        tail = null;
    }

   public static void enqueue(int value)  {
       Queuenode temp = new Queuenode(value);
       if (head == null) {
            head = temp;
            tail = temp;
            }
       else {
              tail.next = temp;
              tail = temp;
                }
    }

    public static boolean isEmpty() {
        if (head == null)
            return true;
        else
            return false;
}
   public static int dequeue(){
      int value;
      if (isEmpty())
           return -1;
       else {
           value = head.data;
           head = head.next;
           return value;
       }
    }
   }

