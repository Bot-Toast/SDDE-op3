import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class EncryptScene {

    private static Stage printShow;
    private static Scene enCrypt, enCryptpt2;
    private static Button fileOpen, fileSave, pubKey, okBut, canBut;
    private static TextArea openText, saveText, keyText;
    private static Label openLabel, saveLabel, keyLabel;


    public static void encryptScene(Stage window, Scene menu){
        fileOpen = new Button("File");
        fileSave = new Button("File");
        pubKey = new Button("Key");
        okBut = new Button("Ok");
        canBut = new Button("Cancel");
        openText = new TextArea();
        openText.setMaxHeight(10);
        openText.setMaxWidth(200);
        saveText = new TextArea();
        saveText.setMaxHeight(10);
        saveText.setMaxWidth(200);
        keyText = new TextArea();
        keyText.setMaxHeight(10);
        keyText.setMaxWidth(200);
        openLabel = new Label("Please choose a file to Encrypt");
        saveLabel = new Label("Please choose a save location");
        keyLabel = new Label("Please choose your public key");


        canBut.setOnAction(e -> window.setScene(menu)); //allows user to go back to Main menu
        okBut.setOnAction(e -> window.setScene(enCryptpt2)); //progresses user to key choice

        //function chooses a file and holds it in result ready for use.
        fileOpen.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File result = fileChooser.showOpenDialog(window);
            if (result != null) {
                openText.appendText("" + result.getName());
            }
        });
        //change to save
        fileSave.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File result = fileChooser.showOpenDialog(window);
            if (result != null) {
                saveText.appendText("" + result.getName());
            }
        });

        pubKey.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File result = fileChooser.showOpenDialog(window);
            if (result != null) {
                keyText.appendText("" + result.getName());
            }
        });


        //Scene 1 Encrypt
        HBox fOpen = new HBox(10);
        fOpen.getChildren().addAll(fileOpen,openText,openLabel);
        fOpen.setPadding(new Insets(120, 0,0,60));

        HBox fSave = new HBox(10);
        fSave.getChildren().addAll(fileSave,saveText,saveLabel);
        fSave.setPadding(new Insets(40, 0,0,60));


        HBox okCan = new HBox(40);
        okCan.getChildren().addAll(okBut, canBut);
        okCan.setPadding(new Insets(0, 0,40,240));


        //Scene 2 Encrypt-Boogaloo


        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(fSave);
        borderPane.setTop(fOpen);
        borderPane.setBottom(okCan);

        enCrypt = new Scene(borderPane, 480, 420);
        enCrypt.getStylesheets().add("DarkMode.css");
        window.setScene(enCrypt);
        window.show();

    }


}
