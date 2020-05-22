package computershop.graphics;

import computershop.jdbchandlers.Queries;
import computershop.jdbchandlers.ScriptExecutor;
import computershop.jdbchandlers.Updates;
import computershop.model.Categories;
import computershop.model.Collections;
import computershop.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppController {

    @FXML
    private TableView<Product> table;

    @FXML
    private TableColumn<Product, Long> productIdColumn;

    @FXML
    private TableColumn<Product, String> categoryNameColumn;

    @FXML
    private TableColumn<Product, String> productNameColumn;

    @FXML
    private TableColumn<Product, Double> costColumn;

    @FXML
    private TableColumn<Product, String> maintainerColumn;

    @FXML
    private TableColumn<Product, String> characteristicsColumn;

    @FXML
    private TableColumn<Product, String> warehouseAddressColumn;

    @FXML
    private Button clearButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button removeButton;

    @FXML
    private TextField shopCityNameSearchPredicateField;

    @FXML
    private CheckBox shopCityNameSearchBtn;

    @FXML
    private CheckBox costSearchBtn;

    @FXML
    private TextField costSearchPredicateField;

    @FXML
    private CheckBox psCategory;

    @FXML
    private CheckBox mbCategory;

    @FXML
    private CheckBox cpuCategory;

    @FXML
    private CheckBox gpuCategory;

    @FXML
    private CheckBox ramCategory;

    @FXML
    private CheckBox monitorCategory;

    @FXML
    private CheckBox laptopCategory;

    @FXML
    private CheckBox computerCategory;

    @FXML
    private CheckBox selectAllBtn;

    @FXML
    private Button getListButton;

    @FXML
    private Button loadDefaultDataButton;

    @FXML
    private Button searchButton;

    public static boolean confirm = false;

    private boolean shopCityNameSearch = false;
    private boolean costSearch = false;

    @FXML
    void initialize() {

        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        categoryNameColumn.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        maintainerColumn.setCellValueFactory(new PropertyValueFactory<>("maintainer"));
        characteristicsColumn.setCellValueFactory(new PropertyValueFactory<>("characteristics"));
        warehouseAddressColumn.setCellValueFactory(new PropertyValueFactory<>("addresses"));
        table.setItems(Collections.productsObservableList);

        table.setEditable(true);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        categoryNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        categoryNameColumn.setOnEditCommit(e -> {
            createConfirmWindow();
            if (confirm) {
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setCategoryName(e.getNewValue());
                String newValue = e.getNewValue();
                Updates.updateCategoryName(e.getTableView().getItems().get(e.getTablePosition().getRow()).getId(), newValue);
            } else {
                table.refresh();
            }
        });

        productNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        productNameColumn.setOnEditCommit(e -> {
            createConfirmWindow();
            if (confirm) {
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setProductName(e.getNewValue());
                String newValue = e.getNewValue();
                Updates.updateProductName(e.getTableView().getItems().get(e.getTablePosition().getRow()).getId(), newValue);
            } else {
                table.refresh();
            }
        });

        costColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        costColumn.setOnEditCommit(e -> {
            createConfirmWindow();
            if (confirm) {
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setCost(e.getNewValue());
                Double newValue = e.getNewValue();
                Updates.updateCost(e.getTableView().getItems().get(e.getTablePosition().getRow()).getId(), newValue);
            } else {
                table.refresh();
            }
        });

        maintainerColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        maintainerColumn.setOnEditCommit(e -> {
            createConfirmWindow();
            if (confirm) {
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setMaintainer(e.getNewValue());
                String newValue = e.getNewValue();
                Updates.updateMaintainer(e.getTableView().getItems().get(e.getTablePosition().getRow()).getId(), newValue);
            } else {
                table.refresh();
            }
        });

        characteristicsColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        characteristicsColumn.setOnEditCommit(e -> {
            createConfirmWindow();
            if (confirm) {
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setCharacteristics(e.getNewValue());
                String newValue = e.getNewValue();
                Updates.updateCharacteristics(e.getTableView().getItems().get(e.getTablePosition().getRow()).getId(), newValue);
            } else {
                table.refresh();
            }
        });

        getListButton.setOnAction(actionEvent -> {
            List<String> categories = new ArrayList<>();

            if (computerCategory.isSelected()) {
                categories.add(Categories.COMPUTER_CATEGORY);
            }
            if (laptopCategory.isSelected()) {
                categories.add(Categories.LAPTOP_CATEGORY);
            }
            if (monitorCategory.isSelected()) {
                categories.add(Categories.MONITOR_CATEGORY);
            }
            if (cpuCategory.isSelected()) {
                categories.add(Categories.CPU_CATEGORY);
            }
            if (gpuCategory.isSelected()) {
                categories.add(Categories.GPU_CATEGORY);
            }
            if (ramCategory.isSelected()) {
                categories.add(Categories.RAM_CATEGORY);
            }
            if (mbCategory.isSelected()) {
                categories.add(Categories.MOTHERBOARD_CATEGORY);
            }
            if (psCategory.isSelected()) {
                categories.add(Categories.POWER_SUPPLY_CATEGORY);
            }

            Collections.clearAll();
            if (categories.size() > 0) {
                Collections.addAll(Queries.getListByCriteria(categories));
            } else {
                Warning.showWarnWithHeaderText("No categories selected");
            }
        });

        selectAllBtn.setOnAction(actionEvent -> {
            if (!selectAllBtn.isSelected()) {
                computerCategory.setSelected(false);
                laptopCategory.setSelected(false);
                monitorCategory.setSelected(false);
                cpuCategory.setSelected(false);
                gpuCategory.setSelected(false);
                ramCategory.setSelected(false);
                mbCategory.setSelected(false);
                psCategory.setSelected(false);
            } else {
                computerCategory.setSelected(true);
                laptopCategory.setSelected(true);
                monitorCategory.setSelected(true);
                cpuCategory.setSelected(true);
                gpuCategory.setSelected(true);
                ramCategory.setSelected(true);
                mbCategory.setSelected(true);
                psCategory.setSelected(true);
            }
        });

        loadDefaultDataButton.setOnAction(actionEvent -> {
            try {
                ScriptExecutor.execute("/init.sql");
            } catch (Exception ignored) {

            }
        });

        clearButton.setOnAction(actionEvent -> {
            try {
                ScriptExecutor.execute("/truncate.sql");
            } catch (Exception ignored) {

            }
            createConfirmWindow();
            if (confirm) {
                Collections.clearAll();
            }
        });

        removeButton.setOnAction(actionEvent -> {
            ObservableList<Product> accountsSelected = table.getSelectionModel().getSelectedItems();
            if (accountsSelected.size() != 0) {
                ArrayList<Product> items = new ArrayList<>(table.getSelectionModel().getSelectedItems());
                List<Long> ids = new ArrayList<>();
                for (Product product : items) {
                    ids.add(product.getId());
                }
                createConfirmWindow();
                if (confirm) {
                    Updates.removeProducts(ids);
                    Collections.productsObservableList.removeAll(accountsSelected);
                    table.getSelectionModel().clearSelection();
                    Collections.productsList.removeAll(items);
                }
            }
        });

        resetButton.setOnAction(actionEvent -> {
            Collections.productsObservableList.clear();
            Collections.productsObservableList.addAll(Collections.productsList);
            shopCityNameSearchPredicateField.clear();
            shopCityNameSearchPredicateField.setDisable(true);
            costSearchPredicateField.clear();
            costSearchPredicateField.setDisable(true);
            shopCityNameSearchBtn.setSelected(false);
            costSearchBtn.setSelected(false);
        });

        shopCityNameSearchBtn.setOnAction(actionEvent -> {
            if (shopCityNameSearchBtn.isSelected()) {
                shopCityNameSearchPredicateField.setDisable(false);
                shopCityNameSearch = true;
            } else {
                shopCityNameSearchPredicateField.clear();
                shopCityNameSearchPredicateField.setDisable(true);
                shopCityNameSearch = false;
            }

        });

        costSearchBtn.setOnAction(actionEvent -> {
            if (costSearchBtn.isSelected()) {
                costSearchPredicateField.setDisable(false);
                costSearch = true;
            } else {
                costSearchPredicateField.clear();
                costSearchPredicateField.setDisable(true);
                costSearch = false;
            }
        });

        searchButton.setOnAction(actionEvent -> {
            if (Collections.productsObservableList.size() != 0) {

                if (!shopCityNameSearch && !costSearch) {
                    Warning.showWarnWithHeaderText("No criteria selected");
                } else {
                    ObservableList<Product> tempProductsObservableList = FXCollections.observableArrayList();
                    ObservableList<Product> tempProductsObservableList1 = FXCollections.observableArrayList();
                    ObservableList<Product> tempProductsObservableList2 = FXCollections.observableArrayList();

                    tempProductsObservableList.addAll(Collections.productsObservableList);
                    Collections.productsObservableList.clear();

                    if (shopCityNameSearch) {
                        for (Product product : tempProductsObservableList) {
                            if (product.getAddresses() != null) {
                                String[] addresses = product.getAddresses().split("\n");
                                for (String address : addresses) {
                                    String[] addr = address.split(",");
                                    if (shopCityNameSearchPredicateField.getText().trim().equalsIgnoreCase(addr[0].trim())) {
                                        tempProductsObservableList1.add(product);
                                        break;
                                    }
                                }
                            }
                        }

                        if (costSearch) {
                            costSearchFilter(tempProductsObservableList1, tempProductsObservableList2);

                            tempProductsObservableList1.clear();
                            Collections.productsObservableList.addAll(tempProductsObservableList2);
                        } else {
                            Collections.productsObservableList.addAll(tempProductsObservableList1);
                        }

                    } else if (costSearch) {
                        costSearchFilter(tempProductsObservableList, tempProductsObservableList1);
                        tempProductsObservableList.clear();
                        Collections.productsObservableList.addAll(tempProductsObservableList1);
                        System.out.println(Collections.productsObservableList);
                    }
                }
            } else {
                Warning.showWarnWithHeaderText("Empty selection");
            }

        });


    }

    private void costSearchFilter(ObservableList<Product> tempProductsObservableList, ObservableList<Product> tempProductsObservableList1) {
        String[] arr = costSearchPredicateField.getText().split("-");
        Double start = Double.parseDouble(arr[0]);
        Double end = Double.parseDouble(arr[1]);
        tempProductsObservableList1.addAll(tempProductsObservableList.stream()
                .filter(e -> e.getCost() >= start && e.getCost() <= end)
                .collect(Collectors.toList()));
    }

    public static void createConfirmWindow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AppController.class.getResource("/confirm.fxml"));
        loadFXML(loader);
    }

    static void loadFXML(FXMLLoader loader) {
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.showAndWait();
    }


}