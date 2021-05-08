package pack;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class AlertController {

    private static final AtomicBoolean answer = new AtomicBoolean(false);

    public static boolean open(String a) {

        Stage stage = new Stage();

        Button btn1 = new Button();
        Button btn2 = new Button();

        btn1.setPrefSize(90, 30);
        btn2.setPrefSize(90, 30);


        Label label1 = new Label();
        Label label = new Label("Do you want to play again?");

        label1.getStyleClass().add("BigText");
        label.getStyleClass().add("SmallText");

        btn1.setText("Retry");
        btn2.setText("Close");

        if (a.equals("X") || a.equals("O")) {
            label1.setText("Player: " + a + " win");
        } else if (a.equals("draw")) {
            label1.setText("Draw");
        }

        stage.setOnCloseRequest(e -> {
            answer.set(false);
            stage.close();
        });

        btn2.setOnAction(e -> {
            answer.set(false);
            stage.close();
        });

        btn1.setOnAction(e -> {
            answer.set(true);
            stage.close();
        });

        VBox box = new VBox();
        VBox vbox = new VBox(label1, label);
        HBox hbox = new HBox(btn1, btn2);

        box.setPadding(new Insets(10));

        hbox.setSpacing(30);
        box.setSpacing(30);

        box.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.CENTER);

        box.getChildren().addAll(vbox, hbox);

        Scene scene = new Scene(box, 250, 150);

        stage.initModality(Modality.APPLICATION_MODAL);
        scene.getStylesheets().add(Objects.requireNonNull(AlertController.class.getResource("/css/alert_style.css")).toString());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.showAndWait();

        return answer.get();
    }
}
