package pack;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.concurrent.atomic.AtomicBoolean;

public class AlertController {

    private static final AtomicBoolean answer = new AtomicBoolean(false);

    @FXML
    Label label1;

    @FXML
    Label label;

    @FXML
    VBox vbox;

    @FXML
    Button btn1;

    @FXML
    Button btn2;

    public boolean getResult() {
        return answer.get();
    }

    public void setAlertParams(String a) {
        vbox.getStylesheets().add(String.valueOf(AlertController.class.getResource("/css/AlertStyle.css")));

        label1.getStyleClass().add("BigText");
        label.getStyleClass().add("SmallText");

        if (a.equals("X") || a.equals("O")) {
            label1.setText("Player: " + a + " win");
        } else if (a.equals("draw")) {
            label1.setText("Draw");
        }

        btn2.setOnAction(e -> {
            answer.set(false);
            label.getScene().getWindow().hide();
        });

        btn1.setOnAction(e -> {
            answer.set(true);
            label.getScene().getWindow().hide();
        });
    }
}
