import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

public class AlertBox {


    public static void display(String title, String message) {

        Stage alertWindow = new Stage();

        TextArea textArea = new TextArea();
        alertWindow.initModality(Modality.APPLICATION_MODAL); //alert box must be closed
        alertWindow.setTitle(title);
        alertWindow.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("close the window");
        closeButton.setOnAction(e -> alertWindow.close());

        //function chooses a file and holds it in result ready for use.
        closeButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File result = fileChooser.showOpenDialog(alertWindow);
            if (result != null) {
                textArea.appendText("" + result.getName());
            }
            System.out.println(result);
        });


        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton, textArea);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        alertWindow.setScene(scene);
        alertWindow.showAndWait();  //before it returns to window 1 it needs to be closed going back to caller. (blocks user interaction.

    }
}
