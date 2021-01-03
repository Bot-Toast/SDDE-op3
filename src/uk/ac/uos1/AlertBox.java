package uk.ac.uos1;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AlertBox {

    private static Stage fileViewStage;
    private static Scene fileViewScene;
    private static TextArea txtBox1, txtBox2;
    private static Button okBut, canBut;
    private static Label stageLabel, stageLabel2;
    private static String ting;

    public static void display(File fileIn, File fileIn2, String label, String label2) throws FileNotFoundException {




        okBut = new Button("Close Window");

        txtBox1 = new TextArea();
        txtBox1.setMinSize(300, 700);
        txtBox1.setWrapText(true);
        txtBox1.setStyle("-fx-control-inner-background: #B0C4DE");


        txtBox2 = new TextArea();
        txtBox2.setMinSize(300, 700);
        txtBox2.setWrapText(true);
        txtBox2.setStyle("-fx-control-inner-background: #B0C4DE");

        stageLabel = new Label(label);
        stageLabel.setStyle("-fx-font-weight: Bold;" +
                            "-fx-font-size: 24");

        stageLabel2 = new Label(label2);
        stageLabel2.setStyle("-fx-font-weight: Bold;" +
                          "-fx-font-size: 24");

        txAT(fileIn);
        txTa(fileIn2);

        okBut.setOnAction(e -> fileViewStage.close());






        VBox textView1 = new VBox(30);
        textView1.getChildren().addAll(stageLabel,txtBox1);
        textView1.setPadding(new Insets(0,20,20,20));

        VBox textView2 = new VBox(30);
        textView2.getChildren().addAll(stageLabel2,txtBox2);
        textView2.setPadding(new Insets(0,20,20,0));

        HBox closeWin = new HBox(10);
        closeWin.getChildren().add(okBut);
        closeWin.setPadding(new Insets(0, 0,200,875));

        BorderPane showTxt = new BorderPane();
        showTxt.setLeft(textView1);
        showTxt.setRight(textView2);
        showTxt.setBottom(closeWin);

        fileViewStage = new Stage();
        fileViewStage.initModality(Modality.APPLICATION_MODAL); //alert box must be closed
        fileViewStage.setTitle("File Window");



        fileViewScene = new Scene(showTxt, 1024, 860);
        fileViewStage.setScene(fileViewScene);
        fileViewStage.setResizable(false);
        fileViewScene.getStylesheets().add("uk/ac/uos1/DarkMode.css");
        fileViewStage.showAndWait();  //before it returns to window 1 it needs to be closed going back to caller. (blocks user interaction.

    }

    private static void txAT(File file) throws FileNotFoundException {
        System.out.println(file);
        Scanner sc = new Scanner(file).useDelimiter("[\\r\\n]");
        while (sc.hasNextLine()) {
            txtBox1.appendText("\n" + sc.nextLine());

        }
    }
    private static void txTa(File file) throws FileNotFoundException {
        System.out.println(file);
        Scanner sc = new Scanner(file).useDelimiter("[\\r\\n]");
        while (sc.hasNextLine()) {
            txtBox2.appendText("\n" + sc.nextLine());

        }
    }
}
