/*
* This program prints out
* the Magic Squares.
*
* @author  Haokai
* @version 1.0
* @since   2020-01-01
*/

/**
* This is the standard "Magic Squares" program.
*/
final class MagicNumber {
    /** The middle left index. */
    public static final int THREE = 3;
    /** The center index. */
    public static final int FOUR = 4;
    /** The middle right index. */
    public static final int FIVE = 5;
    /** The lower left index. */
    public static final int SIX = 6;
    /** The lower center index. */
    public static final int SEVEN = 7;
    /** The lower right index. */
    public static final int EIGHT = 8;
    /** The maximum number for magicNumbers. */
    public static final int NINE = 9;
    /** The maximum number for magicNumbers. */
    public static final int MAGICNUM = 15;

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private MagicNumber() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Function finds the index of a number, using Binary Search recursively.
    *
    * @param square number
    * @param currentSquare show
    * @param index loop number
    */
    public static void genSquare(final int[] square, final int[] currentSquare,
                                 final int index) {
        if (index > EIGHT) {
            int repectnumber = 0;
            final boolean check = isMagic(currentSquare);
            for (int fLoop = 0; fLoop < square.length; fLoop++) {
                for (int aLoop = fLoop + 1; aLoop < square.length; aLoop++) {
                    if (currentSquare[fLoop] == currentSquare[aLoop]) {
                        repectnumber = -1;
                    }
                }
            }
            if (check && repectnumber == 0) {
                printMagicSquare(currentSquare);
            }
        } else {
            for (int iLoop = 0; iLoop < square.length; iLoop++) {
                currentSquare[index] = square[iLoop];
                genSquare(square, currentSquare, index + 1);
            }
        }
    }

    /**
    * The starting main() function.
    *
    * @param preSquare check if equate 15
    *
    * @return isMagic
    */
    public static boolean isMagic(final int[] preSquare) {
        // returns true or false for whether or not array is a magic square
        final int row1 = preSquare[0] + preSquare[1] + preSquare[2];
        final int row2 = preSquare[THREE] + preSquare[FOUR] + preSquare[FIVE];
        final int row3 = preSquare[SIX] + preSquare[SEVEN] + preSquare[EIGHT];
        final int col1 = preSquare[0] + preSquare[THREE] + preSquare[SIX];
        final int col2 = preSquare[1] + preSquare[FOUR] + preSquare[SEVEN];
        final int col3 = preSquare[2] + preSquare[FIVE] + preSquare[EIGHT];
        final int diag1 = preSquare[0] + preSquare[FOUR] + preSquare[EIGHT];
        final int diag2 = preSquare[2] + preSquare[FOUR] + preSquare[SIX];

        return row1 == MAGICNUM && row2 == MAGICNUM && row3 == MAGICNUM
               && col1 == MAGICNUM && col2 == MAGICNUM
               && col3 == MAGICNUM && diag1 == MAGICNUM && diag2 == MAGICNUM;
    }

    /**
    * The function of show answer.
    *
    * @param outputSquare print
    */
    public static void printMagicSquare(final int[] outputSquare) {
        // prints inputted array in a magic square format
        System.out.println("\n*****");
        for (int count = 0; count < outputSquare.length; count++) {
            if (count == THREE || count == SIX) {
                System.out.println();
                System.out.print(outputSquare[count] + " ");
            } else {
                System.out.print(outputSquare[count] + "  ");
            }
        }
        System.out.println("\n***** ");
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        // main stub, get user input here
        final int[] magicSquare = {1, 2, THREE, FOUR,
                                   FIVE, SIX, SEVEN, EIGHT, NINE};
        final int[] extraArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println("\n");
        System.out.println("All Possible Magic Squares (3x3):\n");
        genSquare(magicSquare, extraArray, 0);
    }
}
