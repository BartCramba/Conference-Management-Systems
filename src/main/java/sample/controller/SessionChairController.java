package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SessionChairController implements Initializable {

    private static final String sectionFxmlFile = "/fxml/CreateSectionsWindow.fxml";
    private static final String editionFxmlFile = "/fxml/editionWindow.fxml";
    private static final String bidFxmlFile = "/fxml/bidWindow.fxml";
    private static final String deadFxmlFile = "/fxml/changeDeadlines.fxml";


    @FXML
    private Button createEdition;

    @FXML
    private Button createSection;

    @FXML
    public Button change;

    @FXML
    private Button bid;

    @FXML
        void handleCreateEditionButton(ActionEvent event) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(editionFxmlFile));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();

                stage.setScene(new Scene(root1));
                stage.show();

                stage = (Stage) createEdition.getScene().getWindow();
                stage.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }


    @FXML
    void handleCreateSessionButton(ActionEvent event) {

        System.out.println("cplm");

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(sectionFxmlFile));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(root1));
            stage.show();

            stage = (Stage) createSection.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleDeadlinesButton(ActionEvent event) {



        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(deadFxmlFile));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(root1));
            stage.show();

            stage = (Stage) change.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void handleBidingButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(bidFxmlFile));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(root1));
            stage.show();

            stage = (Stage) bid.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
