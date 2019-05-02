package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

public class LoginController implements Initializable {

    @FXML
    private javafx.scene.control.Button loginButton;

    @FXML
    private Button createAccountButton;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    void handleLoginButton(ActionEvent event) {

        String user = choiceBox.getValue();
        String fxmlFile = null;

        if (user == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid user.");
            alert.setContentText("Please choose a user from the choice box.");
            alert.show();
        }
        else
        {
            switch (user) {
                case "Session Chair":
                    fxmlFile = "/fxml/sessionChairWindow.fxml";
                    break;
                case "Author":
                    fxmlFile = "/fxml/authorWindow.fxml";
                    break;
                case "Listener":
                    fxmlFile = "/fxml/listenerWindow.fxml";
                    break;
            }

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();

                stage.setScene(new Scene(root1));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void handleCreateAccountButton(ActionEvent event) {

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/createAccountWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceBox.getItems().addAll(
                "Session Chair",
                "Author",
                "Listener"
        );
    }
}
