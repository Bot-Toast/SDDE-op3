package uk.ac.uos1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String Message) {

        Stage alertWindow = new Stage();


        alertWindow.initModality(Modality.APPLICATION_MODAL); //Stops user ignoring pop-up stage
        alertWindow.setTitle(title);
        alertWindow.setMinWidth(250);

        Label exitLabel = new Label();
        exitLabel.setText(Message);

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            alertWindow.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            alertWindow.close();
        });

        HBox boxLayout = new HBox(10);
        boxLayout.getChildren().addAll(exitLabel,yesButton,noButton);
        boxLayout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(boxLayout, 250, 75);
        alertWindow.setScene(scene);
        alertWindow.setResizable(false); //lock stage size
        alertWindow.showAndWait();  //before it returns to window 1 it needs to be closed going back to caller. (blocks user interaction.

        return answer;
    }


}