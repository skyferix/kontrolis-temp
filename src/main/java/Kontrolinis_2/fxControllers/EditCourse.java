package Kontrolinis_2.fxControllers;

import Kontrolinis_2.helpers.conf;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EditCourse {

    @FXML
    public TextField title;
    @FXML
    public DatePicker startDate;
    @FXML
    public DatePicker endDate;
    @FXML
    public TextField description;
    @FXML
    public ListView<String> moderators;
    @FXML
    public AnchorPane myCourseDetails;

    public void goBack(ActionEvent event){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("courses.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void submit(ActionEvent event){
        String sTitle = title.getText();
        LocalDate sStartDate = startDate.getValue();
        LocalDate sEndDate = endDate.getValue();
        String sDescription = description.getText();
    }

    private void showAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning");
        alert.setHeaderText("Not all field ar filled in!");
        alert.showAndWait();
    }
}
