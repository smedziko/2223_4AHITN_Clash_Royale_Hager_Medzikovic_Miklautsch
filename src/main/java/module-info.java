module htl.steyr.ac.at.clashroyale {
    requires javafx.controls;
    requires javafx.fxml;


    opens htl.steyr.ac.at.clashroyale to javafx.fxml;
    exports htl.steyr.ac.at.clashroyale;
    exports htl.steyr.ac.at.clashroyale.controller;
    opens htl.steyr.ac.at.clashroyale.controller to javafx.fxml;
}