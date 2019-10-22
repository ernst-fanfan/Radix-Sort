// Name: Ernst Fanfan
// Class: CS 5040
// Term: Fall 2019
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: IntelliJ
public class Queue_Ernst_Fanfan<E> {
    public int size;
    public Node first, last;
    boolean empty = true;//initialize

    //constructor
    public Queue_Ernst_Fanfan(){
        size = 0;
        first = null;
        last = null;
    }

    //enqueue
    public void enqueue(E e){
        //init new node
        Node newNode = new Node(e);

        //if empty
        if (isEmpty() == true){
            first = newNode;
            last = newNode;
        }else{//if not empty add node to queue
            last.next = newNode;//last points to newNode
            last = newNode;//last set to newNode
        }
    }

    //dequeue
    public void dequeue(){
        //if empty
        if (isEmpty() == true)
            countNodes();
        else {
            Node current = first;//init current with first node
            first = first.next;//first points to next in queue
            current.next = null;//erase pointer for current
            countNodes();//count nodes
        }
    }

    //front of queue
    public E front(){
        return (E) first.data;
    }

    //size
    public int size (){
        countNodes();
        return size;
    }

    //count nodes
    public int countNodes(){
        //is empty?
        if (isEmpty() == true){
            size = 0;
        }else if (first == last){//is one node stack?
            size = 1;
        }else{//count nodes
            int listSize= 1;//set to one because the for loop does not run current == tails
            //complete this method
            for (Node current = first; current != last; current = current.next){//find indext
                listSize++;//increments the list buy 1
            }
            size = listSize;
        }
        return size;//returns size
    }

    //isEmpty
    public boolean isEmpty(){
        if (first==null)
            empty = true;
        else
            empty = false;
        return empty;
    }

    //print queue
    public void printList(){
        Node current;//declare current copy
        current = first;//set to head of stack
        if (countNodes() == 0)
            System.out.println("Queue is empty.");
        else {
            while (current != null) {
                System.out.print(current.data + "  ");//print node data
                current = current.next;//move to next node
            }
            System.out.println();
        }
    }

    //class to create nodes as objects
    private class Node<E>{
        private E data;  //data field
        private Node next; //link field

        //constructor method
        public Node(E item){
            data = item;
            next = null;
        }
    }
}
