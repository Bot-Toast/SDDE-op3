package uk.ac.uos1;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import uk.ac.uos.KeyOps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.security.interfaces.RSAKey;
import java.security.spec.RSAKeyGenParameterSpec;

public class KeyGenScene {

    //Variable Declarations.
    private static Stage printShow;
    private static Scene keyGen;
    private static Button fileSave, okBut, canBut, showFileBut;
    private static TextArea saveText, keyText;
    private static Label  saveLabel, keyLabel;
    private static File pubKeyLoc, pvKeyLoc;
    public static void keyGenScene(Stage window, Scene menu){

        //Variable Initialisation.

        KeyOps kO = new KeyOps();
        pvKeyLoc = kO.getPvKeyLoc();
        //Button nodes.
        fileSave = new Button("File");
        okBut = new Button("Ok");
        canBut = new Button("Cancel");
        showFileBut = new Button("Show Keys");


        //Text Area node.
        saveText = new TextArea();
        saveText.setMaxHeight(10);
        saveText.setMaxWidth(200);

        //Label node
        saveLabel = new Label("Choose a save location");


        //Button Event Action 'listeners' lambdas.
        canBut.setOnAction(e -> GuiUtility.returnToMenu(window, menu)); //allows user to go back to Main menu


      okBut.setOnAction(e -> {
          try {
              kO.RSAKeyGen(pubKeyLoc);
              GuiUtility.fileNotFoundPromptX2(pvKeyLoc, pubKeyLoc, "Public Key", "Private Key");
          } catch (IOException ioException) {
              ioException.printStackTrace();
          }
      }); //progresses user to key choice


       // showFileBut.setOnAction(e ->  //returns user back a stage to choose files.



        //λ functions for choosing a file path to save, then passes file through a method to be used.
        fileSave.setOnAction(e -> {
            pubKeyLoc = GuiUtility.keySaveChoice(window);
            saveText.clear();
            if (pubKeyLoc != null) {
                saveText.appendText("" + pubKeyLoc.getName());
            } else  {
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
        keyGen.getStylesheets().add("uk/ac/uos1/DarkMode.css");



        window.setScene(keyGen);
        window.show();

    }
}
