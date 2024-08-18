/**Instituto Tecnológico de Costa Rica
 * Isaac Herrera Monge
 * Programación Orientada a Objetos
 * 2024 I Semestre
 */

import java.util.Scanner;
import java.util.*;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Boolean for loop purposes
        boolean count  = true;

        // This is the main loop similar to a game loop where it iterated the program
        while (count) {

            System.out.println("Please select the operation you want to perform" +
                    "\n (1) Input the matrix" +
                    "\n (2) Check for palindromes" +
                    "\n (3) Read Temps" +
                    "\n (4) Print Temps" +
                    "\n (5) Exit");

            int home = scanner.nextInt();

            switch (home){
                case 1:
                    // Requests the number or rows
                    System.out.println("Please provide the rows of the matrix ");
                    int row = scanner.nextInt();

                    // Requests the number or columns
                    System.out.println("Please provide the columns of the matrix ");
                    int column = scanner.nextInt();

                    // Here we declare the matrix by assigning it to the readMatrix function
                    int[][] matrix = readMatrix(row, column);

                    // operation value is used to check the while loop about the matrix
                    int operation = 0;

                    // Loop to request the operations to the user
                    while(operation !=4){

                        System.out.println("Please select the operation you want to perform" +
                                "\n (1) Print matrix" +
                                "\n (2) Check if the matrix is diagonal" +
                                "\n (3) Input the matrix values again" +
                                "\n (4) Return to the menu" +
                                "\n (5) Quit the program" );

                        operation = scanner.nextInt();

                        switch (operation){
                            case 1:
                                printMatrix(matrix);
                                break;
                            case 2:
                                System.out.println( checkDiag(matrix) );
                                break;
                            case 3:
                                matrix = readMatrix(row, column);
                                break;
                            case 4:
                                break;
                            case 5:
                                return;
                            default:
                                System.out.println("Operation not valid, please try again");
                        }
                    }

                    System.out.println("Do you want to continue? (y/n)");
                    if (scanner.next().equals("n"))
                        count = false;
                    break;

                case 2:
                    System.out.println("Please provide the number to check");
                    int number = scanner.nextInt();
                    System.out.println( isPalindrome(number) );
                    break;

                case 3:
                    System.out.println( readTemps( new ArrayList<Integer>() ) );
            }

        }

    }

    /**
     * This function requests the values of the matrix and adds them
     * @param row The natural number of rows in the matrix
     * @param column The natural number of columns in the
     * @return The matrix with all the values requested
     */
    public static int[][] readMatrix( int row, int column ) {

        int[][] matrix = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++){
                System.out.println("Please enter value for row:" + i + " , column:" + j);
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {

            System.out.print("[ ");

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.print(" ] \n");

        }
    }

    /**
     * Checks if the matrix is diagonal
     * @param matrix This is the matrix that we are going to check
     * @return A true or false depending on if the matrix is or not diagonal
     */
    public static boolean checkDiag(int[][] matrix) {

        if ( matrix.length != matrix[0].length )
            return false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i!=j && matrix[i][j] != 0)

                    return false;

            }
        }

        return true;

    }

    public static boolean isPalindrome(int number){

        StringBuilder listNumber = new StringBuilder(String.valueOf(number));

        if(listNumber.charAt(0)=='-')
            listNumber.deleteCharAt(0);

        for (int i = 0; i < (listNumber.length() / 2); i++) {
            if(listNumber.charAt(i)!=listNumber.charAt(listNumber.length()-i)){
                return false;
            }
        }

        return true;
    }

    public static List<Integer> readTemps ( List<Integer> tempList ) {

        int newTemp = 0;

        // Do while could be used here to improve efficiency as it makes fewer checks, but it looks ugly >.<
        while( newTemp != 999 ) {
            System.out.println("Please type the new value or enter 999 to finish");
            newTemp = scanner.nextInt();
        }

        return tempList;

    }

}