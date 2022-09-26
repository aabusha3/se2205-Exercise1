/*
 * Author: Ahmad Sami Abu Shawarib
 * Student #: 251149713
 * Date:  Sept. 13, 2021
 * Description: filters a user-defined array for numbers divisible by 5 and finds the max, min and average of the filtered array
 * prints a header, then the max, min and average of the filtered array, then a footer
 */

package Q2L2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MinMaxAverage {

    public static double[] mma5Ahmad(int[] int1DArr) {
        ArrayList<Integer> numDivBy5 = new ArrayList<>();//The ArrayList helps avoid blank indexes when filtering for numbers divisible by 5

        //filters the array for numbers divisible by 5 and adds only those numbers to the ArrayList
        for (int int1DArrEle : int1DArr)
            if (int1DArrEle % 5 == 0)
                numDivBy5.add(int1DArrEle);

        //checks if there were any numbers divisible by 5
        if (!numDivBy5.isEmpty()) { //numbers divisible by 5 were found

            //re-initializes the passed array to convert the ArrayList of objects to an int array
            int1DArr = new int[numDivBy5.size()];
            for (int index = 0; index < numDivBy5.size(); index++)
                int1DArr[index] = numDivBy5.get(index);

            double[] answerArr = new double[4];//the array to be returned
            Arrays.fill(answerArr, int1DArr[0]);
            answerArr[3] = 251149713;//my student id


            //finds the max, min, and sums the indexes of the array.
            //int index starts at 1 to avoid ArrayIndexOutOfBounds error;
            // this requires the first index [0] to be added outside the loop (see above, line 35),
            // this also means if there's only 1 number in the filtered array, the loop is skipped (saves memory, idk)
            for (int index = 1; index < int1DArr.length; index++) {
                answerArr[0] = Math.max(answerArr[0], int1DArr[index]);
                answerArr[1] = Math.min(answerArr[1], int1DArr[index]);
                answerArr[2] += int1DArr[index];
            }


            answerArr[2] /= int1DArr.length; //the final calculation to find the average


            if (int1DArr.length == 1)//case for grammatical correct single case
                System.out.println("Ahmad Found " + numDivBy5.size() + " Number That Is Divisible By 5");
            else //case for grammatical correct plural case
                System.out.println("Ahmad Found " + numDivBy5.size() + " Numbers That Are Divisible By 5");

            return answerArr;
        } else { //no numbers divisible by 5 were found; prints result and returns a null array to avoid confusion
            System.out.println("Ahmad Found " + numDivBy5.size() + " Numbers That Are Divisible By 5");
            return new double[]{Double.NaN, Double.NaN, 0, 251149713};
        }
    }

    public static Scanner keyBoard = new Scanner(System.in);//the input method for the user

    public static int intTryCatch(String inputMessage) { //asks for and returns an integers; gives error message if non-integer is entered
        int _int;
        while (true) {//runs infinitely
            try {//tries for integers
                System.out.println(inputMessage);
                System.out.print(" >:\t");
                _int = keyBoard.nextInt();
                break;  //the only way out of the infinite loop
            } catch (InputMismatchException e) {//catches non-integers, gives a "what went wrong" message and loops
                System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                System.out.println("Please Only Enter In INTEGERS\n");
                keyBoard.next();
            }
        }
        return _int;
    }

    public static void main(String[] args) {
        myHeader(1, 2);
        System.out.println();

        //initializes array with user specified length
        int[] userInt1DArr = new int[intTryCatch("How Big Of An Array Do You Want")];
        System.out.println();

        //fills above array with user specified ints; with verification for ints only
        for (int index = 0; index < userInt1DArr.length; index++)
            userInt1DArr[index] = intTryCatch("Enter The Int For Index #" + index);


        System.out.println();
        double[] userDouble1DArr = mma5Ahmad(userInt1DArr);
        try {//tries to see if the returned array is null or not; this check occurs on line 86 when userDouble1DArr[0] is used
            System.out.printf("%nThe Biggest Number In That Array Is: %.0f"
                            + "%nThe Smallest Number In That Array Is: %.0f"
                            + "%nThe Average Of The Array Is: %.2f"
                            + "%nStudent I.D.: %.0f",
                    userDouble1DArr[0], userDouble1DArr[1], userDouble1DArr[2], userDouble1DArr[3]);
        } catch (NullPointerException e) {
            System.out.printf("%nThe Biggest Number In That Array Is: %.0f"
                            + "%nThe Smallest Number In That Array Is: %.0f"
                            + "%nThe Average Of The Array Is: %.2f"
                            + "%nStudent I.D.: %.0f",
                    userDouble1DArr[0], userDouble1DArr[1], userDouble1DArr[2], userDouble1DArr[3]);
        }

        myFooter();
    }

    //printHeader;  prints a header
    public static void myHeader(int labNum, int quesNum) {
        System.out.println();
        //general lab header
        for (int i = 0; i < 71; i++) System.out.print("*");    //adds 71 asterisks
        System.out.println("\n\t\t\tHello User, My Name Is Ahmad Sami Abu Shawarib\n\t\t\t\t\tStudent Number: 251149713" +
                "\n\t\t\t\t  Welcome To Lab #" + labNum + "\tQuestion #" + quesNum);
        for (int i = 0; i < 71; i++) System.out.print("*");  //adds 71 asterisks

        //specific lab header
        System.out.println("\n\tThis Code Filters An Int Array Of Your Choosing For The Number 5" +
                "\n Then Finds And Prints The Max, Min, And Average Of The Filtered Array");
        for (int i = 0; i < 71; i++) System.out.print("*");  //adds 71 asterisks
        System.out.println();
    }

    //printFooter;  prints a footer
    public static void myFooter() {
        System.out.printf("%n%n***********%7s~The Program Has Stopped, GoodBye!~%7s***********", "", "");//matches the length of the 71 asterisks printed in the printHeader method
    }
}
