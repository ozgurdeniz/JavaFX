package YouTubeEx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.text.Document;

public class TableViews extends Application {
    Stage window;
    Scene scene;
    HBox hBox;
    Button addButton;
    Button deleteButton;
    TableView<Product> tableView;
    TextField nameInput, priceInput, quantityInput;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        window=primaryStage;
        window.setTitle("Title");

        //Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price column
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Quantity column
        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //Name Input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        //Price Input
        priceInput = new TextField();
        priceInput.setPromptText("Price");

        //Quantity Input
        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");

        //Buttons
        addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput,priceInput,quantityInput,addButton,deleteButton);

        tableView = new TableView<>();
        tableView.setItems(getProduct());
        tableView.getColumns().addAll(nameColumn,priceColumn,quantityColumn);


        VBox vBox = new VBox();
        vBox.getChildren().addAll(tableView,hBox);

        scene = new Scene(vBox);
        window.setScene(scene);
        window.show();

    }

    //add button clicked
    public void addButtonClicked(){
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        tableView.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    //delete button clicked
    public void deleteButtonClicked(){
        ObservableList<Product> productsSelected, allProducts;
        allProducts = tableView.getItems();
        productsSelected = tableView.getSelectionModel().getSelectedItems();
        productsSelected.forEach(allProducts::remove);
    }

    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 859.00, 20));
        products.add(new Product("Bouncy Ball", 2.26, 209));
        products.add(new Product("Toilet", 99.00, 30));
        products.add(new Product("Note book", 19.99, 75));
        products.add(new Product("Corn", 1.49, 987));
        return products;
    }
}
























