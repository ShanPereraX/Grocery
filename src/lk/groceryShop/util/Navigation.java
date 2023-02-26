package lk.groceryShop.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane panel;

    public static void navigate(AnchorPane pane, NavigationType type) throws IOException {
        panel = pane;
        Stage stage = (Stage) panel.getScene().getWindow();
        panel.getChildren().clear();

        switch (type) {
            case CUSTOMER:
                stage.setTitle("Manage Customers");
                init("ManageCustomerForm.fxml");
                break;

            case ITEM:
                stage.setTitle("Manage Items ");
                init("ManageItemForm.fxml");
                break;

            case ORDER:
                stage.setTitle("Place Order");
                init("PlaceOrderForm.fxml");
                break;

            case HOME:
                stage.setTitle("Grocery Shop");
                init("MainForm.fxml");
                break;

            default:
                new Alert(Alert.AlertType.ERROR, "Ui not Implemented!").show();
        }
    }

    private static void init(String location) throws IOException {
        panel.getChildren().add(FXMLLoader.load(Navigation.class.getResource("../view/" + location)));
    }
}
