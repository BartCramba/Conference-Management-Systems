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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import sample.domain.Proposal;
import sample.domain.Topic;
import sample.domain.User;
import sample.repository.ProposalRepositoryImpl;
import sample.repository.UserRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class SpeakerController implements Initializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
    EntityManager em = emf.createEntityManager();
    UserRepositoryImpl repo_user= new UserRepositoryImpl(em);
    ProposalRepositoryImpl repo = new ProposalRepositoryImpl(em);

    @FXML
    private Button submitProposalButton;

    @FXML
    private TextField email;

    @FXML
    private TextField proposalName;

    @FXML
    private TextField keywords;

    @FXML
    private TextField topics;

    @FXML
    private TextField descr;

    @FXML
    private DatePicker created;

    @FXML
    private TextField authors;

    public void handleSubmitProposalButton(ActionEvent actionEvent) {

        User user = repo_user.getByEmail(email.getText());

        Proposal p = new Proposal();

        p.setDescription(descr.getText());
        p.setCreated(created.getValue());
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
        p.setUser(user);

        System.out.println(p);

        repo.save(p);


        if(user.getRole() == User.UserRole.listener)
        {
            user.setRole(User.UserRole.author);
            repo_user.updateRole(User.UserRole.author, email.getText());
            System.out.println("you became author" + user.toString());
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("SUCCESS");
        alert.setContentText("Paper submitted!");
        alert.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
