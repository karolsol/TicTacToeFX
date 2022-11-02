module tictactoegui {
    requires javafx.controls;
    requires javafx.fxml;
    opens pack;
    opens pack.service;
    opens pack.controller;
    exports pack;
    exports pack.controller;
    exports pack.service;
}
