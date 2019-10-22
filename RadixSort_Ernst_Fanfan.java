// Name: Ernst Fanfan
// Class: CS 5040
// Term: Fall 2019
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: IntelliJ
import java.util.Scanner;
public class RadixSort_Ernst_Fanfan {
    public static void main (String [] args) {
        //Declaration and Init
        boolean exit = false;//exit trigger
        int arraySize = 0;//holds the size of the array

        while (exit == false) {//interactive loop
            //scan number of elements desired
            arraySize = stepOne();

            //create array based on number of desired elements
            int [] inputs =  new int [arraySize];

            //scan only positive numbers from user
            fillArray(inputs);

            //display array before radix sort
            displayArray(inputs);

            //process array with radix sort
            radixSort(inputs);

            //display array after radix sort
            displayArray(inputs);

            //call exitProgram
            exit = exitProgram();
        }
    }
    //Step 4: Radix Sort
    public static void radixSort(int[] array){
        //find highest number of digits and set to K
        int k = findK(array);
        //loop through radix process K times
        for (int count = 0; count < k; count++){
            ExtractDigit(array,count);
        }
    }

    //Step 4.2: Extract number
    public static void ExtractDigit(int[] array, int pos){
        //Step 4.2.1: init 0-9 queues
        Queue_Ernst_Fanfan Q0 = new Queue_Ernst_Fanfan();//Queue for 0's
        Queue_Ernst_Fanfan Q1 = new Queue_Ernst_Fanfan();//Queue for 1's
        Queue_Ernst_Fanfan Q2 = new Queue_Ernst_Fanfan();//Queue for 2's
        Queue_Ernst_Fanfan Q3 = new Queue_Ernst_Fanfan();//Queue for 3's
        Queue_Ernst_Fanfan Q4 = new Queue_Ernst_Fanfan();//Queue for 4's
        Queue_Ernst_Fanfan Q5 = new Queue_Ernst_Fanfan();//Queue for 5's
        Queue_Ernst_Fanfan Q6 = new Queue_Ernst_Fanfan();//Queue for 6's
        Queue_Ernst_Fanfan Q7 = new Queue_Ernst_Fanfan();//Queue for 7's
        Queue_Ernst_Fanfan Q8 = new Queue_Ernst_Fanfan();//Queue for 8's
        Queue_Ernst_Fanfan Q9 = new Queue_Ernst_Fanfan();//Queue for 9's
        //Step 4.2.2: extract numbers from array and load into queues
        for (int index = 0; index < array.length; index++){
            int qNum = (int) ((array[index]%(Math.pow(10,pos+1)))/(Math.pow(10,pos)));
            switch (qNum){
                case 0:
                    Q0.enqueue(array[index]);
                    break;
                case 1:
                    Q1.enqueue(array[index]);
                    break;
                case 2:
                    Q2.enqueue(array[index]);
                    break;
                case 3:
                    Q3.enqueue(array[index]);
                    break;
                case 4:
                    Q4.enqueue(array[index]);
                    break;
                case 5:
                    Q5.enqueue(array[index]);
                    break;
                case 6:
                    Q6.enqueue(array[index]);
                    break;
                case 7:
                    Q7.enqueue(array[index]);
                    break;
                case 8:
                    Q8.enqueue(array[index]);
                    break;
                case 9:
                    Q9.enqueue(array[index]);
                    break;
            }
        }
        //Step 4.2.3: reload array
        for (int index = 0; index < array.length; index++){
            if (Q0.isEmpty()==false) {
                array[index] = (int) Q0.front();
                Q0.dequeue();
            }else if (Q1.isEmpty()==false){
                array[index] = (int) Q1.front();
                Q1.dequeue();
            }else if (Q2.isEmpty()==false){
                array[index] = (int) Q2.front();
                Q2.dequeue();
            }else if (Q3.isEmpty()==false) {
                array[index] = (int) Q3.front();
                Q3.dequeue();
            }else if (Q4.isEmpty()==false) {
                array[index] = (int) Q4.front();
                Q4.dequeue();
            }else if (Q5.isEmpty()==false) {
                array[index] = (int) Q5.front();
                Q5.dequeue();
            }else if (Q6.isEmpty()==false) {
                array[index] = (int) Q6.front();
                Q6.dequeue();
            }else if (Q7.isEmpty()==false) {
                array[index] = (int) Q7.front();
                Q7.dequeue();
            }else if (Q8.isEmpty()==false) {
                array[index] = (int) Q8.front();
                Q8.dequeue();
            }else if (Q9.isEmpty()==false) {
                array[index] = (int) Q9.front();
                Q9.dequeue();
            }
        }
    }

    //Step 4.1: Find K
    public static int findK(int[] array){
        int k = 0;
        //loop through array
        for (int index = 0; index < array.length; index++) {
            int ex = 0;//init exponent
            //loop through numbers
            while (((int)(array[index]/(Math.pow(10,ex)))) != 0) {//check for remainder
                ex++;//update exponent
            }
            if (k < ex)//if exponent is bigger than k
                k = ex;//set k to exponent
        }
        return k;
    }

    //Step 3: display state of array before Radix
    public static void displayArray(int[] array){
        System.out.println();
        for (int value: array)
            System.out.print(value + "\t");
    }

    //Step 2: fill array
    public static void fillArray(int[] array){
        Scanner inputInt = new Scanner(System.in);//Scanner init
        for (int index = 0; index < array.length; index++){//fill loop
            System.out.print("\n\tEnter a positive integer for index " + index +":\t");//prompt
            array[index] = inputInt.nextInt();//Scan and set
        }
        System.out.println("Thank you!");
    }

    //Step one: collect array size
    public static int stepOne(){
        int answer = -1;
        Scanner inputInt = new Scanner(System.in);//scanner
        while (answer < 2) {
            System.out.print("\nPlease enter the number of elements you want to sort (2 or higher):\t");//prompt
            answer = inputInt.nextInt();//scan
            if (answer < 2)//data validator
                System.out.println("Must be 2 or higher.");
        }
        return answer;
    }

    //exit loop
    public static boolean exitProgram() {

        //Declaration and Init
        Scanner inputC = new Scanner(System.in);//Scanner
        char answer = 'a';//Answer char
        boolean exitP = false;//Passed boolean

        while (Character.toLowerCase(answer) != 'y' && Character.toLowerCase(answer) != 'n') {
            //user interaction***
            System.out.print("\nDo you want to re-run code with different inputs (Y/N)?:\t");//prompt
            answer = inputC.next().charAt(0);//Scan

            //logic control
            if (Character.toLowerCase(answer) != 'y' && Character.toLowerCase(answer) != 'n') {//if not no or yes
                System.out.println("Invalid input");
            } else if (Character.toLowerCase(answer) == 'n') {//if no
                System.out.println("\nGoodbye!");
                exitP = true;
            } else if (Character.toLowerCase(answer) == 'y')
                exitP = false;//if yes
        }

        return exitP;//return statement
    }
}
