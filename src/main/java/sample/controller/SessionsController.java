package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.domain.Session;
import sample.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class SessionsController implements Initializable {

    private static final String fxmlFile = "/fxml/paymentWindow.fxml";
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
    EntityManager em = emf.createEntityManager();

    @FXML
    TextArea sessionBox1;
    @FXML
    TextArea sessionBox2;
    @FXML
    TextArea sessionBox3;
    @FXML
    TextArea sessionBox4;
    @FXML
    TextArea sessionBox5;
    @FXML
    TextArea sessionBox6;

    @FXML
    private Button applyButton;

    @FXML
    void handleApplyButton(ActionEvent event) {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Session> sessionList = em.createNamedQuery(Session.SESSIONS_ALL, Session.class)
                .getResultList();

        List<User> speakers = em.createNamedQuery(User.ALL_SPEAKERS, User.class)
                .getResultList();

        for (int i = 0; i < sessionList.size(); i++ )
        {
            Session s = sessionList.get(i);
            User speaker = speakers.get(i);

            this.pune(i, s, speaker);
        }
    }

    public void pune(int i, Session s, User speaker){

        String result = String.format("%s \n %s %s ", s.toString(),
                speaker.getFirstName(), speaker.getLastName());

        if (i==0)
            this.sessionBox1.appendText(result);
        else if (i==1)
            this.sessionBox2.appendText(result);
        else if (i==2)
            this.sessionBox3.appendText(result);
        else if (i==3)
            this.sessionBox4.appendText(result);
        else if (i==4)
            this.sessionBox5.appendText(result);
        else if (i==5)
            this.sessionBox6.appendText(result);
    }

}
