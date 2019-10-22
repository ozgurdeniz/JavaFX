package YouTubeEx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class TreeViews extends Application {

    Stage window;
    Scene scene;
    TreeView<String> treeView;
    public static void main(String[] args) {

        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("TheNewBoston");

        TreeItem<String> root, ozgur, deniz;

        //root
        root = new TreeItem<>();
        root.setExpanded(true);

        //ozgur
        ozgur = makeBranch("Ozgur", root);
        makeBranch("TheNewBoston", ozgur);
        makeBranch("YouTube" , ozgur);
        makeBranch("Chicken" , ozgur);

        //deniz
        deniz = makeBranch("Deniz", root);
        makeBranch("WaltStreet", deniz);
        makeBranch("White" , deniz);

        //create tree
        treeView = new TreeView<>(root);
        treeView.setShowRoot(false);
        treeView.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
                    if (newValue != null)
                        System.out.println(newValue.getValue());
                });



        //Layout
        StackPane layout = new StackPane();
        layout.getChildren().addAll(treeView);
        scene = new Scene(layout, 200, 200);
        window.setScene(scene);
        window.show();

    }

    //Create Branches

    public TreeItem<String> makeBranch(String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }





}
