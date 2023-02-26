package lk.groceryShop.controller;

import com.jfoenix.controls.JFXButton;
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
import lk.groceryShop.service.ServiceFactory;
import lk.groceryShop.service.custom.CustomerService;
import lk.groceryShop.service.util.ServiceType;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
            boolean save = customerService.save(new CustomerDto(
                    txtId.getText(),
                    txtName.getText(),
                    txtAddress.getText(),
                    Date.valueOf(LocalDate.now()),
                    Double.parseDouble(txtSalary.getText())));
            new Alert(Alert.AlertType.INFORMATION, save ? "Added" : "Error").showAndWait();
            clearAll();
        }else new Alert(Alert.AlertType.ERROR,"Error: Invalid Data Entry!").show();
    }

    private void clearAll() {
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtSalary.clear();
    }

    private boolean validateAll() {
        if (Pattern.compile("^[a-zA-Z][0-9]{3,}$").matcher(txtId.getText()).matches()) {
            System.out.println("id");
            if (Pattern.compile("^[a-zA-Z]{3,}$").matcher(txtName.getText()).matches()) {
                System.out.println("name");
                if (Pattern.compile("^[a-zA-Z]{3,}$").matcher(txtAddress.getText()).matches()) {
                    System.out.println("address");
                    return  Pattern.compile("^[0-9]+\\.?[0-9]*$").matcher(txtSalary.getText()).matches();
                }
            }
        }
        return false;
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if(tblCustomers.getSelectionModel().getSelectedItem() != null){
            customerService.delete(tblCustomers.getSelectionModel().getSelectedItem().getId());
            new Alert(Alert.AlertType.INFORMATION,"Item successfully Deleted").showAndWait();
            refreshTable();
        }
    }

    private void refreshTable() {
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
        customerService = ServiceFactory.getInstance().getService(ServiceType.CUSTOMER);

        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
    }
}
