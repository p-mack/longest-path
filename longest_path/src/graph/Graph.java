package graph;
/*
 Graph class implemented using a 1-D array for vertices,
 2-D array to store edge information.
 Displays contents of both tables
 and traversal depth-first with a Stack
 and breadth-first using a Queue
 Permits searching for a path by depth-first algorithm
 Introducing Data Structures with Java
 David Cousins 2010 -
*/
public class Graph {
    static String[] Vertex = new String[7];
    static boolean[] visited = new boolean[7];
    static int[][] Edge = new int[7][7];
    static DLNode head = new DLNode(0);
    static DLNode end = new DLNode(0);
    Graph() {
        // set Vertex identifiers

        Vertex[0] = "Sleepytown";
        Vertex[1] = "Much Snoring";
        Vertex[2] = "Great Snoring";
        Vertex[3] = "Little Snoring";
        Vertex[4] = "Lesser Snoring";
        Vertex[5] = "Snoring on Sea";
        Vertex[6] = "Snoring on the Hill";

        for (int i = 0; i < 7; i++)
            visited[i] = false;

        // initialise edges to blank
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7; j++)
                Edge[i][j] = 0;

        // set edge value weightings in the table
        Edge[0][1] = 50;  // Sleepytown to Much Snoring
        Edge[1][0] = 50;  // Much Snoring to Sleepytown
        Edge[1][2] = 150; // Much Snoring to Great Snoring
        Edge[2][1] = 150; // Great Snoring to Much Snoring
        Edge[3][1] = 80;  // Little Snoring to Much Snoring
        Edge[2][3] = 180; // Great Snoring to Little Snoring
        Edge[2][6] = 150; // Great Snoring to Snoring on the Hill
        Edge[2][5] = 200; // Great Snoring to Snoring by Sea
        Edge[5][2] = 200; // Snoring on Sea to Great Snoring
        Edge[6][4] = 50;  // Snoring on the Hill to Lesser Snoring
        Edge[4][2] = 180; // Lesser Snoring to Great Snoring
    }
    // display format utility
    public void formatLine(String item){
        int spaces = 25 - item.length();
        for (int i = 0; i<spaces; i++)
            System.out.print(" ");;
     }

    // displays all graph data
    public  void displayall() {
         System.out.println("Displaying all vertices and contents of the adjacency table...");
         for (int i = 0; i < 7; i++) {
           System.out.print(i + " " + Vertex[i]);
           formatLine(Vertex[i]);
           for (int j = 0; j < 7; j++)
               System.out.print(Edge[i][j]+" ");
           System.out.println();
       }
      }

    // depth first traversal
    public void traverseDepthFirst(String startName) {
        int current, j, startindex = 0;
        boolean finished = false;
        Stack myStack = new Stack();
        System.out.println("Traversing the graph depth-first from start point "+startName);
        System.out.println(startName);
        for (int i = 0; i < 7; i++)
            visited[i] = false;
        while (Vertex[startindex] != startName)
            startindex++;
        current = startindex;
        visited[startindex] = true;
        do {
            for (int column = 0; column < 7; column++) {
                if (Edge[current][column] != 0 && !visited[column])
                    myStack.push(column);
            }
            j = myStack.pop();
            if (j == -1)
                finished = true;
            else {
                System.out.println(Vertex[j]);
                visited[j] = true;
                current = j;
            }
        } while (!finished);
    }


    // breadth-first traversal
    public void traverseBreadthFirst(String startName){
       int current, j, startindex = 0;
       boolean finished = false;
       Queue myQueue = new Queue();
       System.out.println("Traversing the graph breadth-first from start point "+startName);
       System.out.println(startName);
       for (int i = 0; i < 7; i++)
          visited[i] = false;
        while (Vertex[startindex] != startName)
           startindex++;
         current = startindex;
         visited[startindex] = true;
         do {
            for (int column = 0; column < 7; column++) {
                if (Edge[current][column] != 0 && !visited[column])
                    myQueue.enqueue(column);
               }
               j = myQueue.dequeue();
               if (j == -1)
                   finished = true;
               else {
                   System.out.println(Vertex[j]);
                   visited[j] = true;
                   current = j;
               }
           } while (!finished);
    }

    // used to find a path between two points
    // builds a double-linked list of all vertices visited
    // some of which may lead to a dead-end / cyclic path
    // so that back-tracking occurs to an earlier point
    // used by depth first search
    public static void buildPath(int index){
         DLNode current, previous, temp;
         temp = new DLNode(index);
         current = head;
         previous = head;
         while ((current.next!= null)) {
             previous = current;
             current = current.next;
         }
         end = temp;
         current.next = temp;
         temp.back = current;
     }

     // removes from list all points in a cyclic path
     // to leave the final path
     // used by depth first search function
     public static void editPath(int start ){
         DLNode current = end;
         DLNode previous = current.back;
         while (previous!=null && previous.value != start){
             while ( previous!=null && Edge[previous.value][current.value] != 0) {
                current = previous;
                previous = previous.back;
             }
             // backtrack to earlier vertex if cyclic path
             if (previous!=null && previous.value != start) {
                 while (previous != null && Edge[previous.value][current.value] == 0)
                     previous = previous.back;
                 if (previous != null) {
                     previous.next = current;
                     current.back = previous;
                 }
             }
         }
     }

     // writes out the route found
     // used by depth first search
     public static void writePath(int start) {
         DLNode current = head.next.next;
         DLNode previous = head.next;
         int distance = 0;
         while (current != null) {
            if (current.value!=start){
               System.out.println(Vertex[current.value]);
               distance = distance + Edge[previous.value][current.value];
             }
             previous = current;
             current = current.next;
           }
           System.out.println("Distance is " + distance);
      }

      // depth-first search for path between points
      public static void depthSearch(String startName, String endName ){
          int current, j, startindex = 0, endIndex = 0;
          boolean finished = false;
          Stack myStack = new Stack();
          System.out.println("Finding path from "+ startName + " to "+endName);
          for (int i = 0; i < 7; i++)
             visited[i] = false;
          while (Vertex[startindex].compareTo(startName)!=0)
              startindex++;
          while (Vertex[endIndex].compareTo(endName)!=0)
              endIndex++;
          current = startindex;
          myStack.push(current);
          buildPath(current);
          visited[startindex] = true;
          do {
             for (int column = 0; column < 7; column++) {
                if (Edge[current][column] != 0 && !visited[column])
                    myStack.push(column);
               }
              j = myStack.pop();
              if ((j == -1) || (j == endIndex))
                 finished = true;
              else {
                     buildPath(j);
                     visited[j] = true;
                     current = j;
                 }
          } while (!finished);
          if (j== -1)
                System.out.println("No path can be found");
           else{
               buildPath(j);
               // now remove reference to false turnings
               editPath(startindex);
               // write out the path
               System.out.println("Path is...");
               System.out.println(Vertex[startindex]);
               writePath(startindex);
               }
   }
}
