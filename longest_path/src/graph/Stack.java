package graph;
/*
 Stack implemented using references (pointers)
 'Data Structures with Java'
 Copyright © David Cousins 2009
 */

import java.io.*;

public class Stack {
    static Stackitem stackTop;
    public Stack() {
        stackTop = new Stackitem(0);
    }

    public static boolean isEmpty() {
        if (stackTop.next == null)
            return true;
        else
            return false;
    }

    public static void push(int temp) {
        Stackitem newitem = new Stackitem(temp);
        newitem.next = stackTop;
        stackTop = newitem;
    }

    public static int pop() {
        int value;
        if (stackTop.next == null)
            return -1;
        else {
            value = stackTop.data;
            stackTop = stackTop.next;
            return value;
        }
    }
}




