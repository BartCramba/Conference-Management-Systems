package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.domain.Payment;
import sample.domain.User;
import sample.repository.PaymentRepositoryImpl;
import sample.repository.UserRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {
    @FXML
    private TextField Email;

    @FXML
    private TextField cardNumber;

    @FXML
    private Button submitButton;

    LoginController lc = new LoginController();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
    EntityManager em = emf.createEntityManager();
    PaymentRepositoryImpl repo= new PaymentRepositoryImpl(em);



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleSubmit(javafx.event.ActionEvent actionEvent) {
        Payment payment = new Payment();
        payment.setEmail(Email.getText());
        payment.setCardNumber(cardNumber.getText());
        repo.save(payment);
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("SUCCESS!");
        alert.setContentText("You can use your account now, please login!");
        alert.show();
    }
}
