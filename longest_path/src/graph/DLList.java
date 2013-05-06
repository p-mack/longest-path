package graph;

import java.io.*;
public class DLList {
    public static DLNode head, end;
    public DLList() {
        head = new DLNode(0);
        end = new DLNode(0);
    }

   public static void append(int index) {
        DLNode current, previous, temp;
        temp = new DLNode(index);
        current = head;
        previous = head;
        while ((current.next != null)) {
            previous = current;
            current = current.next;
        }
        end = temp;
        current.next = temp;
        temp.back = current;
    }





    public static void writeListinOrder() {
        DLNode current = head.next;
         while (current != null) {
                System.out.println(current.value);
                current = current.next;
            }
        }

    public static void writeListReversed() {
            DLNode current = end;
             while (current != null) {
                    System.out.println(current.value);
                    current = current.back;
                }
            }
    }

