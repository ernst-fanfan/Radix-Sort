// Name: Ernst Fanfan
// Class: CS 5040
// Term: Fall 2019
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: IntelliJ
import java.util.Scanner;
public class TestQueue_Ernst_Fanfan {
    public static void main (String [] args){
        //Declaration and Init
        boolean exit = false;//exit trigger
        Queue_Ernst_Fanfan queue = new Queue_Ernst_Fanfan();

        welcome();//welcome message

        //Interactive loop
        while (exit == false) {//exit loop
            menu();
            if (processChoice(queue) == 0)
                exit = true;//call exitProgram
        }
    }

    //process users choice
    public static int processChoice(Queue_Ernst_Fanfan passedQ){
        //Declaration and Init
        Scanner inputInt = new Scanner (System.in);
        Scanner inputE = new Scanner(System.in);
        int choice = -1;

        System.out.print("::\t");//cursor highlight
        choice = inputInt.nextInt();//scan input

        switch (choice){
            case 0:
                System.out.println("Goodbye!");
                break;
            case 1:
                System.out.print("\n\tEnqueue---->");
                passedQ.enqueue(inputE.nextInt());
                break;
            case 2:
                System.out.println("\n\tDequeueing...");
                passedQ.dequeue();
                break;
            case 3:
                System.out.println("\n\tThe front of the queue is " + passedQ.front()+".");
                break;
            case 4:
                System.out.println("\n\tThe queue has " + passedQ.size() + (passedQ.size() > 1 || passedQ.size() == 0? " elements":" element"));
                break;
            case 5:
                if (passedQ.isEmpty() == true)
                    System.out.println("\n\tQueue is empty.");
                else
                    System.out.println("\n\tQueue is not empty.");
                break;
            case 6:
                passedQ.printList();
                break;
        }
        return choice;
    }

    //menu
    public static void menu(){
        System.out.println();
        System.out.println("-----MAIN MENU-----");
        System.out.println("0 - Exit Program");
        System.out.println("1 - Enqueue");
        System.out.println("2 - Dequeue");
        System.out.println("3 - Front");
        System.out.println("4 - Size");
        System.out.println("5 – Is Empty?");
        System.out.println("6 - Print Queue");
    }

    //Welcome message
    public static void welcome(){
        System.out.println("**************");
        System.out.println("**Test Queue**");
        System.out.println("**************");
    }

}

