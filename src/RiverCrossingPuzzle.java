/**
 * Created by paulrenner on 9/17/15.
 */

import java.util.Scanner;
public class RiverCrossingPuzzle {

    /**
     * Constants
     */
    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    /**
     * Which bank is the boat on, 0 for left, 1 for right
     */
    private int boatSide;

    /**
     * Number of actions taken
     */
    private int totalMoves;

    /**
     * Cannibals on the left side.
     */
    private int cannibalsLeft;

    /**
     * Cannibals on the right side.
     */
    private int cannibalsRight;

    /**
     * Missionaries on the left side.
     */
    private int missionariesLeft;

    /**
     * Missionaries on the right side.
     */
    private int missionariesRight;

    /**
     * Create a game in initial state.
     */
    public RiverCrossingPuzzle() {
        this.boatSide = LEFT;
        this.cannibalsLeft = 3;
        this.missionariesLeft = 3;
        this.cannibalsRight = 0;
        this.missionariesRight = 0;

        // this.reset(3,0,3,0,LEFT);

        // TODO
    }

    /**
     * Reset the game with the given parameters
     */
    public void reset(int cannibalsLeft, int cannibalsRight, int missionariesLeft, int missionariesRight,
                      int boatSide) {

        this.cannibalsLeft = cannibalsLeft;

        this.cannibalsRight = cannibalsRight;

        this.missionariesLeft = missionariesLeft;

        this.missionariesRight = missionariesRight;

        this.boatSide = boatSide;

        this.totalMoves = 0;
    }

    /**
     *
     * @return number of missionaries on the left (starting) bank
     */
    public int numMissionariesOnLeftBank() {
        return missionariesLeft;
    }

    /**
     *
     * @return number of missionaries on the right (ending) bank
     */
    public int numMissionariesOnRightBank() {
        return missionariesRight;
    }

    /**
     *
     * @return number of cannibals on the left (starting) bank
     */
    public int numCannibalsOnLeftBank() {
        return cannibalsLeft;
    }

    /**
     *
     * @return number of cannibals on the right (ending) bank
     */
    public int numCannibalsOnRightBank() {
        return cannibalsRight;
    }

    /**
     *
     * @return true if boat is on left (starting) bank
     */
    public boolean boatOnLeftBank() {
        return boatSide == LEFT;
    }

    /**
     *
     * @return true if boat is on right (ending) bank
     */
    public boolean boatOnRightBank() {
        return boatSide == RIGHT;
    }

    /**
     * check status of game
     *
     * @return -1 if puzzle failed, 0 if puzzle not yet solved, 1 if puzzle
     *         solved
     */
    public int status() {
        if (cannibalsLeft == 0 && missionariesLeft == 0)
            return 1;
        else if ((cannibalsLeft > missionariesLeft && missionariesLeft > 0) ||
                (cannibalsRight > missionariesRight && missionariesRight > 0))
            return -1;

        return 0;

    }

    /**
     * Generates a move string.
     *
     * @param1 The number of cannibals in the move.
     * @param2 The number of missionaries in the move.
     * @return The move string to be returned.
     */
    public String moveGenerator(int cannibals, int missionaries) {

        if (cannibals == 1 && missionaries == 1)
            return String.format("(3) 1 cannibal and 1 missionary cross");
        if (cannibals <= 2 && cannibals > 0 && missionaries == 0)
            return String.format("(%d) %d cannibal(s) cross", cannibals, cannibals);
        if (missionaries <= 2 && missionaries > 0 && cannibals == 0)
            return String.format("(%d) %d missionary(s) cross", 3 + missionaries, missionaries);

        return "Invalid Move";
    }

    /**
     * Print all the available moves to the users.
     */
    public void availableMoves() {
        if (this.boatSide == LEFT && this.cannibalsLeft >= 2 && this.missionariesLeft >= 2) {
            System.out.println(moveGenerator(1, 0));
            System.out.println(moveGenerator(2, 0));
            System.out.println(moveGenerator(1, 1));
            System.out.println(moveGenerator(0, 1));
            System.out.println(moveGenerator(0, 2));

        }

        else if (this.boatSide == LEFT && this.cannibalsLeft >= 2 && this.missionariesLeft >= 1) {
            System.out.println(moveGenerator(1, 0));
            System.out.println(moveGenerator(2, 0));
            System.out.println(moveGenerator(1, 1));
            System.out.println(moveGenerator(0, 1));

        }

        else if (this.boatSide == LEFT && this.cannibalsLeft >= 2 && this.missionariesLeft == 0) {
            System.out.println(moveGenerator(1, 0));
            System.out.println(moveGenerator(2, 0));
        }

        else if (this.boatSide == LEFT && this.cannibalsLeft >= 1 && this.missionariesLeft >= 2) {
            System.out.println(moveGenerator(1, 0));
            System.out.println(moveGenerator(1, 1));
            System.out.println(moveGenerator(0, 1));
            System.out.println(moveGenerator(0, 2));
        }

        else if (this.boatSide == LEFT && this.cannibalsLeft == 0 && this.missionariesLeft >= 2) {
            System.out.println(moveGenerator(0, 1));
            System.out.println(moveGenerator(0, 2));
        }

        else if (this.boatSide == LEFT && this.cannibalsLeft == 1 && this.missionariesLeft == 1) {
            System.out.println(moveGenerator(1, 1));
        }

        else if (this.boatSide == LEFT && this.cannibalsLeft == 1 && this.missionariesLeft == 0) {
            System.out.println(moveGenerator(1, 0));
        }

        else if (this.boatSide == LEFT && this.cannibalsLeft == 0 && this.missionariesLeft == 1) {
            System.out.println(moveGenerator(0, 1));
        }

        else if (this.boatSide == RIGHT && this.cannibalsRight >= 2 && this.missionariesRight >= 2) {
            System.out.println(moveGenerator(1, 0));
            System.out.println(moveGenerator(2, 0));
            System.out.println(moveGenerator(1, 1));
            System.out.println(moveGenerator(0, 1));
            System.out.println(moveGenerator(0, 2));

        }

        else if (this.boatSide == RIGHT && this.cannibalsRight >= 2 && this.missionariesRight >= 1) {
            System.out.println(moveGenerator(1, 0));
            System.out.println(moveGenerator(2, 0));
            System.out.println(moveGenerator(1, 1));
            System.out.println(moveGenerator(0, 1));

        }

        else if (this.boatSide == RIGHT && this.cannibalsRight >= 2 && this.missionariesRight == 0) {
            System.out.println(moveGenerator(1, 0));
            System.out.println(moveGenerator(2, 0));
        }

        else if (this.boatSide == RIGHT && this.cannibalsRight >= 1 && this.missionariesRight >= 2) {
            System.out.println(moveGenerator(1, 0));
            System.out.println(moveGenerator(1, 1));
            System.out.println(moveGenerator(0, 1));
            System.out.println(moveGenerator(0, 2));
        }

        else if (this.boatSide == RIGHT && this.cannibalsRight == 0 && this.missionariesRight >= 2) {
            System.out.println(moveGenerator(0, 1));
            System.out.println(moveGenerator(0, 2));
        }

        else if (this.boatSide == RIGHT && this.cannibalsRight == 1 && this.missionariesRight == 1) {
            System.out.println(moveGenerator(1, 1));
        }

        else if (this.boatSide == RIGHT && this.cannibalsRight == 1 && this.missionariesRight == 0) {
            System.out.println(moveGenerator(1, 0));
        }

        else if (this.boatSide == RIGHT && this.cannibalsRight == 0 && this.missionariesRight == 1) {
            System.out.println(moveGenerator(0, 1));
        }





        // TODO
    }

    /**
     * Move Cannibals from the side where is the boat to the other side.
     *
     * @param The number of cannibals to be moved.
     */
    public void moveCannibals(int count) {
        if (this.boatSide == LEFT) {
            this.cannibalsLeft = this.cannibalsLeft - count;
            this.cannibalsRight = this.cannibalsRight + count;
        }
        else  {
            this.cannibalsLeft = this.cannibalsLeft + count;
            this.cannibalsRight = this.cannibalsRight - count;

        }


        // TODO

    }

    /**
     * Move Missionaries from the side where is the boat to the other side.
     *
     * @param The number of missionaries to be moved.
     */
    public void moveMissionaries(int count) {
        if (this.boatSide == LEFT) {
            this.missionariesLeft = this.missionariesLeft - count;
            this.missionariesRight = this.missionariesRight + count;
        }
        else {
            this.missionariesLeft = this.missionariesLeft + count;
            this.missionariesRight = this.missionariesRight - count;
        }

        // TODO
    }

    /**
     * Check is the given move is valid in the current situation.
     */
    public boolean isValidMove(int move) {
        switch (move) {
            case 1:
                if (this.boatSide == LEFT)
                    return cannibalsLeft > 0;
                else
                    return cannibalsRight > 0;
            case 2:
                if (this.boatSide == LEFT)
                    return cannibalsLeft > 1;
                else
                    return cannibalsRight > 1;

            case 3:
                if (this.boatSide == LEFT) {
                    return cannibalsLeft > 0 && missionariesLeft > 0;
                } else {
                    return cannibalsRight > 0 && missionariesRight > 0;
                }
            case 4:
                if (this.boatSide == LEFT)
                    return missionariesLeft > 0;
                else
                    return missionariesRight > 0;
            case 5:
                if (this.boatSide == LEFT)
                    return missionariesLeft > 1;
                else
                    return missionariesRight > 1;
        }

        // TODO

        return false;
    }

    /**
     * Make the move that the user has requested.
     */
    public boolean makeMove(int move) {
        if (!this.isValidMove(move))
                return false;

        switch (move) {
            case 1:
                this.moveCannibals(1);
                break;
            case 2:
                this.moveCannibals(2);
                break;
            case 3:
                this.moveCannibals(1);
                this.moveMissionaries(1);
                break;
            case 4:
                this.moveMissionaries(1);
                break;
            case 5:
                this.moveMissionaries(2);
                break;
        }
        this.boatSide = 1 - this.boatSide;
        this.totalMoves++;
        return true;
    }

    /******************************************************************
     * Auxiliary functions used for display
     ******************************************************************/

    /**
     * Missionaries and Cannibal Strings for printing on left bank.
     */
    public String printLeftSide() {
        String result = "";
        int i = 0;
        for (i = 0; i < cannibalsLeft; i++)
            result = result + "C";

        while (i < 3) {
            result = result + " ";
            i++;
        }

        result = result + " ";

        for (i = 0; i < missionariesLeft; i++)
            result = result + "M";

        while (i < 3) {
            result = result + " ";
            i++;
        }
        return result;
    }

    /**
     * Missionaries and Cannibal Strings for printing on right bank.
     */
    public String printRightSide() {
        String result = "";
        int i = 0;
        for (i = 0; i < cannibalsRight; i++)
            result = result + "C";

        while (i < 3) {
            result = result + " ";
            i++;
        }

        result = result + " ";

        for (i = 0; i < missionariesRight; i++)
            result = result + "M";

        while (i < 3) {
            result = result + " ";
            i++;
        }
        return result;
    }

    /**
     * Prints the gameboard.
     */
    public void printBoard() {
        System.out.println("-----------------------------------------");
        System.out.println("          River Crossing Puzzle          ");
        System.out.println("-----------------------------------------");
        System.out.println();
        System.out.println("|Left Bank |                |Right Bank|");
        if (boatSide == LEFT) {
            System.out.print(" " + printLeftSide() + "  B");
            System.out.println("                 " + printRightSide());
        } else {
            System.out.print(" " + printLeftSide());
            System.out.println("                 " + printRightSide() + "  B");
        }
        System.out.println("Number of moves: " + totalMoves);
        System.out.println();
    }

    /**
     * Facilitates gameplay.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (status() == 0) {
            printBoard();
            System.out.println("Available Moves:");
            availableMoves();
            System.out.println("\nEnter a move:");
            int move = scanner.nextInt();
            makeMove(move);
        }

        printBoard();
        if (status() == -1) {
            System.out.println("Cannibals ate a missionary!");
        } else if (status() == 1) {
            System.out.println("You WIN!");
        }
    }

}




