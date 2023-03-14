package lk.groceryShop.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.groceryShop.dto.ItemDto;
import lk.groceryShop.service.ServiceFactory;
import lk.groceryShop.service.custom.ItemService;
import lk.groceryShop.service.util.ServiceType;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class ManageItemFormController implements Initializable {

    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<ItemDto> tblItem;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colQtyOnHand;

    @FXML
    private TableColumn<ItemDto, Double> colUnitPrice;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    private TextField txtId;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnUpdate1;
    private ItemService itemService;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        if (validateAll()) {
            System.out.println("validation done");
            boolean save = itemService.save(new ItemDto(txtId.getText(), txtDescription.getText(), Double.parseDouble(txtUnitPrice.getText()), Integer.parseInt(txtQtyOnHand.getText())));
            new Alert(Alert.AlertType.INFORMATION, save ? "Added" : "error").showAndWait();
            clearAll();
            refreshTable();
        } else new Alert(Alert.AlertType.ERROR, "Error: Invalid Data Entry!").show();
    }

    private void clearAll() {
        txtId.clear();
        txtDescription.clear();
        txtQtyOnHand.clear();
        txtUnitPrice.clear();
    }

    private boolean validateAll() { //regex
        System.out.println("Validate");
        return (
                Pattern.compile("^[a-zA-Z][0-9]{3,}$").matcher(txtId.getText()).matches()
                        && Pattern.compile("^[a-zA-Z0-9_\\-.,'&() ]{1,50}$").matcher(txtDescription.getText()).matches()
                        && Pattern.compile("^\\d+$").matcher(txtQtyOnHand.getText()).matches()
                        && Pattern.compile("^[0-9]+\\.?[0-9]*$").matcher(txtUnitPrice.getText()).matches());
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (tblItem.getSelectionModel().getSelectedItem() != null) {
            itemService.delete(tblItem.getSelectionModel().getSelectedItem().getItemId());
            new Alert(Alert.AlertType.INFORMATION, "Item successfully Deleted").show();
            refreshTable();
            clearAll();
        }
    }

    private void refreshTable() {
        try {
            List<ItemDto> itemList = itemService.loadItemList();
            ObservableList<ItemDto> list = FXCollections.observableArrayList();
            list.addAll(itemList);
            tblItem.setItems(list);
        } catch (RuntimeException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (tblItem.getSelectionModel().getSelectedItem() != null) {
            if (validateAll()) {
                boolean save = itemService.update(new ItemDto(txtId.getText(), txtDescription.getText(), Double.parseDouble(txtUnitPrice.getText()), Integer.parseInt(txtQtyOnHand.getText())));
                new Alert(Alert.AlertType.INFORMATION, save ? "Item Updated" : "Error").show();
                clearAll();
                refreshTable();
            }
        }
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemService = ServiceFactory.getInstance().getService(ServiceType.ITEM);

        colCode.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        refreshTable();
    }

    public void tblItemOnMouseClicked(MouseEvent mouseEvent) {
        ItemDto selectedItem = tblItem.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {

            btnDelete.setDisable(false);
            btnUpdate.setDisable(false);

            txtId.setText(selectedItem.getItemId());
            txtDescription.setText(selectedItem.getDescription());
            txtQtyOnHand.setText(String.valueOf(selectedItem.getQtyOnHand()));
            txtUnitPrice.setText(String.valueOf(selectedItem.getUnitPrice()));

        }
    }
}
