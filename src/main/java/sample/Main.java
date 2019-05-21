package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.*;
import sample.domain.User;
import sample.repository.UserRepositoryImpl;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.util.List;
import java.util.Map;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/loginWindow.fxml"));
        primaryStage.setTitle("Login Window");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
        EntityManager em = emf.createEntityManager();
        UserRepositoryImpl repo = new UserRepositoryImpl(em);
        User u = new User("firstName", "lastName", "email", "12345678", User.UserRole.chair);
        System.out.println(repo.save(u));
        System.out.println("asads");


        launch(args); }
}
