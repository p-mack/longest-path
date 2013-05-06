package graph;
/*  Stackitem as a component of Stack class
    Data Structures with Java
    Copyright © David Cousins 2009
*/
public class Stackitem {
    int data;
    Stackitem next;
    public Stackitem(int value) {
        data = value;
        next = null;
    }
}
