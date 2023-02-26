package lk.groceryShop.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.groceryShop.service.custom.CustomerService;
import lk.groceryShop.service.custom.ItemService;
import lk.groceryShop.service.custom.OrderDetailService;
import lk.groceryShop.service.custom.OrderService;

import java.net.URL;
import java.util.ResourceBundle;

public class PlaceOrderFormController implements Initializable {

    @FXML
    private ComboBox<?> cmbCustomerID;

    @FXML
    private TableView<?> tblCart;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private ComboBox<?> cmbItemId;

    @FXML
    private JFXButton btnAddToCart;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private Label lblTotal;

    @FXML
    private JFXButton btnRemoveFromCart;
    private CustomerService customerService;
    private ItemService itemService;
    private OrderService orderService;
    private OrderDetailService orderDetailService;

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnRemoveFromCartOnAction(ActionEvent event) {

    }

    @FXML
    void tblCartOnAction(SortEvent<TableView<?>> event) {

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

        colId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
    }
}
