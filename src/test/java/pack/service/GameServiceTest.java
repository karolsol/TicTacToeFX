package pack.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pack.Board;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    private Board board;

    @BeforeEach
    public void createBoard() {
        String[][] board = {
                {"X", " ", " "},
                {" ", " ", " "},
                {" ", " ", "X"},
        };
        this.board = new Board();
        this.board.setBoard(board);
    }

    @Test
    void shouldReturnFalseWhenPlaceIsTaken() {
        boolean result = GameService.placeSymbolOnBoard(this.board, "X", 0, 0);
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenPlayerSymbolIsWrong() {
        boolean result = GameService.placeSymbolOnBoard(this.board, "U", 0, 0);
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueWhenPlaceIsFree() {
        boolean result = GameService.placeSymbolOnBoard(this.board, "X", 1, 1);
        assertTrue(result);
    }
}