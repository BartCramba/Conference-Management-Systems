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
import sample.domain.Session;
import sample.domain.User;
import sample.repository.EditionRepositoryImpl;
import sample.repository.SessionRepositoryImpl;
import sample.repository.UserRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateSectionsController implements Initializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
    EntityManager em = emf.createEntityManager();
    SessionRepositoryImpl repo = new SessionRepositoryImpl(em);

    UserRepositoryImpl repo1= new UserRepositoryImpl(em);

    @FXML
    private TextField email;
    @FXML
    private TextField sessionName;
    @FXML
    private TextField sessionRoom;

    @FXML
    private Button nextButton;

    public void handleNextButton(ActionEvent actionEvent){
        Session newSection = new Session();

        newSection.setRoom(sessionRoom.getText());
        newSection.setName(sessionName.getText());

        String email1=email.getText();

        User u=repo1.getByUsername1(email1);
        newSection.setUser(u.getId());

        /////!!!!!!!!!!!!1QUERY SA IAU UN ID VALABIL DIN EDITIE

        newSection.setEdition(28);
        System.out.println(newSection);







        //validari

        Stage stage = (Stage) nextButton.getScene().getWindow();
        stage.close();

        repo.save(newSection);

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
