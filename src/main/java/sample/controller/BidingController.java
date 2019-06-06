package sample.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.domain.*;
import sample.repository.ProposalRepositoryImpl;
import sample.repository.ProposalStatusRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class BidingController implements Initializable {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
    EntityManager em = emf.createEntityManager();
    ProposalStatusRepositoryImpl repo1= new ProposalStatusRepositoryImpl(em);
    ProposalRepositoryImpl repo= new ProposalRepositoryImpl(em);
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Button yes;
    @FXML
    private Button no;
    @FXML
    private TextArea description;

    Proposal currentProposal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Random rand = new Random();
        List<Proposal> bidings = repo.findBidings();
        int n = rand.nextInt(bidings.size());
        this.currentProposal= bidings.get(n);
        description.setText(currentProposal.toString());

        choiceBox.getItems().addAll(
                "strongAccept",
                "accept",
                "weekAccept",
                "weekReject",
                "borderlinePaper",
                "reject",
                "strongReject"
        );

    }


    public void handleYesButton(ActionEvent actionEvent) {
        ProposalStatus proposalStatus = new ProposalStatus();
        proposalStatus.setProposal(currentProposal);
        proposalStatus.setStatus(ProposalStatus.proposalStatus.valueOf(choiceBox.getValue()));
        repo1.save(proposalStatus);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("SUCCESS.");
        alert.show();

        Stage stage = (Stage) yes.getScene().getWindow();
        stage.close();
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/sessionChairWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            stage = new Stage();

            stage.setScene(new Scene(root1));
            stage.show();

            stage = (Stage) yes.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleNoButton(ActionEvent actionEvent) {
        Stage stage = (Stage) no.getScene().getWindow();
        stage.close();
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/sessionChairWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            stage = new Stage();

            stage.setScene(new Scene(root1));
            stage.show();

            stage = (Stage) no.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
