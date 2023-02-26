package lk.groceryShop.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import lk.groceryShop.util.Navigation;
import lk.groceryShop.util.NavigationType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {

    @FXML
    private AnchorPane mainPanel;

    @FXML
    private AnchorPane sidePanel;

    @FXML
    private JFXButton btnCustomer;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private JFXButton btnItem;

    @FXML
    private JFXButton btnHome;

    @FXML
    private AnchorPane subPanel;

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(subPanel, NavigationType.CUSTOMER);
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {

    }

    @FXML
    void btnItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

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

    }
}
