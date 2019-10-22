package YouTubeEx;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class OpenFileChooserDemo extends Application {

    private Desktop desktop = Desktop.getDesktop();

    @Override
    public void start(Stage primaryStage) throws Exception {

        final FileChooser fileChooser = new FileChooser();

        TextArea textArea = new TextArea();
        textArea.setMinHeight(70);

        Button buttonM = new Button("Select Multi Files");

        buttonM.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                textArea.clear();
                List<File> files = fileChooser.showOpenMultipleDialog(primaryStage);

                printLog(textArea, files);
            }
        });

        System.out.println(textArea.getText());

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(5);

        root.getChildren().addAll(textArea, buttonM);

        Scene scene = new Scene(root, 400, 200);

        primaryStage.setTitle("JavaFX FileChooser (o7planning.org)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void printLog(TextArea textArea, List<File> files) {
        if (files == null || files.isEmpty()) {
            return;
        }
        for (File file : files) {
            textArea.appendText(file.getAbsolutePath() + "\n");
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}