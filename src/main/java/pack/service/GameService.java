package pack.service;

import pack.Board;

public class GameService {
    public static boolean placeSymbolOnBoard(Board board, String player, int x, int y) {
        if (player.equals("X") || player.equals("O")) {
            if (!isPlaceOnBoardTaken(board, x, y)) {
                String[][] changedBoard = board.getBoard();
                changedBoard[x][y] = player;
                board.setBoard(changedBoard);
                return true;
            }
        }
        return false;
    }

    private static boolean isPlaceOnBoardTaken(Board board, int x, int y) {
        return !board.getBoard()[x][y].equals(" ");
    }

    public static boolean isSpecifiedPlayerWining(String player, Board board) {
        String[][] boardArray = board.getBoard();
        for (int i = 0; i < 3; i++) {
            if (boardArray[0][i].equals(player) && boardArray[1][i].equals(player) && boardArray[2][i].equals(player) ||
                    boardArray[i][0].equals(player) && boardArray[i][1].equals(player) && boardArray[i][2].equals(player)) {
                return true;
            }
        }
        return boardArray[1][1].equals(player) && ((boardArray[0][0].equals(player) && boardArray[2][2].equals(player)) ||
                (boardArray[0][2].equals(player) && boardArray[2][0].equals(player)));
    }
}
