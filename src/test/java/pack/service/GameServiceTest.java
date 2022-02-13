package pack.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pack.Board;
import pack.PlaceStatus;
import pack.Player;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    private Board board;

    @BeforeEach
    public void createBoard() {
        PlaceStatus[][] board = {
                {PlaceStatus.X, PlaceStatus.FREE, PlaceStatus.FREE},
                {PlaceStatus.FREE, PlaceStatus.FREE, PlaceStatus.O},
                {PlaceStatus.FREE, PlaceStatus.FREE, PlaceStatus.X},
        };
        this.board = new Board();
        this.board.setBoard(board);
    }

    @Test
    void shouldReturnFalseWhenPlaceIsTaken() {
        boolean result = GameService.placeSymbolOnBoard(this.board, Player.X, 0, 0);
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueWhenPlaceIsFree() {
        boolean result = GameService.placeSymbolOnBoard(this.board, Player.X, 1, 1);
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenPlayerIsNotWining() {
        boolean result = GameService.isSpecifiedPlayerWining(Player.X, board);
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueWhenPlayerIsWiningByBevel() {
        GameService.placeSymbolOnBoard(board, Player.X, 1, 1);
        boolean result = GameService.isSpecifiedPlayerWining(Player.X, board);
        assertTrue(result);
    }
}
