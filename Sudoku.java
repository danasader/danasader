

  // Dana Sader

public class Sudoku {

    public static int GRID_SIZE = 9; // The length of the Sudoku board
    public static void main(String[] args) {

        // the "0" below in the Sudoku board represents the empty blocks

        /* the Sudoku board is unsolved and not valid if the numbers 1,2,4,5,6,7,8,9 are placed in the
          first empty block in the first row near the number 7
           */

        int[][] sudoku = {
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };

        printSudoku(sudoku); //this method will show the Sudoku board given above as output

        if (isValidSudokuSolution(sudoku)) {
            System.out.println("******** Solved successfully! ********");
        } else {
            System.out.println("******** Unsolvable Sudoku ********");
        }
        printSudoku(sudoku);//this method will show the solved Sudoku board as output
    }

    /*the output of the Sudoku board will be displayed with dotted lines after 3 rows
     and vertical lines after 3 columns
      */

    public static void printSudoku(int[][] sudoku) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------");
            }
            for (int column = 0; column < GRID_SIZE; column++) {
                if (column % 3 == 0 && column != 0) {
                    System.out.print("|");
                }
                System.out.print(sudoku[row][column]);
            }
            System.out.println();
        }
    }

    // check if a number already exists in a row
    public static boolean isNumberInRow(int[][] sudoku, int number, int row) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (sudoku[row][i] == number) {
                return true;	/*if a number already exists in a row then the method
                    will return true and if not then it will
                    return false
                    */
            }
        }
        return false;
    }

    // check if a number already exists in a column
    public static boolean isNumberInColumn(int[][] sudoku, int number, int column) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (sudoku[i][column] == number) {
                return true;
		/*if a number already exists in a column then the method
                    will return true and if not then it will
                    return false
                    */
            }
        }
        return false;
    }

    // check if a number already exists in the 3x3 square
    public static boolean isNumberInBox(int[][] sudoku, int number, int row, int column) {

        // BoxRow and BoxColumn define the position on the top left corner of any 3x3 square
        int BoxRow = row - row % 3;
        int BoxColumn = column - column % 3;

        //it iterates here through all the 3 rows of the 3x3 square
        for (int i = BoxRow; i < BoxRow + 3; i++) {

            //it iterates here through all the 3 columns of the 3x3 square
            for (int j = BoxColumn; j < BoxColumn + 3; j++) {

                /*if a number already exists in the 3x3 square then the method
                    will return true and if not then it will return false
                    */

                if (sudoku[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    /*this method calls the 3 Methods mentioned above and if they all return false
    then it will check if a number can be placed in the empty block, if a number can be added to the empty block
    then it is a valid placement.
     */

    /*if the method isValidPlacement is removed or deleted then the Sudoku cannot be solved and
       "******** Unsolvable Sudoku ********" will be given out as the output.
     */

    public static boolean isValidPlacement(int[][] sudoku, int number, int row, int column) {
        return !isNumberInRow(sudoku, number, row) &&
                !isNumberInColumn(sudoku, number, column) &&
                !isNumberInBox(sudoku, number, row, column);
    }

    /*
    this method checks if there is an empty block in the first row and if there was an empty block then
    the number 1 will be placed in the empty block , if it was not a valid placement(not a
    valid placement means that the same number is in the same row or same column or in 3x3 square and the number
    cannot be placed in the empty block)then eventually one number from the following numbers
    less than or equal to 9 will be placed in the empty block if it was a valid placement.
     */

    public static boolean isValidSudokuSolution(int[][] sudoku) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (sudoku[row][column] == 0) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isValidPlacement(sudoku, numberToTry, row, column)) {
                            sudoku[row][column] = numberToTry;

                            if (isValidSudokuSolution(sudoku)) {
                                return true;
                            } else {
                                sudoku[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}