package YouTubeEx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxes extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    Stage window;
    Button button;
    Scene scene;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("TheNewBoston JavaFX");

        button = new Button("Click me ");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("Elma");
        choiceBox.getItems().add("Muz");
        choiceBox.getItems().addAll("Kiraz", "Visne", "Portakal");
        choiceBox.setValue("Elma");

        choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println(newValue));
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(choiceBox,button);


        scene = new Scene(layout,300,200);
        window.setScene(scene);
        window.show();

    }

}
