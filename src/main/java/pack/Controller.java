package pack;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pack.service.GameService;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Controller {

    @FXML
    public Pane buttonPane;
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
    TextArea statusTextArea;

    private final Image X = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/X.png")));
    private final Image O = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/O.png")));

    final GameCore core = new GameCore();

    Board board = new Board();

    private Player playerTurn = Player.O;

    public void zz() {
        buttonPressed(zz, 0, 0);
    }

    public void zo() {
        buttonPressed(zo, 0, 1);
    }

    public void zt() {
        buttonPressed(zt, 0, 2);
    }

    public void oz() {
        buttonPressed(oz, 1, 0);
    }

    public void oo() {
        buttonPressed(oo, 1, 1);
    }

    public void ot() {
        buttonPressed(ot, 1, 2);
    }

    public void tz() {
        buttonPressed(tz, 2, 0);
    }

    public void to() {
        buttonPressed(to, 2, 1);
    }

    public void tt() {
        buttonPressed(tt, 2, 2);
    }


    private void buttonPressed(Button button, int x, int y) {
        if (GameService.placeSymbolOnBoard(board, playerTurn, x, y)) {
            setSymbolOnButton(button);
            if (GameService.isSpecifiedPlayerWining(playerTurn, board)) {
                openDialogWindow(playerTurn);
            } else if (GameService.isDraw(board)) {
                openDialogWindow(null);
            } else {
                nextPlayer();
            }
        }
        // TODO: else flesh button red
    }

    private void setSymbolOnButton(Button button) {
        if (playerTurn == Player.O) {
            button.setGraphic(new ImageView(O));
        } else {
            button.setGraphic(new ImageView(X));
        }
    }

    private void nextPlayer() {
        playerTurn = (playerTurn == Player.O) ? Player.X : Player.O;
        statusTextArea.setText("Player: " + playerTurn.name());
    }

    private void retry() {
        List<Node> nodeOut = buttonPane.getChildren();
        for (Node node : nodeOut) {
            if(node instanceof Button){
                ((Button)node).setGraphic(new ImageView());
            }
        }
        board = new Board();
    }

    private void openDialogWindow(Player player) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Alert.fxml"));
        Scene scene;
        try {
            scene = new Scene(loader.load());

            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.initOwner(statusTextArea.getScene().getWindow());
            stage.setScene(scene);
            loader.<AlertController>getController().setAlertParams(player);
            stage.showAndWait();

            if (loader.<AlertController>getController().getResult()) {
                retry();
            } else {
                System.exit(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}


