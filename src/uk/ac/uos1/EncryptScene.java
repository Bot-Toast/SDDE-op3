package uk.ac.uos1;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;

public class EncryptScene {

    //Variable Declarations.
    private static Stage printShow;
    private static Scene enCrypt, enCryptpt2;
    private static Button fileOpen, fileSave, pubKey, okBut, canBut, okBut2, canBut2;
    private static TextArea openText, saveText, keyText;
    private static Label openLabel, saveLabel, keyLabel;
    private static File keyFile, fileToEncrypt, saveLocation;

    public static void encryptScene(Stage window, Scene menu){

        //Variable Initialisation.

        //Button nodes.
        fileOpen = new Button("File");
        fileSave = new Button("File");
        pubKey = new Button("Key");
        okBut = new Button("Ok");
        canBut = new Button("Cancel");
        okBut2 = new Button("Ok");
        canBut2 = new Button("Return");

        //Text Area nodes.
        openText = new TextArea();
        openText.setMaxHeight(10);
        openText.setMaxWidth(200);
        saveText = new TextArea();
        saveText.setMaxHeight(10);
        saveText.setMaxWidth(200);
        keyText = new TextArea();
        keyText.setMaxHeight(10);
        keyText.setMaxWidth(200);

        //Label nodes.
        openLabel = new Label("Please choose a file to Encrypt");
        saveLabel = new Label("Please choose a save location");
        keyLabel = new Label("Please choose your public key");


        //λ functions for choosing a file, then passes file through a method to be used.

        fileOpen.setOnAction(e -> {
            File tempFile1 = GuiUtility.fileOpenChoice(window);
            if (tempFile1 != null) {
                openText.appendText("" + tempFile1.getName()); //displays to user chosen file in gui.
                fileToEncrypt = GuiUtility.showFile(tempFile1);
                saveLocation = GuiUtility.showFile(tempFile1);
            }
        });

        //change to save
        fileSave.setOnAction(e -> {
            saveLocation = GuiUtility.fileSaveChoice(window);
            if (saveLocation != null) {
                saveText.appendText("" + saveLocation.getName());
            }
        });

        pubKey.setOnAction(e -> {
            File tempFile3 = GuiUtility.fileOpenChoice(window);
            if (tempFile3 != null) {
                saveText.clear();
                keyText.appendText("" + tempFile3.getName()); //displays to user chosen file in gui.
               keyFile = GuiUtility.showFile(tempFile3);

            }
        });




        //Button Event Action 'listeners' lambdas.
        canBut.setOnAction(e -> GuiUtility.returnToMenu(window, menu)); //allows user to go back to Main menu

        okBut.setOnAction(e -> {
            window.setScene(enCryptpt2);
        }); //progresses user to key choice

        canBut2.setOnAction(e -> window.setScene(enCrypt)); //returns user back a stage to choose files.

        okBut2.setOnAction(e -> {
            try {
                GuiUtility.fileNotFoundPromptX2(keyFile, fileToEncrypt, "Plain Text", "Encrypted Text");
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }); //progresses user to encryption process.


        //Scene One :  1 = defines nodes used, their positions & spacing between them.
        //HBoxes used to define space used with the Stage.
        HBox fOpen = GuiUtility.hBoxMaker(fileOpen,
                                        openText,
                                        openLabel,
                                        10,
                                        120,
                                        0,
                                        0,
                                        50);



        HBox fSave = GuiUtility.hBoxMaker(fileSave,
                                        saveText,
                                        saveLabel,
                                        10,
                                        40,
                                        0,
                                        0,
                                        50);



        HBox okCan = GuiUtility.smallHBoxMaker(okBut,
                                            canBut,
                                            40,
                                            0,
                                            0,
                                            40,
                                            300);


        // Border pane is used to embed different layouts into one.
        BorderPane encryptPane1 = new BorderPane();
        encryptPane1.setCenter(fSave);
        encryptPane1.setTop(fOpen);
        encryptPane1.setBottom(okCan);

        enCrypt = new Scene(encryptPane1, 480, 420);
        enCrypt.getStylesheets().add("uk/ac/uos1/DarkMode.css");



        //Scene Two : Electric-Boogaloo - Same as above.
        HBox pbKeyOpen = GuiUtility.hBoxMaker(pubKey,
                                            keyText,
                                            keyLabel,
                                            10,
                                            197,
                                            0,
                                            0,
                                            48);


        HBox okCan2 = GuiUtility.smallHBoxMaker(okBut2,
                                               canBut2,
                                               40,
                                               0,
                                               0,
                                               40,
                                               300);

        BorderPane encryptPane2 = new BorderPane();
        encryptPane2.setCenter(pbKeyOpen);
        encryptPane2.setBottom(okCan2);

        //Stage/Scene size definition.
        enCryptpt2 = new Scene(encryptPane2, 480, 420);

        //CSS file to define style, Dark mode is nicer on the eyes, we know you stay up late to mark these!
        enCryptpt2.getStylesheets().add("uk/ac/uos1/DarkMode.css");



        //Instantiates the Scene inside the Stage.
        window.setScene(enCrypt);

        //Shows the final content.
        window.show();

    }


}
