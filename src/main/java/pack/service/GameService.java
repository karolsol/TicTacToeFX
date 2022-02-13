package pack.service;

import pack.Board;
import pack.PlaceStatus;
import pack.Player;

public class GameService {
    public static boolean placeSymbolOnBoard(Board board, Player player, int x, int y) {
        if (player == Player.X || player == Player.O) {
            if (!isPlaceOnBoardTaken(board, x, y)) {
                PlaceStatus[][] changedBoard = board.getBoard();
                changedBoard[x][y] = PlaceStatus.valueOf(player.name());
                board.setBoard(changedBoard);
                return true;
            }
        }
        return false;
    }

    private static boolean isPlaceOnBoardTaken(Board board, int x, int y) {
        return board.getBoard()[x][y] != PlaceStatus.FREE;
    }

    public static boolean isSpecifiedPlayerWining(Player player, Board board) {
        PlaceStatus[][] boardArray = board.getBoard();
        PlaceStatus status = PlaceStatus.valueOf(player.name());
        for (int i = 0; i < 3; i++) {
            if (boardArray[i][0] == status && boardArray[i][1] == status && boardArray[i][2] == status) return true;
            if (boardArray[0][i] == status && boardArray[1][i] == status && boardArray[2][i] == status) return true;
        }
        if (boardArray[1][1] == status){
            return (boardArray[0][0] == status && boardArray[2][2] == status)
                    || (boardArray[0][2] == status && boardArray[2][0] == status);
        }
        return false;
    }
}
