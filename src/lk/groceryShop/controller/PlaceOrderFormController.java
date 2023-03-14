package lk.groceryShop.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.groceryShop.dto.CustomerDto;
import lk.groceryShop.dto.ItemDto;
import lk.groceryShop.dto.OrderDto;
import lk.groceryShop.entity.Customer;
import lk.groceryShop.entity.Item;
import lk.groceryShop.entity.Orders;
import lk.groceryShop.service.ServiceFactory;
import lk.groceryShop.service.custom.CustomerService;
import lk.groceryShop.service.custom.ItemService;
import lk.groceryShop.service.custom.OrderService;
import lk.groceryShop.service.util.ServiceType;
import lk.groceryShop.to.ItemTO;
import lk.groceryShop.util.Navigation;
import lk.groceryShop.util.NavigationType;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class PlaceOrderFormController implements Initializable {

    public Label txtDate;
    public TableColumn<ItemTO, Double> colTotalPrice;
    public AnchorPane pane;
    @FXML
    private ComboBox<String> cmbCustomerID;

    @FXML
    private TableView<ItemTO> tblCart;

    @FXML
    private TableColumn<ItemTO, String> colId;

    @FXML
    private TableColumn<ItemTO, String> colDescription;

    @FXML
    private TableColumn<ItemTO, Integer> colQty;

    @FXML
    private TableColumn<ItemTO, Double> colPrice;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private ComboBox<String> cmbItemId;

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

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        if (cmbCustomerID.getSelectionModel().getSelectedItem() != null && cmbItemId.getSelectionModel().getSelectedItem() != null && checkPattern() && checkQuntity()) {

            ItemTO to = new ItemTO();
            to.setItemId(cmbItemId.getSelectionModel().getSelectedItem());
            to.setDescription(txtDescription.getText());
            to.setQtyOnHand(Integer.parseInt(txtQty.getText()));
            to.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));
            to.setTotal(Double.parseDouble(txtQty.getText()) * Double.parseDouble(txtUnitPrice.getText()));
//            System.out.println(to.getTotal());

            addItemToCart(to);
        }
    }

    private void addItemToCart(ItemTO to) {
        ObservableList<ItemTO> toList = FXCollections.observableArrayList();
        if (!(tblCart.getItems() == null)) {
            toList = tblCart.getItems();
            for (int i = 0; i < toList.size(); i++) {
                ItemTO itemTO = toList.get(i);
                if (itemTO.getItemId().equals(cmbItemId.getSelectionModel().getSelectedItem())) {

                    double total = itemTO.getTotal();
                    total += to.getTotal();

                    int qtyOnHand = itemTO.getQtyOnHand();
                    qtyOnHand += to.getQtyOnHand();

                    to.setQtyOnHand(qtyOnHand);
                    to.setTotal(total);
                    toList.remove(i);
                }
            }
        }
        toList.add(to);
        tblCart.setItems(toList);
        setTotal(toList);
    }

    private void setTotal(ObservableList<ItemTO> toList) {
        Double total = 0.00;
        for (ItemTO ele : toList) {
            total += ele.getTotal();
        }
        lblTotal.setText(String.valueOf(total));
    }

    private boolean checkQuntity() {
        return Integer.parseInt(txtQty.getText()) > 0;
    }

    private boolean checkPattern() {
        if (Pattern.compile("^[0-9]*[1-9][0-9]*$").matcher(txtQty.getText()).matches()) {
            return true;
        }
        new Alert(Alert.AlertType.ERROR, "enter quantity").show();
        return false;
    }


    @FXML
    void btnClearOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(pane, NavigationType.ORDER);
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) throws IOException {
        OrderDto order = new OrderDto();
        Customer customer = new Customer();
        customer.setName(txtCustomerName.getText());
        customer.setId(cmbCustomerID.getSelectionModel().getSelectedItem());
        order.setCustomer(customer);

        ObservableList<ItemTO> items = tblCart.getItems();

        for (ItemTO ele : items) order.getItemList().add(new Item(ele.getItemId(), ele.getDescription(), ele.getUnitPrice(), ele.getQtyOnHand()));


        orderService.save(order);
        new Alert(Alert.AlertType.INFORMATION, "Order Added!").show();
        Navigation.navigate(pane, NavigationType.ORDER);

    }

    @FXML
    void btnRemoveFromCartOnAction(ActionEvent event) {
        if (tblCart.getSelectionModel().getSelectedItem() != null) {
            ObservableList<ItemTO> toList = tblCart.getItems();
            toList.remove(tblCart.getSelectionModel().getSelectedItem());
            tblCart.setItems(toList);
            setTotal(toList);
        }
        btnRemoveFromCart.setDisable(true);
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
        txtDate.setText(String.valueOf(Date.valueOf(LocalDate.now())));
        customerService = ServiceFactory.getInstance().getService(ServiceType.CUSTOMER);
        itemService = ServiceFactory.getInstance().getService(ServiceType.ITEM);
        orderService = ServiceFactory.getInstance().getService(ServiceType.ORDER);

        colId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colTotalPrice.setCellValueFactory(new PropertyValueFactory<>("total"));

        setCustomerIdList();
        setItemIdList();

        btnRemoveFromCart.setDisable(true);
    }

    private void setItemIdList() {
        try {
            List<ItemDto> itemDtoList = itemService.loadItemList();
            ObservableList<String> itemCodeList = FXCollections.observableArrayList();
            for (ItemDto itemDto : itemDtoList) itemCodeList.add(itemDto.getItemId());
            cmbItemId.setItems(itemCodeList);
        } catch (RuntimeException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void setCustomerIdList() {
        try {
            List<CustomerDto> customerDtos = customerService.loadCustomers();
            ObservableList<String> idList = FXCollections.observableArrayList();
            for (CustomerDto customer : customerDtos) idList.add(customer.getId());
            cmbCustomerID.setItems(idList);
        } catch (RuntimeException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void cmbCustomerListOnAction(ActionEvent actionEvent) {
        String selectedItem = cmbCustomerID.getSelectionModel().getSelectedItem();
        CustomerDto view = customerService.view(selectedItem);
        txtCustomerName.setText(view.getName());
    }

    public void cmbItemIdOnAction(ActionEvent actionEvent) {
        String selectedItem = cmbItemId.getSelectionModel().getSelectedItem();
        ItemDto view = itemService.view(selectedItem);

        txtDescription.setText(view.getDescription());
        txtQtyOnHand.setText(String.valueOf(view.getQtyOnHand()));
        txtUnitPrice.setText(String.valueOf(view.getUnitPrice()));
    }

    public void tblCartOnMouseClicked(MouseEvent mouseEvent) {
        if (tblCart.getSelectionModel().getSelectedItem() != null) {
            btnRemoveFromCart.setDisable(false);
        }
    }
}
