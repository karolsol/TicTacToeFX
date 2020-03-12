package pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fx.fxml"));
        primaryStage.setTitle("Tic Tac Toe");
        Scene scene = new Scene(root, 300, 400);
        scene.getStylesheets().add(getClass().getResource("style.css").toString());
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("images/main.png")));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args){ launch(args); }
}
