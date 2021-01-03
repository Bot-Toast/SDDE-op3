package uk.ac.uos1;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import uk.ac.uos.FileOps;
import uk.ac.uos.KeyOps;

public class DecryptScene {


    //Variable Declarations.
    private static Scene deCrypt, deCrypt2;
    private static Button fileOpen2, fileSave2, prvKey, okBut2, canBut2, okBut3, canBut3;
    private static TextArea openText2, save2Text, keyText2;
    private static Label openLabel2, saveLabel2, keyLabel2;
    private static File keyFile2, fileToDecrypt, saveLocation2;


    public static void decryptScene(Stage window, Scene menu){
        FileOps fiO = new FileOps();
        KeyOps kO = new KeyOps();
        keyFile2 = kO.getPvKeyLoc();
        //Variable Initialisation.

        //Button nodes.
        fileOpen2 = new Button("File");
        fileSave2 = new Button("File");
        prvKey = new Button("Key");
        okBut2 = new Button("Ok");
        canBut2 = new Button("Cancel");
        okBut3 = new Button("Show files");
        canBut3 = new Button("Return");

        //Text Area nodes.
        openText2 = new TextArea();
        openText2.setMaxHeight(10);
        openText2.setMaxWidth(200);
        save2Text = new TextArea();
        save2Text.setMaxHeight(10);
        save2Text.setMaxWidth(200);

        //Label nodes.
        openLabel2 = new Label("Please choose a file to: Decrypt");
        saveLabel2 = new Label("Please choose a save location");




        //λ functions for choosing a file, then passes file through a method to be used.
        fileOpen2.setOnAction(e -> {
            fileToDecrypt = GuiUtility.fileOpenChoice(window);
            openText2.clear();
            if (fileToDecrypt != null) {
                openText2.appendText("" + fileToDecrypt.getName()); //displays to user chosen file in gui.

            }
        });

        //Saves user files to
        fileSave2.setOnAction(e -> {
            saveLocation2 = GuiUtility.fileSaveChoice(window);
            save2Text.clear();
            if (saveLocation2 != null) {
                save2Text.appendText("" + saveLocation2.getName());


            }
        });


        //Button Event Action 'listeners' lambdas.
        //Allows user to go back to Main menu
        canBut2.setOnAction(e -> GuiUtility.returnToMenu(window, menu));


        //Progresses user to key choice scene.
        okBut2.setOnAction(e -> window.setScene(deCrypt2)); //progresses user to key choice


        //Returns user back a stage to choose files.
        canBut3.setOnAction(e -> window.setScene(deCrypt)); //returns user back a stage to choose files.


        //Loads necessary values/files for decryption process, and then displays them.
        okBut3.setOnAction(e -> {

            fiO.prvKeyLoad();
            fiO.textReader(fileToDecrypt);
            fiO.fileWriter(saveLocation2, "2");
            GuiUtility.filePromptX2(saveLocation2, fileToDecrypt, "Decrypted Text", "Encrypted File");

        });




        //Scene One :  1 = defines nodes used, their positions & spacing between them.
        //HBoxes used to define space used with the Stage.
        HBox fOpen = GuiUtility.hBoxMaker(fileOpen2,
                openText2,
                openLabel2,
                                        10,
                                        120,
                                        0,
                                        0,
                                        50);



        HBox fSave = GuiUtility.hBoxMaker(fileSave2,
                save2Text,
                saveLabel2,
                                        10,
                                        40,
                                        0,
                                        0,
                                        50);



        HBox okCan = GuiUtility.smallHBoxMaker(okBut2,
                canBut2,
                                            40,
                                            0,
                                            0,
                                            40,
                                            300);

        // Border pane is used to embed different layouts into one.
        BorderPane decryptPane1 = new BorderPane();
        decryptPane1.setCenter(fSave);
        decryptPane1.setTop(fOpen);
        decryptPane1.setBottom(okCan);

        deCrypt = new Scene(decryptPane1, 480, 420);
        deCrypt.getStylesheets().add("uk/ac/uos1/DarkMode.css");


        //Scene Two : Electric-Deja vu?
        HBox okCan2 = GuiUtility.smallHBoxMaker(okBut3,
                                                canBut3,
                                              40,
                                              260,
                                              0,
                                              0,
                                              300);

        BorderPane deCryptPane2 = new BorderPane();
        deCryptPane2.setCenter(okCan2);

        //Stage/Scene size definition.
        deCrypt2 = new Scene(deCryptPane2, 480, 420);

        //CSS file to define style.
        deCrypt2.getStylesheets().add("uk/ac/uos1/DarkMode.css");

        //Instantiates the Scene inside the Stage.
        window.setScene(deCrypt);

        //Shows the final content.
        window.show();

    }


}
