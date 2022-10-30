package pack.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pack.Player;
import pack.service.ConfigService;

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

    public void setAlertParams(Player a) {
        ConfigService configService = new ConfigService();
        if (configService.getTheme().equals("dark")) {
            vbox.getStylesheets().add(String.valueOf(getClass().getResource("/css/AlertStyle.css")));
        } else {
            vbox.getStylesheets().add(String.valueOf(getClass().getResource("/css/AlertStyleLight.css")));
        }

        label1.getStyleClass().add("BigText");
        label.getStyleClass().add("SmallText");

        if (a == Player.O || a == Player.X) {
            label1.setText("Player: " + a + " win");
        } else if (a == null) {
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
