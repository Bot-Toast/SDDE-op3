import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProgramCloseBox {

    static boolean answer;

    public static boolean display(String title, String Message) {

        Stage alertWindow = new Stage();


        alertWindow.initModality(Modality.APPLICATION_MODAL); //alert box must be closed
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

        HBox layout = new HBox(10);
        layout.getChildren().addAll(exitLabel,yesButton,noButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 250, 75);
        alertWindow.setScene(scene);
        alertWindow.showAndWait();  //before it returns to window 1 it needs to be closed going back to caller. (blocks user interaction.

        return answer;
    }


}