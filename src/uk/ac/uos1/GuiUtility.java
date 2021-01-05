package uk.ac.uos1;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;

public class GuiUtility {


    //Method for "safe" program closure.
    public static void closeProgram(Stage stage) {
        try {
            boolean answer = ConfirmBox.display("Exit Program", "Are you sure?");
            if (answer) {
                stage.close();
            }
        } catch (Exception e) { System.out.println("/shrug");

        }

    }

    //Method to confirm returning to main menu
    public static void returnToMenu(Stage stage, Scene scene) {
        try {
            boolean answer = ConfirmBox.display("Return to main menu?", "Are you sure?");
            if (answer) {
                stage.setScene(scene);
            }

        } catch (Exception e) { System.out.println("/frown");
        }

    }

    //Method to clear up lambda code - opens chosen file, stores in file variable.
    public static File fileOpenChoice(Stage window) {
        File fileOfChoice;

        FileChooser fileChum = new FileChooser();
        fileChum.setInitialDirectory(new File(System.getProperty("user.home"), ".\\Documents")); //specifies users Documents file.
        fileChum.setTitle("Select a File");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("txt files (*.txt)", "*.txt");
        FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("rtf files (*.rtf)", "*.rtf");
        fileChum.getExtensionFilters().addAll(extFilter, extFilter2);
        fileOfChoice = fileChum.showOpenDialog(window);
        return fileOfChoice;

    }

    //Method to clear up lambda code - chooses location to save encrypted/decrypted file.
    public static File fileSaveChoice(Stage window) {
        File fileOfChoice;

        FileChooser fileChum = new FileChooser();
        fileChum.setInitialDirectory(new File(System.getProperty("user.home"), ".\\Documents")); //specifies users Documents file.
        fileChum.setTitle("Select a File");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("txt files (*.txt)", "*.txt");
        FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("rtf files (*.rtf)", "*.rtf");
        fileChum.getExtensionFilters().addAll(extFilter, extFilter2);
        fileOfChoice = fileChum.showSaveDialog(window);
        return fileOfChoice;

    }

    //Method to choose location of public key.
    public static File keySaveChoice(Stage window) {
        File fileOfChoice;
        FileChooser fileChum = new FileChooser();
        fileChum.setInitialDirectory(new File(System.getProperty("user.home"), ".\\Documents")); //specifies users Documents file.
        fileChum.setTitle("Select a File");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("key files (*.key)", "*.key");
        fileChum.getExtensionFilters().add(extFilter);
        fileOfChoice = fileChum.showSaveDialog(window);
        return fileOfChoice;

    }

    //Method to choose location of public key.
    public static File keyOpenChoice(Stage window) {
        File fileOfChoice;
        FileChooser fileChum = new FileChooser();
        fileChum.setInitialDirectory(new File(System.getProperty("user.home"), ".\\Documents")); //specifies users Documents file.
        fileChum.setTitle("Select a File");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("key files (*.key)", "*.key");
        fileChum.getExtensionFilters().add(extFilter);
        fileOfChoice = fileChum.showOpenDialog(window);
        return fileOfChoice;

    }


    //Method for making Hboxes for fileChoosing nodes.
    public static HBox hBoxMaker(Button bt, TextArea tx, Label lb, long spacing, long padTop, long padRgt, long padBtm, long padLft) {
        HBox boxName = new HBox(spacing);
        boxName.getChildren().addAll(bt, tx, lb);
        boxName.setPadding(new Insets(padTop, padRgt, padBtm, padLft));
        return boxName;


    }



    //Method for making smaller Hboxes used when only button nodes are needed.
    public static HBox smallHBoxMaker(Button bt, Button bt2, long spacing, long padTop, long padRgt, long padBtm, long padLft) {
        HBox smallBoxName = new HBox(spacing);
        smallBoxName.getChildren().addAll(bt, bt2);
        smallBoxName.setPadding(new Insets(padTop, padRgt, padBtm, padLft));
        return smallBoxName;


    }




    public static void filePromptX2(File file, File file2, String label, String label2)  {

        try {
            if (file != null && file2 != null) {
                 AlertBox.display(file,file2, label, label2);


            } else if (file != null) {
                ErrorBox.displayMessage("Error, File not Found", "Please choose a file.");

            } else if (file2 != null) {
                ErrorBox.displayMessage("Error, File not Found", "Please choose a file.");
            }
              else ErrorBox.displayMessage("Error, no file found", "Please choose a file.");
    }catch (FileNotFoundException fileNotFoundException) {
        fileNotFoundException.printStackTrace();
    }
}

}

