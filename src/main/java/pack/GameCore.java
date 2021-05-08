package pack;


public class GameCore {
    private int moveCount = 0;
    private final String[][] board = {
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "},
    };

    public boolean isEmpty(int x, int y) {
        boolean value = false;
        if (board[x][y].equals(" ")) {
            if (!win("X") || !win("O")) {
                value = true;
            }
        }
        return value;
    }

    public void play(int x, int y, String c) {
        board[x][y] = c;
        moveCount++;
    }

    private boolean checker(String b) {
        boolean value = false;
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(b) && board[1][i].equals(b) && board[2][i].equals(b) ||
                    board[i][0].equals(b) && board[i][1].equals(b) && board[i][2].equals(b)) {
                value = true;
                break;
            }
        }
        return value;
    }

    public boolean win(String a) {
        boolean value = false;
        if (checker(a)) {
            value = true;
        } else if (!board[1][1].equals("c")) {
            if (board[1][1].equals(a)) {
                String b = board[1][1];
                if (board[0][0].equals(b) && board[2][2].equals(b) || board[0][2].equals(b) && board[2][0].equals(b)) {
                    value = true;
                }
            }
        }
        return value;
    }

    public boolean draw() {
        return moveCount == 9;
    }

    public void clear() {
        moveCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int b = 0; b < 3; b++) {
                board[i][b] = " ";
            }
        }
    }
}

