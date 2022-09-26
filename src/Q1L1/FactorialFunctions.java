/*
 * Author: Ahmad Sami Abu Shawarib
 * Student #: 251149713
 * Date:  Sept. 13, 2021
 * Description: finds the factorial recursively and iteratively, while timing each method's operations
 * prints a header, then the recursive factorial value & time, then the iterative factorial value & time, then a footer
 */

package Q1L1;

public class FactorialFunctions {
    //Iterative Factorial Method; adapted from Lecture Unit 1, slide #26
    public static double iterativeFactorialMethod(int factorialNumber) {
        double result = 1, index = 1;
        for (; index <= factorialNumber; index++) /*condition*/
            //block of code below vv
            result *= index;
        return result;
    }

    //Recursive Factorial Method; adapted from Lecture Unit 1, slide #27
    public static double recursiveFactorialMethod(int factorialNumber) {

        if (factorialNumber < 1)  //base case
            return 1;

        return factorialNumber * recursiveFactorialMethod(factorialNumber - 1);//Recursive call
    }

    public static void main(String[] args) {
        myHeader(1, 1);
        System.out.println();

        int factorialNumber = (int) (Math.random() * 170);//number to factorial; accurate max is 170, 171 returns infinity
        double factorialResult;//the factorial result from either recursive or iterative
        long startTime;//starts the stopwatch
        long elapsedRecursive;//finds the difference between the startTime and the end time for the Recursive method
        long elapsedIterative;//finds the difference between the startTime and the end time for the Iterative method
        //^^creating a stopwatch like method to calculate the time

        System.out.printf("Random Number To Factorial: %d", factorialNumber);

        startTime = System.nanoTime();//recursive start time
        factorialResult = recursiveFactorialMethod(factorialNumber);//recursive function
        elapsedRecursive = System.nanoTime() - startTime;//recursive stop time

        System.out.printf("%n%nRecursive Output: %.4e%nRecursive Time: %d ns", factorialResult, elapsedRecursive);

        startTime = System.nanoTime();//iterative start time
        factorialResult = iterativeFactorialMethod(factorialNumber);//iterative function
        elapsedIterative = System.nanoTime() - startTime;//iterative stop time

        System.out.printf("%n%nIterative Output: %.4e%nIterative Time: %d ns", factorialResult, elapsedIterative);

        System.out.printf("%n%nThe Time Difference Is: ");
        if (elapsedIterative == elapsedRecursive)
            System.out.print("0 ns, They're The Same Speed");
        else if (elapsedIterative < elapsedRecursive)
            System.out.printf("%d ns, Where Recursive Was Slower", elapsedRecursive - elapsedIterative);
        else
            System.out.printf("%d ns, Where Iterative Was Slower", elapsedIterative - elapsedRecursive);

        myFooter();
    }


    //printHeader;  prints a header
    public static void myHeader(int labNum, int quesNum) {
        System.out.println();
        //general lab header
        for (int i = 0; i < 55; i++) System.out.print("*");    //adds 55 asterisks
        System.out.println("\n\tHello User, My Name Is Ahmad Sami Abu Shawarib\n\t\t\tStudent Number: 251149713" +
                "\n\t\t  Welcome To Lab #" + labNum + "\tQuestion #" + quesNum);
        for (int i = 0; i < 55; i++) System.out.print("*");  //adds 55 asterisks

        //specific lab header
        System.out.println("\n\tThis Code Finds The Factorial Of A Number Using\n\t  A Recursive Method And An Iterative Method");
        for (int i = 0; i < 55; i++) System.out.print("*");  //adds 55 asterisks
        System.out.println();
    }

    //printFooter;  prints a footer
    public static void myFooter() {
        System.out.printf("%n%n***%7s~The Program Has Stopped, GoodBye!~%7s***", "", "");//matches the length of the 55 asterisks printed in the printHeader method
    }
}
