package uebung4.Modell.Entities;

import java.io.Serializable;
import java.util.HashMap;

public interface Employee {
    int getID();
    String getFirstName();
    String getLastName();
    String getRole();
    void setDepartment(String department);
    String getDepartment();
    HashMap<String,Expertise.ExpLevevel> getExpertise();
    void setExpertise(String expert, int level) throws EmployeeException;
    String printExpertise();
    String toString();
}
