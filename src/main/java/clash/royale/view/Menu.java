package clash.royale.view;

import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Menu extends javafx.scene.control.Menu {
    Stage window;
    BorderPane layout;


    public Menu(String file) {
    }


    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Main Menu");

        Menu fileMenu = new Menu("menu.fxml");

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fileMenu);

        layout = new BorderPane();
        layout.setTop(menuBar);

        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();

    }

}
