package pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pack.service.ConfigService;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Root.fxml")));
        primaryStage.setTitle("Tic Tac Toe");
        Scene scene = new Scene(root, 300, 400);
        ConfigService configService = new ConfigService();
        if (configService.getTheme().equals("dark")) {
            scene.getStylesheets().add(String.valueOf(getClass().getResource("/css/RootStyle.css")));
        } else {
            scene.getStylesheets().add(String.valueOf(getClass().getResource("/css/RootStyleLight.css")));
        }
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/Icon.png"))));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
