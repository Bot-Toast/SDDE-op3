import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class KeyGenScene {

    //Variable Declarations.
    private static Stage printShow;
    private static Scene keyGen;
    private static Button fileSave, okBut, canBut, okBut2, canBut2;
    private static TextArea saveText, keyText;
    private static Label  saveLabel, keyLabel;

    public static void keyGenScene(Stage window, Scene menu){

        //Variable Initialisation.

        //Button nodes.
        fileSave = new Button("File");
        okBut = new Button("Ok");
        canBut = new Button("Cancel");
        okBut2 = new Button("Ok");
        canBut2 = new Button("Return");

        //Text Area node.
        saveText = new TextArea();
        saveText.setMaxHeight(10);
        saveText.setMaxWidth(200);

        //Label node
        saveLabel = new Label("Please choose a save location");

        //Button Event Action 'listeners' lambdas.
        canBut.setOnAction(e -> GuiUtility.returnToMenu(window, menu)); //allows user to go back to Main menu
     //   okBut.setOnAction(e -> window.setScene(deCrypt2)); //progresses user to key choice
     //   canBut2.setOnAction(e -> window.setScene(deCrypt)); //returns user back a stage to choose files.
     //   okBut2.setOnAction(e -> window.setScene(deCrypt2)); //progresses user to encryption process.


        //λ functions for choosing a file path to save, then passes file through a method to be used.
        fileSave.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File result = fileChooser.showSaveDialog(window);
            if (result != null) {
                saveText.clear();
                saveText.appendText("" + result.getName());
            } else if (result == null) {
                saveText.clear();
                saveText.appendText("Error please set a destination");
            }
        });

        //Scene One
        HBox keyPath = GuiUtility.hBoxMaker(fileSave,
                                                saveText,
                                                saveLabel,
                                                10,
                                                197,
                                                0,
                                                0,
                                                48);


        HBox okCan = GuiUtility.smallHBoxMaker(okBut,
                                                canBut,
                                                40,
                                                0,
                                                0,
                                                40,
                                                300);



        BorderPane keyGenPane = new BorderPane();
        keyGenPane.setCenter(keyPath);
        keyGenPane.setBottom(okCan);



        keyGen = new Scene(keyGenPane, 480, 420);
        keyGen.getStylesheets().add("DarkMode.css");



        window.setScene(keyGen);
        window.show();

    }
}
