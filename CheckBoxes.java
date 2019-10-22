package YouTubeEx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxes extends Application {

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

        CheckBox box1 = new CheckBox("Lahmacun");
        CheckBox box2 = new CheckBox("Gozleme");
        box1.setSelected(true);


        button = new Button("Order Now");
        button.setOnAction(e -> handleOptions(box1, box2));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(box1,box2,button);


        Scene scene = new Scene(layout,300,200);
        window.setScene(scene);

        window.show();

    }

    private void handleOptions(CheckBox box1, CheckBox box2){
        String msg = "Ozgur ister : ";

        if (box1.isSelected())
            msg += box1.getText();

        if (box2.isSelected())
            msg += box2.getText();

        System.out.println(msg);
    }

}
