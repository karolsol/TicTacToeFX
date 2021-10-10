module tictactoegui {
    requires javafx.controls;
    requires javafx.fxml;
    opens pack to javafx.fxml;
    opens pack.service;
    exports pack;
}
