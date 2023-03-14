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
import lk.groceryShop.dto.CustomerDto;
import lk.groceryShop.service.ServiceFactory;
import lk.groceryShop.service.custom.CustomerService;
import lk.groceryShop.service.util.ServiceType;
import lk.groceryShop.util.FactoryConfiguration;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class ManageCustomerFormController implements Initializable {

    @FXML
    public AnchorPane pane;
    public TextField txtId;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colSalary;
    public TableColumn colAddress;
    public TextField txtSearchId;
    @FXML
    private TableView<CustomerDto> tblCustomers;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtSalary;


    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnUpdate1;
    private CustomerService customerService;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        if (validateAll()) {
            boolean save = customerService.save(new CustomerDto(txtId.getText(), txtName.getText(), txtAddress.getText(), Date.valueOf(LocalDate.now()), Double.parseDouble(txtSalary.getText())));
            new Alert(Alert.AlertType.INFORMATION, save ? "Added" : "Error").show();
            refreshTable();
            clearAll();
        } else new Alert(Alert.AlertType.ERROR, "Error: Invalid Data Entry!").show();
    }

    private void clearAll() {
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtSalary.clear();
    }

    private boolean validateAll() {
        return Pattern.compile("^[a-zA-Z][0-9]{3,}$").matcher(txtId.getText()).matches() && Pattern.compile("^[a-zA-Z]{3,}$").matcher(txtName.getText()).matches() && Pattern.compile("^[a-zA-Z]{3,}$").matcher(txtAddress.getText()).matches() && Pattern.compile("^[0-9]+\\.?[0-9]*$").matcher(txtSalary.getText()).matches();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (tblCustomers.getSelectionModel().getSelectedItem() != null) {
            customerService.delete(tblCustomers.getSelectionModel().getSelectedItem().getId());
            new Alert(Alert.AlertType.INFORMATION, "Customer successfully Deleted").show();
            refreshTable();
            clearAll();
        }
    }

    private void refreshTable() {
        try {
            List<CustomerDto> customerDtos = customerService.loadCustomers();
            ObservableList<CustomerDto> list = FXCollections.observableArrayList();
            list.addAll(customerDtos);
            tblCustomers.setItems(list);
            btnDelete.setDisable(true);
            btnUpdate.setDisable(true);
        } catch (RuntimeException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (validateAll()) {
            boolean save = customerService.update(new CustomerDto(txtId.getText(), txtName.getText(), txtAddress.getText(), Date.valueOf(LocalDate.now()), Double.parseDouble(txtSalary.getText())));
            new Alert(Alert.AlertType.INFORMATION, save ? "Updated" : "Error").show();
            refreshTable();

            btnUpdate.setDisable(true);
            btnDelete.setDisable(true);
            clearAll();
        } else new Alert(Alert.AlertType.ERROR, "Error: Invalid Data Entry!").show();

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
        customerService = ServiceFactory.getInstance().getService(ServiceType.CUSTOMER);

        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);

        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        setCustomerId();
    }

    private void setCustomerId() {
        refreshTable();
    }

    public void tblCustomersOnMouseClicked(MouseEvent mouseEvent) {
        CustomerDto selectedCustomer = tblCustomers.getSelectionModel().getSelectedItem();

        if (selectedCustomer != null) {
            btnDelete.setDisable(false);
            btnUpdate.setDisable(false);

            txtId.setText(selectedCustomer.getId());
            txtName.setText(selectedCustomer.getName());
            txtAddress.setText(selectedCustomer.getAddress());
            txtSalary.setText(String.valueOf(selectedCustomer.getSalary()));

        }
    }

    public void searchIdOnAction(ActionEvent actionEvent) {
        if(Pattern.compile("^[a-zA-Z][0-9]{3,}$").matcher(txtSearchId.getText()).matches()){
           try{
               CustomerDto selectedCustomer = customerService.view(txtSearchId.getText());
               if (selectedCustomer != null) {
                   txtId.setText(selectedCustomer.getId());
                   txtName.setText(selectedCustomer.getName());
                   txtAddress.setText(selectedCustomer.getAddress());
                   txtSalary.setText(String.valueOf(selectedCustomer.getSalary()));
               }
           }catch(RuntimeException e){
                new Alert(Alert.AlertType.INFORMATION,e.getMessage()).show();
           }
        }else{
            new Alert(Alert.AlertType.ERROR,"Invalid data entry").show();
        }
    }

    public void txtSalaryOnMouseClicked(MouseEvent mouseEvent) {

    }

    public void txtAddressOnMouseClicked(MouseEvent mouseEvent) {
    }

    public void txtNameOnMouseClicked(MouseEvent mouseEvent) {

    }

    public void txtIdOnMouseClicked(MouseEvent mouseEvent) {

    }
}
