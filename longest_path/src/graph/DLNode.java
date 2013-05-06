package graph;
/*A node in a double-linked list,used to store a path between points in a
directed graph
copyright David Cousins 2009
*/
public class DLNode {
    int value;
    DLNode next;
    DLNode back;
    public DLNode(int data) {
    value = data;
    next = null;
    back = null;
    }
}
