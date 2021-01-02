import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;

public class GuiUtility {


    //Method for "safe" program closure.
    public static void closeProgram(Stage stage) {
        try {
            boolean answer = ConfirmBox.display("Exit Program", "Are you sure?");
            if (answer) {
                System.out.println("Program exiting");
                stage.close();
            } else if (!answer) {

                System.out.println("Program Resumed");
            }
        } catch (Exception e) {
            System.out.println("oof");
        }

    }

    //Method to confirm returning to main menu
    public static void returnToMenu(Stage stage, Scene scene) {
        try {
            boolean answer = ConfirmBox.display("Return to main menu?", "Are you sure?");
            if (answer) {
                System.out.println("Return to menu");
                stage.setScene(scene);
            } else if (!answer) {

                System.out.println("Resumed");
            }
        } catch (Exception e) {
            System.out.println("oof");
        }

    }

    //Method to pull File into path
    public static File showFile(File store) {
        return store;
    }

    //Method to clear up lambda code - chooses files just incase it weren't obvious :).
    public static File fileChoice(Stage window) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a File");
        File fileOfChoice = fileChooser.showOpenDialog(window);
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

    public static void fileNotFoundPrompt(File file) {
        try {

            if (file != null) {
                AlertBox.display(file);
            } else aBox.dispray("Error, no file found", "Please choose a file.");

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    public static void fileNotFoundPromptX2(File file, File file2, Stage stage, Scene scene) {


            if (file != null && file2 != null) {

                 stage.setScene(scene);

            } else if (file != null && file2 ==null) {
                aBox.dispray("Error, no file found", "Please choose a file.");

            } else if (file == null && file2 !=null) {
                aBox.dispray("Error, no file found", "Please choose a file.");
            }
              else aBox.dispray("Error, no file found", "Please choose a file.");
    }
}

