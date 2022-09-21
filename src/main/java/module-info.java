module htl.steyr.ac.at.clashroyale {
    requires javafx.controls;
    requires javafx.fxml;


    opens clash.royale to javafx.fxml;
    exports clash.royale;
    exports clash.royale.controller;
    opens clash.royale.controller to javafx.fxml;
}