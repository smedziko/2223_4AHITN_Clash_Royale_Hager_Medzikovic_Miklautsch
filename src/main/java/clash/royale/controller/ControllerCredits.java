package clash.royale.controller;

import clash.royale.model.ChangeScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author: smedziko
 * ControllerCredits:
 * sind dafür verantwortlich, dass die Credits der Entwickler und deren "Firma"
 * im Unterpunkt "Settings" -> "Credits" angezeigt werden
 * Mit einem Klick auf den jeweiligen Namen des Entwicklers bzw. der Firma wird
 * das Instagram - Profil geöffnet.
 */
public class ControllerCredits {

    @FXML
    private Button btn_exit;

    @FXML
    private ImageView HagerImageview;

    @FXML
    private ImageView MedzikovicImageview;

    @FXML
    private ImageView MiklautschImageview;

    @FXML
    private Button back_btn;


    /**
     * @author: smedziko
     * in den folgenden Methoden werden Instagram - Links auf Hyperlinks in der JavaFX-Applikation gesetzt,
     * wo bei einem Klick auf einen Namen der Entwickler bzw. deren Firma die Instagram - Seiten im
     * default Browser geöffnet wird.
     */

    @FXML
    void openLink1(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link clicked!");
        Desktop.getDesktop().browse(new URI("http://www.instagram.com/p.hgar"));
    }

    @FXML
    void openLink2(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link clicked!");
        Desktop.getDesktop().browse(new URI("http://www.instagram.com/semkomedzikovic"));
    }

    @FXML
    void openLink3(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link clicked!");
        Desktop.getDesktop().browse(new URI("http://www.instagram.com/eliassentbygod"));
    }
    @FXML
    void openLink4(ActionEvent event) throws URISyntaxException, IOException{
        System.out.println("Link clicked!");
        Desktop.getDesktop().browse(new URI("http://www.instagram.com/htlsteyr/"));
    }

    public void initialize(){

        back_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ChangeScene.change_scene("menu", back_btn);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }


}
