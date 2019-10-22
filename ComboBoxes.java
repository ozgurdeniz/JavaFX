package YouTubeEx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxes extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    Stage window;
    Button button;
    Scene scene;
    ComboBox<String> comboBox;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("TheNewBoston JavaFX");
        button = new Button("Click me ");

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Denizler imparatoru",
                "Yasak Kirallik",
                "Hizli ve Ofkeli",
                "Harry Potter"
        );

        comboBox.setPromptText("What is your favorite movie ?");

        comboBox.setEditable(true);

        comboBox.setOnAction(e -> System.out.println("You selected : "+ comboBox.getValue()));

        button.setOnAction(e -> printMovie());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(comboBox,button);


        scene = new Scene(layout,300,200);
        window.setScene(scene);
        window.show();

    }

    private void printMovie(){
        System.out.println(comboBox.getValue());
    }

}
