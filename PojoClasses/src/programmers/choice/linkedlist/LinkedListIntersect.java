package programmers.choice.linkedlist;

import java.util.HashSet;

class LinkedListIntersect { 
    public static void main(String[] args) 
    { 
        // list 1 
        Node n1 = new Node(1); 
        n1.next = new Node(2); 
        n1.next.next = new Node(3); 
        n1.next.next.next = new Node(4); 
        n1.next.next.next.next = new Node(5); 
        n1.next.next.next.next.next = new Node(6); 
        n1.next.next.next.next.next.next = new Node(7); 
        // list 2 
        Node n2 = new Node(10); 
        n2.next = new Node(9); 
        n2.next.next = new Node(8); 
        n2.next.next.next = n1.next.next.next; 
        Print(n1); 
        Print(n2); 
        System.out.println(MegeNode(n1, n2).data); 
    } 
  
    // function to print the list 
    public static void Print(Node n) 
    { 
        Node cur = n; 
        while (cur != null) { 
            System.out.print(cur.data + "  "); 
            cur = cur.next; 
        } 
        System.out.println(); 
    } 
  
    // function to find the intersection of two node 
    public static Node MegeNode(Node n1, Node n2) 
    { 
        // define hashset 
        HashSet<Node> hs = new HashSet<Node>(); 
        while (n1 != null) { 
            hs.add(n1); 
            n1 = n1.next; 
        } 
        while (n2 != null) { 
            if (hs.contains(n2)) { 
                return n2; 
            } 
            n2 = n2.next; 
        } 
        return null; 
    } 
}