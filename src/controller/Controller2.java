package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller2 {

    @FXML
    private Pane pane;

    public void hundleChangeB(ActionEvent actionEvent) throws IOException {

        VBox vBox = FXMLLoader.load(getClass().getResource("/views/interface1.fxml"));
        Scene scene = new Scene(vBox, 500, 400);

        Stage s1 = ((Stage)pane.getScene().getWindow());
        s1.setScene(scene);

    }
}
