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

public class DecryptScene {


    //Variable Declarations.
    private static Stage printShow;
    private static Scene deCrypt, deCrypt2;
    private static Button fileOpen, fileSave, prvKey, okBut, canBut, okBut2, canBut2;
    private static TextArea openText, saveText, keyText;
    private static Label openLabel, saveLabel, keyLabel;


    public static void decryptScene(Stage window, Scene menu){

        //Variable Initialisation.

        //Button nodes.
        fileOpen = new Button("File");
        fileSave = new Button("File");
        prvKey = new Button("Key");
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
        openLabel = new Label("Please choose a file to: Decrypt");
        saveLabel = new Label("Please choose a save location");
        keyLabel = new Label("Please choose your public key");

        //Button Event Action 'listeners' lambdas.
        canBut.setOnAction(e -> GuiUtility.returnToMenu(window, menu)); //allows user to go back to Main menu
        okBut.setOnAction(e -> window.setScene(deCrypt2)); //progresses user to key choice
        canBut2.setOnAction(e -> window.setScene(deCrypt)); //returns user back a stage to choose files.
        okBut2.setOnAction(e -> window.setScene(deCrypt2)); //progresses user to encryption process.



        //λ functions for choosing a file, then passes file through a method to be used.
        fileOpen.setOnAction(e -> {
            File fileToDecrypt = GuiUtility.fileOpenChoice(window);
            if (fileToDecrypt != null) {
                saveText.clear();
                openText.appendText("" + fileToDecrypt.getName()); //displays to user chosen file in gui.
                GuiUtility.showFile(fileToDecrypt);
            }
        });

        //Saves user files to
        fileSave.setOnAction(e -> {
            FileChooser fChoose = new FileChooser();
            fChoose.setTitle("Open Resource File");
            fChoose.setInitialDirectory(new File(System.getProperty("user.home"), ".\\Documents")); //specifies users Documents file.
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("txt files (*.txt)", "*.txt");
            fChoose.getExtensionFilters().add(extFilter);
            File result = fChoose.showOpenDialog(window);

            if (result != null) {
                saveText.appendText("" + result.getName());
            }
        });

        prvKey.setOnAction(e -> {
            File prvKeyFile = GuiUtility.fileOpenChoice(window);
            if (prvKeyFile != null) {
                saveText.clear();
                keyText.appendText("" + prvKeyFile.getName()); //displays to user chosen file in gui.
                GuiUtility.showFile(prvKeyFile);
            }
        });

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

        deCrypt = new Scene(encryptPane1, 480, 420);
        deCrypt.getStylesheets().add("uk/ac/uos1/DarkMode.css");


        //Scene Two : Electric-Deja vu?
        HBox prvKeyOpen = GuiUtility.hBoxMaker(prvKey,
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

        BorderPane deCryptPane2 = new BorderPane();
        deCryptPane2.setCenter(prvKeyOpen);
        deCryptPane2.setBottom(okCan2);

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
