package pack;

public class Board {
    private PlaceStatus[][] board = {
            {PlaceStatus.FREE, PlaceStatus.FREE, PlaceStatus.FREE},
            {PlaceStatus.FREE, PlaceStatus.FREE, PlaceStatus.FREE},
            {PlaceStatus.FREE, PlaceStatus.FREE, PlaceStatus.FREE},
    };

    public PlaceStatus[][] getBoard() {
        return board;
    }

    public void setBoard(PlaceStatus[][] board) {
        this.board = board;
    }
}
