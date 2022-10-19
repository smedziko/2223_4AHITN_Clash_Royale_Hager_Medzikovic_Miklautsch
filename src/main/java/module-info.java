module clash.royale {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;
    requires  javafx.media;
    requires org.json;

    exports clash.royale;
    exports clash.royale.controller;
    opens clash.royale.controller to javafx.fxml;
}