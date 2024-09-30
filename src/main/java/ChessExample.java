import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChessExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter piece(King/Queen/Pawn)");
        String chessPiece = sc.nextLine();
        System.out.println("Enter initial position(A1-H8)");
        String initialPosition = sc.nextLine();
        int row = 8 - Character.getNumericValue(initialPosition.charAt(1));
        int column = initialPosition.charAt(0) - 'A';
        if (!checkPosition(row, column)) {
            throw new RuntimeException("Not a Valid Initial Position");
        }
        getPossibleMoves(chessPiece, row, column)
                .forEach(System.out::println);
    }

    static boolean checkPosition(int row, int column) {
        return row >= 0 && row < 8 && column >= 0 && column < 8;
    }

    static String getPosition(int row, int column) {
        return "" + (char) ('A' + column) + (8 - row);
    }

    static List<String> getPossibleMoves(String piece, int row, int column) {
        List<String> possibleMoves = new ArrayList<>();
        switch (piece.toUpperCase()) {
            case "PAWN":
                possibleMoves = getPawnMoves(row, column);
                break;
            case "KING":
                possibleMoves = getKingMoves(row, column);
                break;
            case "QUEEN":
                possibleMoves = getQueenMoves(row, column);
                break;
            default:
                System.out.println("Invalid piece type.");
        }
        return possibleMoves;
    }

    static List<String> getPawnMoves(int row, int column) {
        List<String> possibleMoves = new ArrayList<>();
        if (row > 0) {
            possibleMoves.add(getPosition(row - 1, column));
        }
        return possibleMoves;
    }

    static List<String> getKingMoves(int row, int column) {
        List<String> possibleMoves = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int rowToAdd = row + i;
                int columnToAdd = column + j;
                if (checkPosition(rowToAdd, columnToAdd)) {
                    possibleMoves.add(getPosition(rowToAdd, columnToAdd));
                }
            }
        }
        return possibleMoves;
    }

    static List<String> getQueenMoves(int row, int column) {
        List<String> possibleMoves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (i != column) {
                possibleMoves.add(getPosition(row, i));
            }
            if (i != row) {
                possibleMoves.add(getPosition(i, column));
            }
        }
        for (int i = 1; i < 8; i++) {
            if (checkPosition(row + i, column + i)) {
                possibleMoves.add(getPosition(row + i, column + i));
            }
            if (checkPosition(row - i, column + i)) {
                possibleMoves.add(getPosition(row - i, column + i));
            }
            if (checkPosition(row + i, column - i)) {
                possibleMoves.add(getPosition(row + i, column - i));
            }
            if (checkPosition(row - i, column - i)) {
                possibleMoves.add(getPosition(row - i, column - i));
            }
        }
        return possibleMoves;
    }
}
