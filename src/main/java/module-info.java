module main.snakenladder {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens main.snakenladder to javafx.fxml;
    exports main.snakenladder;
}