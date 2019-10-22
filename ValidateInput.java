package YouTubeEx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ValidateInput extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    Stage window;
    Button logButton;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("TheNewBoston JavaFX");

        TextField nameInput = new TextField();

        logButton = new Button("Login");
        logButton.setOnAction( e -> {
            isInt(nameInput.getText());
        });

        VBox layout = new VBox();
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(nameInput,logButton);


        Scene scene = new Scene(layout,300,200);
        scene.getStylesheets().add("YouTubeEx/Viper.css");

        window.setScene(scene);

        window.show();

    }

    private boolean isInt(String msg){
        try {
            int age = Integer.parseInt(msg);
            System.out.println("User is : "+ age);
            return true;

        }catch (NumberFormatException e){
            System.err.println("Error "+ msg + " is not a number.");
            return false;
        }
    }

}
