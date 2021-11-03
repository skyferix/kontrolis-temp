package Kontrolinis_2.fxControllers;

import Kontrolinis_2.HelloApplication;
import Kontrolinis_2.ds.Employee;
import Kontrolinis_2.ds.SleepService;
import Kontrolinis_2.ds.Temp;
import Kontrolinis_2.ds.ThreadClass;
import Kontrolinis_2.helpers.conf;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class EmployeeC implements Initializable {

    @FXML
    public TextField name;
    @FXML
    public TextField surname;
    @FXML
    public CheckBox monday;
    @FXML
    public CheckBox tuesday;
    @FXML
    public CheckBox wednesday;
    @FXML
    public CheckBox thursday;
    @FXML
    public CheckBox friday;
    @FXML
    public CheckBox saturday;
    @FXML
    public CheckBox sunday;
    @FXML
    public ListView<Temp> listView;
    @FXML
    public AnchorPane anchor;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Employee> employees = conf.employeeHibControl.getAllEmployee();
        listView.setCellFactory(lv -> new ListCell<Temp>(){
            @Override
            protected void updateItem(Temp item, boolean empty){
                super.updateItem(item,empty);
                setText(empty || item==null? "": item.getName());
            }
        });
        for (Employee employee: employees) {
            listView.getItems().add(new Temp(employee.getId(),employee.getName() + ' ' + employee.getSurName()));
        }
    }

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

    public void add(ActionEvent event){
        Employee employee = new Employee(
               name.getText(),
               surname.getText(),
               monday.isSelected(),
               tuesday.isSelected(),
               wednesday.isSelected(),
               thursday.isSelected(),
               friday.isSelected(),
                saturday.isSelected(),
                sunday.isSelected()
        );
        conf.employeeHibControl.create(employee);
        reload(event);
    }

    public void edit(ActionEvent event){
        Integer id = listView.getSelectionModel().getSelectedItem().id;
        Employee employee = new Employee(
                name.getText(),
                surname.getText(),
                monday.isSelected(),
                tuesday.isSelected(),
                wednesday.isSelected(),
                thursday.isSelected(),
                friday.isSelected(),
                saturday.isSelected(),
                sunday.isSelected()
        );
        employee.setId(id);
        conf.employeeHibControl.edit(employee);
        reload(event);
    }

    public void load() throws InterruptedException {
        if(!listView.getSelectionModel().getSelectedItems().isEmpty()){
            Integer id = listView.getSelectionModel().getSelectedItem().id;
            Employee employee = conf.employeeHibControl.getEmployeeById(id);
//            ThreadClass threadClass = new ThreadClass(anchor, employee);
//            Thread thread = new Thread(threadClass);
//            thread.start();
            int x=0;
            new SleepService(name, employee.getName(),x+=1000).start();
            new SleepService(surname, employee.getSurName(), x+=1000).start();
            new SleepService(monday, employee.isMonday(), x+=1000).start();
            new SleepService(tuesday, employee.isTuesday(),x+=1000).start();
            new SleepService(wednesday, employee.isWednesday(),x+=1000).start();
            new SleepService(thursday, employee.isThursday(),x+=1000).start();
            new SleepService(friday, employee.isFriday(),x+=1000).start();
            new SleepService(saturday, employee.isSaturday(),x+=1000).start();
            new SleepService(sunday, employee.isSunday(),x+=1000).start();
        }
    }

    private void reload(ActionEvent event)  {
        Parent root =null;
        try {
            root = FXMLLoader.load(getClass().getResource("/Kontrolinis_2/employee.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    public void submit(ActionEvent event){
//        String sTitle = title.getText();
//        LocalDate sStartDate = startDate.getValue();
//        LocalDate sEndDate = endDate.getValue();
//        String sDescription = description.getText(); showAlert();
//
//    }

    private void showAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning");
        alert.setHeaderText("Not all field ar filled in!");
        alert.showAndWait();
    }

    public void wait(int ms){
        try{
            Thread.sleep(ms);
        } catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}
