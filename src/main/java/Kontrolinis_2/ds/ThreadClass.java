package Kontrolinis_2.ds;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class ThreadClass implements Runnable{

    private AnchorPane anchor;
    private Employee employee;

    public ThreadClass(AnchorPane anchor, Employee employee) {
        this.anchor =anchor;
        this.employee = employee;
    }

    @Override
    public void run(){
        for(Node node: anchor.getChildren()){

        }
    }
}
