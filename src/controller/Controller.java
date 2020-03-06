package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import modele.*;
import dao.*;

public class Controller {
    @FXML
    private TextField usernameTF;
    @FXML
    private PasswordField passwordTF;

    public void hundleButtonB(ActionEvent actionEvent) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class).buildSessionFactory();
        UserDao userDao = new UserDaoImpl(sessionFactory);
        Alert alert = new Alert(Alert.AlertType.NONE);
        User tempUser =  userDao.readByUsername(usernameTF.getText());

        if (tempUser != null) {
            if(passwordTF.getText().equals(tempUser.getPassword())){
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setContentText("you are logged in");
                alert.show();
            } else {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("incorrect password or username");
                alert.show();
            }
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("incorrect password or username");
            alert.show();
        }
    }
}
