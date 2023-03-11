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
import javafx.scene.layout.AnchorPane;
import lk.groceryShop.dto.CustomerDto;
import lk.groceryShop.dto.ItemDto;
import lk.groceryShop.service.ServiceFactory;
import lk.groceryShop.service.custom.ItemService;
import lk.groceryShop.service.util.ServiceType;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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
    private TableColumn<?, ?> colUnitPrice;

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
            boolean save = itemService.save(new ItemDto(
                    txtId.getText(),
                    txtDescription.getText(),
                    Double.parseDouble(txtUnitPrice.getText()),
                    Integer.parseInt(txtQtyOnHand.getText())
            ));
            new Alert(Alert.AlertType.INFORMATION, save ? "Added" : "Error").showAndWait();
            clearAll();
        } else new Alert(Alert.AlertType.ERROR, "Error: Invalid Data Entry!").show();
    }

    private void clearAll() {
    }

    private boolean validateAll() { //regex
        return false;
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if(tblItem.getSelectionModel().getSelectedItem() != null){
            itemService.delete(tblItem.getSelectionModel().getSelectedItem().getItemId());
            new Alert(Alert.AlertType.INFORMATION,"Item successfully Deleted").showAndWait();
            refreshTable();
        }
    }

    private void refreshTable() {
        try{
            System.out.println("Refresh ");
            List<ItemDto> itemList = itemService.loadItemList();
            ObservableList<ItemDto> list = FXCollections.observableArrayList();
            list.addAll(itemList);
            tblItem.setItems(list);
        }catch (RuntimeException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

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
}
