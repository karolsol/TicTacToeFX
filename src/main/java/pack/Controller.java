package pack;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Controller {

    @FXML
    Button zz;
    @FXML
    Button zo;
    @FXML
    Button zt;
    @FXML
    Button oz;
    @FXML
    Button oo;
    @FXML
    Button ot;
    @FXML
    Button tz;
    @FXML
    Button to;
    @FXML
    Button tt;
    @FXML
    TextArea txa1;

    private final Image X = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/X.png")));
    private final Image O = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/O.png")));

    GameCore core = new GameCore();

    private String playerTurn = "O";

    public void zz() {
        setImage(zz, 0, 0);
    }

    public void zo() {
        setImage(zo, 0, 1);
    }

    public void zt() {
        setImage(zt, 0, 2);
    }

    public void oz() {
        setImage(oz, 1, 0);
    }

    public void oo() {
        setImage(oo, 1, 1);
    }

    public void ot() {
        setImage(ot, 1, 2);
    }

    public void tz() {
        setImage(tz, 2, 0);
    }

    public void to() {
        setImage(to, 2, 1);
    }

    public void tt() {
        setImage(tt, 2, 2);
    }

    private void player(String a) {
        if (core.win(a)) {
            win(a);
        } else if (core.draw()) {
            win();
        } else {
            if (a.equals("X")) {
                playerTurn = "O";
            } else if (a.equals("O")) {
                playerTurn = "X";
            }
            txa1.setText("Player: " + playerTurn);
        }
    }

    private void setImage(Button x, int i, int b) {
        if (core.isEmpty(i, b)) {
            switch (playerTurn) {
                case "X" -> setX(x);
                case "O" -> setO(x);
            }
            core.play(i, b, playerTurn);
            player(playerTurn);
            setPadding(x);
        }
    }

    private void win(String a) {
        openDialogWindow(a);
    }

    private void win() {
        win("draw");
    }

    private void retry() {
        clearContentOfButton(zz);
        clearContentOfButton(zo);
        clearContentOfButton(zt);
        clearContentOfButton(oz);
        clearContentOfButton(oo);
        clearContentOfButton(ot);
        clearContentOfButton(tz);
        clearContentOfButton(to);
        clearContentOfButton(tt);
        core.clear();
    }

    private void deleteImageFromButton(Button x) {
        x.setGraphic(new ImageView());
    }

    private void setX(Button x) {
        x.setGraphic(new ImageView(X));
    }

    private void setO(Button x) {
        x.setGraphic(new ImageView(O));
    }

    private void setPadding(Button b) {
        b.setPadding(new Insets(0, 0, 0, -2));
    }

    private void clearContentOfButton(Button x) {
        deleteImageFromButton(x);
        setPadding(x);
    }

    private void openDialogWindow(String a) {
        if (AlertController.open(a)) {
            retry();
        } else {
            System.exit(0);
        }
    }
}


