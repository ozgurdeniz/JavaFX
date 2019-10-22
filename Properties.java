package YouTubeEx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Properties extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    Stage window;
    Button button;
    Scene scene;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("TheNewBoston");


        Person ozgur = new Person();
        ozgur.firstNameProperty().addListener( (v, oldValue, newValue) -> {
            System.out.println("Name changed to " + newValue);
            System.out.println("firstNameProperty(): " + ozgur.firstNameProperty());
            System.out.println("getFirstName(): " + ozgur.getFirstName());
        });

        button = new Button("Submit");
        button.setOnAction( e -> ozgur.setFirstName("Deniz"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();

    }
}
