package uebung4.Util;


import uebung4.Modell.Entities.Employee;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getID()-o2.getID();
    }
}
