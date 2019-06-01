package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.domain.User;
import sample.repository.UserRepositoryImpl;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.net.URL;
import java.util.ResourceBundle;



public class CreateAccountController implements Initializable {
    final String CHAIR_PASS = "1234";
    final String ADMIN_PASS = "admin";
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
    EntityManager em = emf.createEntityManager();
    UserRepositoryImpl repo = new UserRepositoryImpl(em);



    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField password;

    @FXML
    private Button nextButton;

    @FXML
    private ChoiceBox choiceBox;

    public void handleNextButton(ActionEvent actionEvent){
    User newUser = new User();
        newUser.setFirstName(firstName.getText());
        newUser.setLastName(lastName.getText());
        newUser.setEmail(email.getText());
        newUser.setPasssword(password.getText());
        System.out.println(newUser);
        if (newUser.getPasssword().equals(CHAIR_PASS))
            newUser.setRole(User.UserRole.chair);
        else if (newUser.getPasssword().equals(ADMIN_PASS))
            newUser.setRole(User.UserRole.superAdmin);
        else
            newUser.setRole(User.UserRole.listener);

        //validari

            Stage stage = (Stage) nextButton.getScene().getWindow();
            stage.close();

        repo.save(newUser);

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loginWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            stage = new Stage();

            stage.setScene(new Scene(root1));
            stage.show();

            stage = (Stage) nextButton.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    @FXML
    void handleCreateButton(ActionEvent event) {



    }
}
