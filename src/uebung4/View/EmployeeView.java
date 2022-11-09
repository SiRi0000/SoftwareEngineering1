package uebung4.View;



import uebung4.Modell.Container;
import uebung4.Modell.Entities.Employee;
import uebung4.Modell.Entities.EmployeeInstance;

import java.util.ArrayList;
import java.util.List;

public class EmployeeView {
    static List<Employee> list = new ArrayList<>();
    public static void main(String args[]){

        EmployeeView m = new EmployeeView();
        Employee m1 = new EmployeeInstance(1,"Siri","Senma","MA","Java", 1);
        Employee m2 = new EmployeeInstance(2,"Liam","Hess","MA","Data", 2);
        list.add(m1);
        list.add(m2);
        //m.dump(list);
        //m.dumpAbteilung(list);
        m.dumpExpertise(list);
    }
    public void dump(List<Employee> list){
        System.out.printf("======================================================================%n");
        System.out.printf("| %-6s | %-20s | %-15s | %-15s |%n", "ID", "NAME","ROLE", "DEPARTMENT");
        System.out.printf("======================================================================%n");

        for(Employee employee: list){

            System.out.printf("| %-6s | %-20s | %-15s | %-15s |%n", employee.getID(), employee.getLastName()+", " +employee.getFirstName(),employee.getRole(), employee.getDepartment());

        }
        System.out.printf("----------------------------------------------------------------------%n");

    }


    public void dumpExpertise(List<Employee> list){
        System.out.printf("===================================================================%n");
        System.out.printf("| %-6s | %-20s | %-30s |%n", "ID", "NAME", "EXPERTISE");
        System.out.printf("===================================================================%n");
        for(Employee employee: list){

            System.out.printf("| %-6s | %-20s  %-30s |%n", employee.getID(), employee.getLastName()+", " +employee.getFirstName(), employee.printExpertise());

        }
        System.out.printf("--------------------------------------------------------------------%n");
    }
}
