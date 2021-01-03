package uk.ac.uos;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import uk.ac.uos1.DecryptScene;
import uk.ac.uos1.EncryptScene;
import uk.ac.uos1.GuiUtility;
import uk.ac.uos1.KeyGenScene;

import java.io.IOException;


public class Main extends Application{

    Stage aflWindow;
    Stage fileDisplay;
    Scene login, mainMenu;
    Image aflIcon = new Image("icon/icon2.png");
    Button closeProgram, toEncryptButt, toDecryptButt, toRSAKeyGenButt, dMode, testBut;
    Label mmLabel, aflLabel;



    public static void main(String[] args) throws IOException {

        launch(args);

        KeyOps kO = new KeyOps();

       // Scanner kbInput = new Scanner(System.in);
      //  System.out.println("please choose destination folder for public key: ");
      //  String pbPath = kbInput.nextLine();
      //  kbInput.close();



      //  FileOps.prvKeyLoad();
      //  FileOps.pubKeyLoad("C:\\Users\\Blyat\\Documents\\public.key");

         //3072bit key = 384 characters before shit happens.
      //   FileOps.textReader();
       //  FileOps.fileWriter("2");


    }


    @Override
    public void start(Stage primaryStage) {
        //Icon change
        primaryStage.getIcons().add(aflIcon);
        //Stage Setup
        aflWindow = primaryStage;
        aflWindow.setTitle("s203594 / AFL-3072 / Conatus Sum");
        //Button Setup
        closeProgram = new Button("Close Program");
        toRSAKeyGenButt = new Button("Generate Key Pair");
        toEncryptButt = new Button("Encrypt a File");
        toDecryptButt = new Button("Decrypt a File");

        //Main menu label + style changes
        mmLabel = new Label("Main Menu");
        mmLabel.setStyle("-fx-font-size: 22;" +
                "-fx-font-weight: Bold;" +
                "-fx-underline: true");


        //functions dealing with program closure.
        closeProgram.setOnAction(e -> GuiUtility.closeProgram(aflWindow));
        aflWindow.setOnCloseRequest(e -> {
            e.consume(); //consume tells Java that the close program is going to take care of it from here.
            GuiUtility.closeProgram(aflWindow);
        });

        //This function switches scenes (class based.)
        toEncryptButt.setOnAction(e -> EncryptScene.encryptScene(aflWindow, mainMenu));
        toDecryptButt.setOnAction(e -> DecryptScene.decryptScene(aflWindow, mainMenu));
        toRSAKeyGenButt.setOnAction(e -> KeyGenScene.keyGenScene(aflWindow, mainMenu));


        //HBox showing Logo - Switch to menu drop downs.
        HBox topSeg = new HBox();
        Label aflLabel = new Label("AFL-3072");
        topSeg.getChildren().addAll(aflLabel);
        aflLabel.setPadding(new Insets(10, 0, 0, 360));
        aflLabel.setStyle("-fx-font-size: 26;" +
                "-fx-font-style: Italic;" +
                "-fx-text-fill: #a69b9b");


        //Main Menu layout with function buttons.
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(80, 20, 40, 20));
        layout.getChildren().addAll(mmLabel, toRSAKeyGenButt, toEncryptButt, toDecryptButt, closeProgram);
        layout.setAlignment(Pos.BASELINE_RIGHT);


        //embedding Scene layouts
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topSeg);
        borderPane.setRight(layout);


        //Stage/Scene Drawing.
        this.mainMenu = new Scene(borderPane, 480, 420);
        mainMenu.getStylesheets().add("uk/ac/uos1/DarkMode.css");
        aflWindow.setResizable(false); //locks screen size
        aflWindow.setScene(this.mainMenu);
        aflWindow.show();


    }

}




