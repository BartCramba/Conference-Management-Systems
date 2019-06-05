package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.domain.Edition;
import sample.domain.User;
import sample.repository.EditionRepositoryImpl;
import sample.repository.UserRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateEditionController implements Initializable  {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
    EntityManager em = emf.createEntityManager();
    EditionRepositoryImpl repo = new EditionRepositoryImpl(em);

    UserRepositoryImpl repo1= new UserRepositoryImpl(em);

    @FXML
    private TextField email;
    @FXML
    private DatePicker beginDate;
    @FXML
    private DatePicker endDate;
    @FXML
    private DatePicker beginSubmissions;
    @FXML
    private DatePicker endSubmissions;
    @FXML
    private DatePicker endBidding;
    @FXML
    private TextField editionName;
    @FXML
    private DatePicker endReview;

    @FXML
    private Button nextButton;

    public void handleNextButton(ActionEvent actionEvent){
        Edition newEd = new Edition();
        newEd.setBeginDate(beginDate.getValue());
        newEd.setEndDate(endDate.getValue());
        newEd.setBeginSubmissions(beginSubmissions.getValue());
        newEd.setEndSubmissions(endSubmissions.getValue());
        newEd.setEndBidding(endBidding.getValue());
        newEd.setEndReview(endReview.getValue());
        newEd.setName(editionName.getText());

        String email1=email.getText();

        User u=repo1.getByUsername1(email1);
        System.out.println(u.getId());



        //validari

        Stage stage = (Stage) nextButton.getScene().getWindow();
        stage.close();

        repo.save(newEd);

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/sessionChairWindow.fxml"));
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
}
