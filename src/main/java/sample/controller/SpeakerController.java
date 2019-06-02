package sample.controller;

import com.sun.deploy.util.StringUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import sample.domain.Proposal;
import sample.domain.Topic;
import sample.repository.ProposalRepositoryImpl;
import sample.repository.UserRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.*;

public class SpeakerController implements Initializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
    EntityManager em = emf.createEntityManager();
    ProposalRepositoryImpl repo = new ProposalRepositoryImpl(em);

    @FXML
    private Button submitProposalButton;

    @FXML
    private TextField proposalName;

    @FXML
    private TextField keywords;

    @FXML
    private TextField topics;

    @FXML
    private TextField authors;

    public void handleSubmitProposalButton(ActionEvent actionEvent) {
        Proposal p = new Proposal();

        p.setName(proposalName.getText());
        String[] k = keywords.getText().split(",");
        p.setKeywords(Arrays.asList(k));
        String[] t = topics.getText().split(",");

        List<Topic> l = new ArrayList<Topic>();
        for(String s : t) {
            Topic topic = new Topic();
            topic.setName(s);
            l.add(topic);
        }
        p.setTopics(l);

        System.out.println(p);

        repo.save(p);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("SUCCESS");
        alert.setContentText("Paper submitted!");
        alert.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
