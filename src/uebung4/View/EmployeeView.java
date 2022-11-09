package uebung4.View;



import uebung4.Modell.Container;
import uebung4.Modell.Entities.Employee;
import uebung4.Modell.Entities.EmployeeInstance;

import java.util.ArrayList;
import java.util.List;

public class EmployeeView {
    static List<Employee> list = new ArrayList<>();

    public void dump(List<Employee> list){
        System.out.printf("======================================================================%n");
        System.out.printf("| %-6s | %-20s | %-15s | %-15s |%n", "ID", "NAME","ROLE", "DEPARTMENT");
        System.out.printf("======================================================================%n");

        for(Employee employee: list){

            System.out.printf("| %-6s | %-20s | %-15s | %-15s |%n", employee.getID(), employee.getLastName()+", " +employee.getFirstName(),employee.getRole(), employee.getDepartment());

        }
        System.out.printf("----------------------------------------------------------------------%n");

    }


    public void dumpExpertise(List<Employee> list, String key){
        System.out.printf("===================================================================%n");
        System.out.printf("| %-6s | %-20s | %-30s |%n", "ID", "NAME", "EXPERTISE");
        System.out.printf("===================================================================%n");
        for(Employee employee: list){

            System.out.printf("| %-6s | %-20s  %-30s |%n", employee.getID(), employee.getLastName()+", " +employee.getFirstName(), "| "+employee.printExpertise(key));

        }
        System.out.printf("--------------------------------------------------------------------%n");
    }
}
