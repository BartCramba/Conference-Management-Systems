package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sample.domain.Edition;
import sample.repository.EditionRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListenerController implements Initializable {

    private static final String sessionFxmlFile = "/fxml/sessionsWindow.fxml";
    private static final String speakerFxmlFile = "/fxml/speakerWindow.fxml";
    private static final String callForPapersFile = "/fxml/callForPapersWindow.fxml";

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
    EntityManager em = emf.createEntityManager();
    EditionRepositoryImpl repo = new EditionRepositoryImpl(em);

    @FXML
    private Button viewSessionsButton;

    @FXML
    private Button joinSpeakerButton;

    @FXML
    private Button callForPapersButton;

    @FXML
    private TextArea textBoxInformationEdition;

    @FXML
    void handleViewSessionsButton(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(sessionFxmlFile));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleJoinSpeakerButton(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(speakerFxmlFile));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleCallForPapersButton(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(callForPapersFile));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<Edition> edition = em.createNamedQuery(Edition.EDITION, Edition.class)
                .getResultList();

        Edition ed = edition.get(0);

        this.textBoxInformationEdition.appendText(ed.toString());
    }
}
