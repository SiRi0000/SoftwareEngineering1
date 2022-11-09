package uebung4.Util;

import uebung4.Modell.Container;
import uebung4.Modell.Entities.Employee;
import uebung4.Modell.Entities.Expertise;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    Container container = Container.getContainer();
    List<Employee> list = Container.getContainer().getCurrentList();

    public List<Employee> searchExpertise(String keyword){
            List<Employee> employeeListe = list.stream().filter(employee -> checkExpertiseOfEmployee(employee,keyword)).collect(Collectors.toList());
            return employeeListe;
    }

    public boolean checkExpertiseOfEmployee(Employee employee, String keyword){
        for(String key: employee.getExpertise().keySet()){
            if(key.equalsIgnoreCase(keyword)){
                return true;
            }
        }
        return false;
    }

    public List<Employee> searchAbteilung(String keyword){
            List<Employee> employeeListe = list.stream().filter(employee -> employee.getDepartment().equalsIgnoreCase(keyword)).collect(Collectors.toList());
            return employeeListe;
    }

    public void sortList(List<Employee> list){
        Comparator<Employee> comparator = new EmployeeComparator();
        Collections.sort(list,comparator);
    }

    public String toRightFormat(String s){
        if(s.length() == 1){
            return s.toUpperCase();
        }
        String first = ""+s.charAt(0);
        String rest = s.substring(1);
        return first.toUpperCase()+rest.toLowerCase();

    }

    public boolean isNumeric(String s){
        int intValue;
        try {
            intValue = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Expertise.ExpLevevel tranferExpertise(int level){
        if(level==1){
            return Expertise.ExpLevevel.BEGINNER;}
        else if(level == 2){
            return Expertise.ExpLevevel.EXPERTS;}
        else if(level==3) {
            return Expertise.ExpLevevel.TOP_PERFORMER;
        }
        return  null;
    }

    public String getExpertiseKey(HashMap<String, Expertise.ExpLevevel> expertise) {
        String s ="";
        for (String key : expertise.keySet()) {
            s+= key+" ";
        }
        return s;
    }
}
