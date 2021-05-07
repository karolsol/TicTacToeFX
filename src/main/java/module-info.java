module tictactoegui {
    requires javafx.controls;
    requires javafx.fxml;
    opens pack to javafx.fxml;
    exports pack;
}
