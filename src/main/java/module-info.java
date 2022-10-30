module tictactoegui {
    requires javafx.controls;
    requires javafx.fxml;
    opens pack to javafx.fxml;
    opens pack.service to javafx.fxml;
    opens pack.controller to javafx.fxml;
    exports pack;
    exports pack.controller;
    exports pack.service;
}
