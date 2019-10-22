package YouTubeEx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneLayout extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Stage window;
    Button logButton, signUpButton;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("TheNewBoston JavaFX");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label nameLabel = new Label("Username :");
        nameLabel.setId("bold-label");
        GridPane.setConstraints(nameLabel, 0, 0);

        TextField nameInput = new TextField("Ozgur");
        GridPane.setConstraints(nameInput, 1, 0);

        Label passLabel = new Label("Pass :");
        GridPane.setConstraints(passLabel, 0, 1);

        TextField passInput = new TextField();
        passInput.setPromptText("****");
        GridPane.setConstraints(passInput, 1, 1);

        logButton = new Button("Login");
        GridPane.setConstraints(logButton, 1, 2);

        signUpButton = new Button("Sign up");
        signUpButton.getStyleClass().add("button-blue");
        GridPane.setConstraints(signUpButton, 1, 3);

        grid.getChildren().addAll(nameInput,nameLabel, passInput, passLabel,logButton, signUpButton);
        Scene scene = new Scene(grid,300,200);
        scene.getStylesheets().add("YouTubeEx/Viper.css");
        window.setScene(scene);

        window.show();

    }
}
