module com.example.coursesys {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.prefs;


    opens Kontrolinis_2 to javafx.fxml;
    exports Kontrolinis_2;

    opens Kontrolinis_2.ds to javafx.fxml, org.hibernate.orm.core, java.persistence;
    exports Kontrolinis_2.ds;
    exports Kontrolinis_2.fxControllers to javafx.fxml;
    opens Kontrolinis_2.fxControllers to javafx.fxml;
    exports Kontrolinis_2.helpers;
    opens Kontrolinis_2.helpers to javafx.fxml;
}