package YouTubeEx;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Binding extends Application {

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

        /*IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty();

        y.bind(x.multiply(10));
        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue() +"\n");

        x.setValue(9);
        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue() +"\n");*/

        //Inputs and Labels
        TextField userInput = new TextField();
        userInput.setMinWidth(200);
        Label firstLabel = new Label("Welcome to the site ");
        Label secondLabel = new Label();

        HBox bottomText = new HBox(firstLabel, secondLabel);
        bottomText.setAlignment(Pos.CENTER);

        secondLabel.textProperty().bind(userInput.textProperty());

        button = new Button("Submit");

        VBox vBox = new VBox(10,userInput, bottomText);
        vBox.setAlignment(Pos.CENTER);

        scene = new Scene(vBox,300,250);
        window.setScene(scene);
        window.show();

    }
}
