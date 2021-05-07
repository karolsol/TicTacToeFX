package pack;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

    private final Image X = new Image(getClass().getResourceAsStream("/images/X.png"));
    private final Image O = new Image(getClass().getResourceAsStream("/images/O.png"));
    private final Image T = new Image(getClass().getResourceAsStream("/images/transparent.png"));

    game game = new game();

    private String XO = "O";

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
        if (game.win(a)) {
            win(a);
        } else if (game.draw()) {
            win();
        } else {
            if (a.equals("X")) {
                XO = "O";
            } else if (a.equals("O")) {
                XO = "X";
            }
            txa1.setText("Player: " + XO);
        }
    }

    private void setImage(Button x, int i, int b) {
        if (game.isEmpty(i, b)) {
            switch (XO) {
                case "X" -> {
                    setX(x);
                    game.play(i, b, "X");
                    player("X");
                }
                case "O" -> {
                    setO(x);
                    game.play(i, b, "O");
                    player("O");
                }
            }
            setPadding(x);
        }
    }

    private void win(String a) {
        open(a);
    }

    private void win() {
        win("draw");
    }

    private void retry() {
        retry1(zz);
        retry1(zo);
        retry1(zt);
        retry1(oz);
        retry1(oo);
        retry1(ot);
        retry1(tz);
        retry1(to);
        retry1(tt);
        game.clear();
    }

    private void setClear(Button x) {
        x.setGraphic(new ImageView(T));
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

    private void retry1(Button x) {
        setClear(x);
        setPadding(x);
    }

    private void open(String a) {
        Stage stage = new Stage();

        Button btn1 = new Button();
        Button btn2 = new Button();

        btn1.setPrefSize(90, 30);
        btn2.setPrefSize(90, 30);


        Label label1 = new Label();
        Label label = new Label("Do you want to play again?");

        label1.getStyleClass().add("BigText");
        label1.getStyleClass().add("SmallText");

        btn1.setText("Retry");
        btn2.setText("Close");

        if (a.equals("X") || a.equals("O")) {
            label1.setText("Player: " + a + " win");
        } else if (a.equals("draw")) {
            label1.setText("Draw");
        }

        stage.setOnCloseRequest(e -> {
            stage.close();
            System.exit(0);
        });

        btn1.setOnAction(e -> {
            retry();
            stage.close();
        });

        btn2.setOnAction(e -> System.exit(0));


        VBox box = new VBox();
        VBox vbox = new VBox(label1, label);
        HBox hbox = new HBox(btn1, btn2);

        box.setPadding(new Insets(10));

        hbox.setSpacing(30);
        box.setSpacing(30);

        box.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.CENTER);

        box.getChildren().add(vbox);
        box.getChildren().add(hbox);

        Scene scene = new Scene(box, 250, 150);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.getIcons().add(T);
        scene.getStylesheets().add("/alert_style.css");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}


