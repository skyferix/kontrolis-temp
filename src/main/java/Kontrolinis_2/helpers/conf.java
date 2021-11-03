package Kontrolinis_2.helpers;

import Kontrolinis_2.hibernateControllers.EmployeeHibControl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class conf {
    //Entity manager
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CourseSystemMng");
    public static EmployeeHibControl employeeHibControl = new EmployeeHibControl(entityManagerFactory);
}
