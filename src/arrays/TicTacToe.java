package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple tic tac toe game.
 * <p>Example usage:
 * TicTacToe game = new TicTacToe(TicTacToe.CellValue.X);
 * game.makeMove(1,1);
 * printBoard();
 * </p>
 */
public final class TicTacToe {
    private final List<List<CellValue>> board;
    private CellValue playersMark;

    private enum CellValue {
        X(1), O(-1), EMPTY(0);

        private int numericValue;

        CellValue(int numericValue) {
            this.numericValue = numericValue;
        }

        private int value() {
            return numericValue;
        }
    }

    public TicTacToe(CellValue firstPlayersMark) {
        if (firstPlayersMark.equals(CellValue.EMPTY)) {
            throw new IllegalArgumentException("FirstPlayersMark cannot be EMPTY!");
        }
        board = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<CellValue> row = new ArrayList<>();
            row.add(CellValue.EMPTY);
            row.add(CellValue.EMPTY);
            row.add(CellValue.EMPTY);
            board.add(row);
        }
        playersMark = firstPlayersMark;
    }

    public final void makeMove(int x, int y) {
        if ((x < 0) || (x > 2) || (y < 0) || (y > 2)) {
            System.out.println("Coordinates are out of board range!");
            return;
        }
        List<CellValue> xRow = board.get(x);
        if (xRow.get(y) != CellValue.EMPTY) {
            System.out.println(String.format("X:%s Y:%s is already taken!", x, y));
            return;
        }
        xRow.set(y, playersMark);

        if (hasWon()) {
            char winnerMark = playersMark.value() == -1 ? 'O' : 'X';
            System.out.println(String.format("Player with %c mark won!", winnerMark));
            return;
        }

        if (isBoardFull()) {
            System.out.println("Game has ended, board is full");
            System.exit(1);
        }
        changePlayer();
    }

    public final void printBoard() {
        StringBuilder result = new StringBuilder();
        for (List<CellValue> cellValues : board) {
            result.append("|");
            for (CellValue cellValue : cellValues) {
                switch (cellValue) {
                    case O:
                        result.append("O");
                        break;
                    case X:
                        result.append("X");
                        break;
                    case EMPTY:
                        result.append(" ");
                }
                result.append("|");
            }
            result.append("\n");
        }
        System.out.println(result);
    }

    private void changePlayer() {
        if (playersMark.equals(CellValue.X)) {
            playersMark = CellValue.O;
        } else {
            playersMark = CellValue.X;
        }
    }

    private boolean hasWon() {
        return ((board.get(0).get(0).value() + board.get(0).get(1).value() + board.get(0).get(2).value() == playersMark.value() * 3)
                || (board.get(1).get(0).value() + board.get(1).get(1).value() + board.get(1).get(2).value() == playersMark.value() * 3)
                || (board.get(2).get(0).value() + board.get(2).get(1).value() + board.get(2).get(2).value() == playersMark.value() * 3)
                || (board.get(0).get(0).value() + board.get(1).get(0).value() + board.get(2).get(0).value() == playersMark.value() * 3)
                || (board.get(0).get(0).value() + board.get(1).get(0).value() + board.get(2).get(0).value() == playersMark.value() * 3)
                || (board.get(0).get(1).value() + board.get(1).get(1).value() + board.get(2).get(1).value() == playersMark.value() * 3)
                || (board.get(0).get(2).value() + board.get(1).get(2).value() + board.get(2).get(2).value() == playersMark.value() * 3)
                || (board.get(0).get(0).value() + board.get(1).get(1).value() + board.get(2).get(2).value() == playersMark.value() * 3)
                || (board.get(2).get(0).value() + board.get(1).get(1).value() + board.get(0).get(2).value() == playersMark.value() * 3)
        );
    }

    private boolean isBoardFull() {
        for (List<CellValue> cellValues : board) {
            if (cellValues.contains(CellValue.EMPTY)) {
                return false;
            }
        }
        return true;
    }
}
