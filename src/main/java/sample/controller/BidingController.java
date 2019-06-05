package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import sample.domain.Edition;
import sample.domain.Proposal;
import sample.domain.Topic;
import sample.domain.User;
import sample.repository.PaymentRepositoryImpl;
import sample.repository.UserRepositoryImpl;

import javax.jws.soap.SOAPBinding;
import javax.management.relation.Role;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BidingController implements Initializable {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
    EntityManager em = emf.createEntityManager();
    UserRepositoryImpl repo= new UserRepositoryImpl(em);

    @FXML
    public TableView<User> table;
    @FXML
    private Button yes;
    @FXML
    private Button no;

    public TableColumn<Proposal,String> proposalName;
    public TextField textfieldName;

    List<Topic> topicList = new ArrayList<>();
    ObservableList<User> data;

    public TableColumn<String,String> firstName;
    public TableColumn<User,String> colName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        //proposalName.setCellValueFactory(new PropertyValueFactory<>("ProposalName"));
//        table.setItems(observableList);
//        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//        table.getSelectionModel().setCellSelectionEnabled(true);
        data = FXCollections.observableArrayList();
        User res= repo.getByUsername1("chair");
        System.out.println(res.getFirstName());
        data.add(repo.getByUsername1("chair"));
        table.getItems().addAll(data);

    }
    public void clickedColumn(MouseEvent event) {
//        TablePosition tablePosition=table.getSelectionModel().getSelectedCells().get(0);
//        int row=tablePosition.getRow();
//        Proposal item=table.getItems().get(row);
//        TableColumn tableColumn=tablePosition.getTableColumn();
//        //String data= (String) tableColumn.getCellObservableValue(item).getValue();
//        System.out.println(tableColumn.getCellObservableValue(item));
    }

}
