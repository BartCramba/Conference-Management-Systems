package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.domain.Proposal;
import sample.domain.User;
import sample.repository.ProposalRepositoryImpl;
import sample.repository.UserRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.*;
import java.io.File;
import java.io.IOException;
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
    private TextField statusProposal;

    @FXML
    private Button getProposalsButton;

    @FXML
    private TextArea proposals;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextArea proposalsArea;

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

    @FXML
    void handleCallForPapers(ActionEvent event) throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file dialog");

        fileChooser.showOpenDialog(null);

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);

        if ( file != null ) {
            Desktop desktop = Desktop.getDesktop();

            desktop.open(file);
        }

        proposalsArea.appendText(file.toString());

        statusProposal.appendText("Uploaded proposal");


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Stage stage = (Stage) anchorpane.getScene().getWindow();
    }
}
