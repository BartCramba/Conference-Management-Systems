package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import sample.domain.Edition;
import sample.repository.EditionRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.ResourceBundle;

public class ChangeDeadlineController implements Initializable {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
    EntityManager em = emf.createEntityManager();
    EditionRepositoryImpl repo = new EditionRepositoryImpl(em);

    @FXML
    private DatePicker endSubmissions;
    @FXML
    private DatePicker endBidding;
    @FXML
    private DatePicker endReview;
    @FXML
    private Button update;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleUpdateButton(ActionEvent actionEvent){
        Edition before = repo.findById(58);
        before.setEndBidding(endBidding.getValue());
        before.setEndReview(endReview.getValue());
        before.setEndSubmissions(endSubmissions.getValue());
        try{
            em.getTransaction().begin();
            em.merge(before);
            em.getTransaction().commit();
        }finally{
            if (em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        Stage stage = (Stage) update.getScene().getWindow();
        stage.close();

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/sessionChairWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            stage = new Stage();

            stage.setScene(new Scene(root1));
            stage.show();

            stage = (Stage) update.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
