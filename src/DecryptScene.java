import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DecryptScene {

    private static Scene deCrypt;
    private static Button button2;


    public static void decryptScene(Stage window, Scene menu){


        button2 = new Button("THIS SUCCCKS");
        button2.setOnAction(e -> window.setScene(menu));
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        deCrypt = new Scene(layout2, 480, 420);
        window.setScene(deCrypt);
        window.show();

    }
}
