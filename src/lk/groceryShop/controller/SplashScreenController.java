package lk.groceryShop.controller;

import javafx.animation.KeyFrame;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class SplashScreenController implements Initializable {
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
        KeyFrame keyFrame1= new KeyFrame(Duration.millis(500),actionEvent ->{
            lblLoading.setText("Initializing Application....");
            rctLoading.setWidth(rctContainer.getWidth()*0.1);
        });

        KeyFrame keyFrame2= new KeyFrame(Duration.millis(1000),actionEvent ->{
            lblLoading.setText("Loading Internal Resources....");
            rctLoading.setWidth(rctContainer.getWidth()*0.2);
        });
        KeyFrame keyFrame3= new KeyFrame(Duration.millis(1500),actionEvent ->{
            lblLoading.setText("Loading Images....");
            rctLoading.setWidth(rctContainer.getWidth()*0.3);
        });
        KeyFrame keyFrame4= new KeyFrame(Duration.millis(2000),actionEvent ->{
            lblLoading.setText("Loading UIs....");
            rctLoading.setWidth(rctContainer.getWidth()*0.4);
        });
        KeyFrame keyFrame5= new KeyFrame(Duration.millis(2500),actionEvent ->{
            lblLoading.setText("Welcome to Students Management System v1.0.0");
            rctLoading.setWidth(rctContainer.getWidth()*0.6);
        });
        KeyFrame keyFrame6= new KeyFrame(Duration.millis(3000),actionEvent ->{
            rctLoading.setWidth(rctContainer.getWidth()*0.8);
        });
        KeyFrame keyFrame7= new KeyFrame(Duration.millis(3500),actionEvent ->{
            rctLoading.setWidth(rctContainer.getWidth());
        });
        KeyFrame keyFrame8= new KeyFrame(Duration.millis(4000),actionEvent ->{
            btn.setVisible(true);
        });
        timeline.getKeyFrames().addAll(keyFrame1,keyFrame2,keyFrame3,keyFrame4,keyFrame5,keyFrame6,keyFrame7,keyFrame8);
        timeline.playFromStart();
    }
}
