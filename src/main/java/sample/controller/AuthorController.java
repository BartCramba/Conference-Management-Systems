package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.domain.Proposal;
import sample.domain.User;
import sample.repository.ProposalRepositoryImpl;
import sample.repository.UserRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AuthorController implements Initializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
    EntityManager em = emf.createEntityManager();
    UserRepositoryImpl repo_user= new UserRepositoryImpl(em);
    ProposalRepositoryImpl repo = new ProposalRepositoryImpl(em);

    @FXML
    private Label welcome;

    @FXML
    private TextField email;

    @FXML
    private Button getProposalsButton;

    @FXML
    private TextArea proposals;

    @FXML
    void handleGetProposalsButton(ActionEvent event) {
        User user = repo_user.getByEmail(email.getText());

        List<Proposal> p = repo.getByUser(user);

        Proposal pr = repo.getByUserOne(user);

        //proposals.setText(p.toString());

        proposals.setText("Name: " + pr.getName() + "\n"
         + "Keywords: " + pr.getKeywords().toString() + "\n" +
                "id: " + pr.getProposalId() + "\n");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
