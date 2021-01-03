package uk.ac.uos1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorBox {

public static void displayMessage(String title, String message){

    Stage errorWin = new Stage();


        errorWin.initModality(Modality.APPLICATION_MODAL); //alert box must be closed
        errorWin.setTitle(title);
        errorWin.setMinWidth(350);
        errorWin.setMinHeight(150);

    Label label = new Label();
        label.setText(message);
    Button closeButton = new Button("close the window");
        closeButton.setOnAction(e -> errorWin.close());



    VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

    Scene scene = new Scene(layout);
        scene.getStylesheets().add("uk/ac/uos1/DarkMode.css");
        errorWin.setScene(scene);
        errorWin.showAndWait();  //before it returns to window 1 it needs to be closed going back to caller. (blocks user interaction.

}

}
