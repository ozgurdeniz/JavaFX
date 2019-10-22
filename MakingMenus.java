package YouTubeEx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.border.Border;

public class MakingMenus extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    Stage window;
    Scene scene;
    BorderPane layout;

    @Override
    public void start(Stage primaryStage) {
        window=primaryStage;
        window.setTitle("TheNewBoston");

        //File Menu
        Menu fileMenu = new Menu("File");

        //Menu Items
        MenuItem newFile = new MenuItem("New..");
        newFile.setOnAction(e -> System.out.println("Create new file.."));
        fileMenu.getItems().add(newFile);

        fileMenu.getItems().add(new MenuItem("Open.."));
        fileMenu.getItems().add(new MenuItem("Save.."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings.."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit.."));

        //Edit Menu
        Menu editMenu = new Menu("_Edit");

        //Menu Items
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));

        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> System.out.println("Pasting.."));
        paste.setDisable(true  );
        editMenu.getItems().add(paste);

        //Help Menu
        Menu helpMenu = new Menu("Help");

        //Menu Items
        CheckMenuItem showLines = new CheckMenuItem("Shox Line Numbers");
        newFile.setOnAction(e -> System.out.println("Create new file.."));
        showLines.setOnAction(e -> {
            if (showLines.isSelected())
                System.out.println("Show lines..");
            else
                System.out.println("Hide lines");
        });
        CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLines, autoSave);

        //Difficulty Menu
        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);
        difficultyMenu.getItems().addAll(easy,medium,hard);


        // Main Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,editMenu,helpMenu, difficultyMenu);

        layout = new BorderPane();
        layout.setTop(menuBar);
        scene = new Scene(layout, 300,300);
        window.setScene(scene);
        window.show();

    }
}
















