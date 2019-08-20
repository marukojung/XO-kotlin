import java.util.Arrays
import java.util.InputMismatchException
import java.util.Scanner


fun main {
    internal var `in`: Scanner? = null
    internal var board: Array<String>? = null
    internal var turn: String? = null

    fun main(args: Array<String>) {
        `in` = Scanner(System.`in`)
        board = arrayOfNulls(9)
        turn = "X"
        var winner: String? = null
        populateEmptyBoard()

        System.out.println("Welcome to 2 Player Tic Tac Toe.")
        System.out.println("--------------------------------")
        printBoard()
        System.out.println("X's will play first. Enter a slot number to place X in:")

        while (winner == null) {
            val numInput: Int
            try {
                numInput = `in`!!.nextInt()
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Invalid input; re-enter slot number:")
                    continue
                }
            } catch (e: InputMismatchException) {
                System.out.println("Invalid input;++ re-enter slot number:")
                continue
            }

            if (board!![numInput - 1].equals(String.valueOf(numInput))) {
                board[numInput - 1] = turn
                if (turn!!.equals("X")) {
                    turn = "O"
                } else {
                    turn = "X"
                }
                printBoard()
                winner = checkWinner()
            } else {
                System.out.println("Slot already taken; re-enter slot number:")
                continue
            }
        }
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thanks for playing.")
        } else {
            System.out.println("Congratulations! $winner's have won! Thanks for playing.")
        }
    }

    internal fun checkWinner(): String? {
        for (a in 0..7) {
            var line: String? = null
            when (a) {
                0 -> line = board!![0].toInt() + board!![1].toInt() + board!![2].toInt()
                1 -> line = board!![3].toInt() + board!![4].toInt() + board!![5].toInt()
                2 -> line = board!![6].toInt() + board!![7].toInt() + board!![8].toInt()
                3 -> line = board!![0].toInt() + board!![3].toInt() + board!![6].toInt()
                4 -> line = board!![1].toInt() + board!![4].toInt() + board!![7].toInt()
                5 -> line = board!![2].toInt() + board!![5].toInt() + board!![8].toInt()
                6 -> line = board!![0].toInt() + board!![4].toInt() + board!![8].toInt()
                7 -> line = board!![2].toInt() + board!![4].toInt() + board!![6].toInt()
            }
            if (line!!.equals("XXX")) {
                return "X"
            } else if (line.equals("OOO")) {
                return "O"
            }
        }

        for (a in 0..8) {
            if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
                break
            } else if (a == 8) return "draw"
        }

        System.out.println("$turn's turn; enter a slot number to place $turn in:")
        return null
    }

    internal fun printBoard() {
        System.out.println("/---|---|---\\")
        System.out.println("| " + board!![0] + " | " + board!![1] + " | " + board!![2] + " |")
        System.out.println("|-----------|")
        System.out.println("| " + board!![3] + " | " + board!![4] + " | " + board!![5] + " |")
        System.out.println("|-----------|")
        System.out.println("| " + board!![6] + " | " + board!![7] + " | " + board!![8] + " |")
        System.out.println("/---|---|---\\")
    }

    internal fun populateEmptyBoard() {
        for (a in 0..8) {
            board[a] = String.valueOf(a + 1)
        }
    }
}
