package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;
import sample.domain.User;
import sample.repository.UserRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LoginController implements Initializable {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
    EntityManager em = emf.createEntityManager();
    UserRepositoryImpl repo= new UserRepositoryImpl(em);

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;

    @FXML
    private javafx.scene.control.Button loginButton;

    @FXML
    private Button createAccountButton;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    void handleLoginButton(ActionEvent event) {

        String fxmlFile = null;

        User resultUser = repo.getByUsername(email.getText(),password.getText());

        if (resultUser == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid user.");
            alert.setContentText("Please choose a user from the choice box.");
            alert.show();
        }
        else
        {
            switch (choiceBox.getValue()) {
                case "Session Chair":
                    if(resultUser.getRole().toString().equals("ROLE_CHAIR")){
                        fxmlFile = "/fxml/sessionChairWindow.fxml";
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Invalid role.");
                        alert.setContentText("Please choose a corresponding role.");
                        alert.show();
                    }
                    break;
                case "Author":
                    if(resultUser.getRole().toString().equals("ROLE_AUTHOR")){
                        fxmlFile = "/fxml/authorWindow.fxml";
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Invalid role.");
                        alert.setContentText("Please choose a corresponding role.");
                        alert.show();
                    }

                    break;
                case "Listener":
                    if(resultUser.getRole().toString().equals("ROLE_LISTENER")){
                        fxmlFile = "/fxml/listenerWindow.fxml";
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Invalid role.");
                        alert.setContentText("Please choose a corresponding role.");
                        alert.show();
                    }
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


            stage = (Stage) loginButton.getScene().getWindow();
            stage.close();


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
