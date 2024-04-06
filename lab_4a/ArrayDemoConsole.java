/*
 * ArrayDemoConsole.java
 */
package cs209.lab_04a;

import javax.swing.*;

public class ArrayDemoConsole {

    public static void main(String[] args) {

        final int LIMIT = 12;       // Max size of array
        int A[] = new int[LIMIT], B[] = new int[LIMIT];  // Array declaration and creation
        int countA = 0, countB = 0;         // Count the numbers entered into array A
        String numbStr, numbStr2;         // The number entered by user, as a string
        int numb, numb2;               // The number entered by user, as an int
        String promptAStr = "", promptBStr = ""; // String to prompt user for data entry
        String arrayAStr = "", arrayBStr = "";  // String comprised of array elements       
        String outputStr = "", outputStr2 = "";  // String to display output to user
        String outputFin = ""; // String to display final output to user

        // Populate Array A
        for (int i = 0; i < A.length; i++) {

            // Prompt and get number from user as a string
            promptAStr = "Array A elements: " + arrayAStr + "\n"
                    + "Enter integer #" + i + " to insert into array\n";

            numbStr = JOptionPane.showInputDialog(promptAStr);

            // Convert the number from type String to type int
            numb = Integer.parseInt(numbStr);

            // Insert the number into the next available position in array
            A[countA] = numb;

            // Increment the counter that keeps track of the number of entries
            countA++;

            // Create a string to display all numbers entered into the array so far
            arrayAStr = arrayToString(A, A.length); // call method to create string of array elements, assign to string
        } // end of for i

        // Display Array A
        outputStr = "\nThe number of elements in the array A is: " + A.length + "\n"
                + "The elements of array A: " + arrayToString(A, A.length) + "\n"
                + "Sum of the elements of array A: " + arraySum(A);
        System.out.println(outputStr);
        JOptionPane.showMessageDialog(null, outputStr, "Array A Data", JOptionPane.INFORMATION_MESSAGE);

        // Populate Array B
        for (int j = 0; j < B.length; j++) {

            // Prompt and get number from user as a string
            promptBStr = "Array B elements: " + arrayBStr + "\n"
                    + "Enter integer #" + j + " to insert into array\n";

            numbStr2 = JOptionPane.showInputDialog(promptBStr);

            // Convert the number from type String to type int
            numb2 = Integer.parseInt(numbStr2);

            // Insert the number into the next available position in array
            B[countB] = numb2;

            // Increment the counter that keeps track of the number of entries
            countB++;

            // Create a string to display all numbers entered into the array so far
            arrayBStr = arrayToString(B, B.length); // call method to create string of array elements, assign to string
        } // end of for j

        // Display Array B
        outputStr2 = "\nThe number of elements in the array B is: " + B.length + "\n"
                + "The elements of array B: " + arrayToString(B, B.length) + "\n"
                + "Sum of the elements of array B: " + arraySum(B);
        System.out.println(outputStr2);
        JOptionPane.showMessageDialog(null, outputStr2, "Array B Data", JOptionPane.INFORMATION_MESSAGE);

        // Sort arrays
        insertionSort(A); // sort array A
        insertionSort(B); // sort array B

        // Display both arrays
        outputFin = "\nThe number of elements in the array A is: " + A.length + "\n" 
                + "The elements of array A: " + arrayToString(A, A.length) + "\n"
                + "Sum of the elements of array A: " + arraySum(A);
        outputFin = outputFin + "\nThe number of elements in the Array B is: " + B.length + "\n"
                + "The elements of Array B: " + arrayToString(B, B.length) + "\n"
                + "Sum of the elements of Array B: " + arraySum(B);
        System.out.println(outputFin);
        JOptionPane.showMessageDialog(null, outputFin, "Array Data", JOptionPane.INFORMATION_MESSAGE);

    } // end of main class

    // Compute the sum of the elements in an array
    public static int arraySum(int Z[]) {
        int sum = 0;
        for (int i = 0; i < Z.length; i++) {
            sum += Z[i];
        }
        return sum;
    } // end of arraySum

    //method to return a string that lists the elements of the array as one line of text
    public static String arrayToString(int A[], int elements) {
        String arrayput = " "; // create string for output

        for (int i = 0; i < elements; i++) {
            arrayput = arrayput + String.valueOf(A[i]) + " "; // add value from array to string
        } // end of for

        return arrayput;
    } // end of arrayToString    

    public static void insertionSort(int arraytosort[]) {
        int temp, j; // temp int to hold values

        //compare and swap each element in the array to sort
        for (int i = 1; i < arraytosort.length; i++) {
            j = i;
            while (j > 0 && (arraytosort[j - 1] > arraytosort[j])) {
                temp = arraytosort[j - 1]; // save bigger value A in temp
                arraytosort[j - 1] = arraytosort[j]; // move smaller value up 
                arraytosort[j] = temp; // move bigger value (saved in temp) down
                j = j - 1; // move down in list
            } // end of while
        } // end of for i
    } // end of insertionSort

} // end of ArrayDemoConsole
