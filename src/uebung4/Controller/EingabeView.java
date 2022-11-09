package uebung4.Controller;


import uebung4.Modell.Entities.Employee;
import uebung4.Modell.Entities.EmployeeException;
import uebung4.Modell.Entities.EmployeeInstance;
import uebung4.Modell.Container;
import uebung4.Modell.Exception.ContainerException;
import uebung4.Util.Util;
import uebung4.View.EmployeeView;

import java.util.List;

public class EingabeView {
    private final Container container = Container.getContainer();
    private final EmployeeView employeeView = new EmployeeView();
    private Util util = new Util();



    /**
     * @Funktion Die Methode fuegt Member ein, wenn dieser nicht bereits schon abgespeichert ist
     * @throws ContainerException, wenn Member bereits gespeichert wurde
     */
    public void addEmployee(int id, String firstname, String lastname, String role, String expertise, int expertiseLevel) throws ContainerException, EmployeeException {

        if(util.isNumeric(firstname)){
            throw new EmployeeException(EmployeeException.ExceptionType.StringIsNumeric,"Firstname is invalid!");
        }
        if(util.isNumeric(lastname)){
            throw new EmployeeException(EmployeeException.ExceptionType.StringIsNumeric,"Lastname is invalid!");
        }
        if(util.isNumeric(role)){
            throw new EmployeeException(EmployeeException.ExceptionType.StringIsNumeric,"Role is invalid!");
        }
        if(util.isNumeric(expertise)){
            throw new EmployeeException(EmployeeException.ExceptionType.StringIsNumeric,"Expertise is invalid!");
        }

        Employee employee = new EmployeeInstance(id,firstname,lastname,role,expertise,expertiseLevel);
        try{
            container.addEmployee(employee);
        } catch (ContainerException e){
            throw new ContainerException("Employee with ID " + employee.getID() +" already exists!");

        }

    }



    /**
     * @Funktion: Die Methode Loescht Member uber die uebergebende ID
     * @param id
     */
    public void deleteEmployee(Integer id){

        String m = container.deleteEmployee(id);
        if(m.equals("Member " + id + " wurde erfolgreich entfernt.")){
            System.out.println("Member wurde erfolgreich gelöscht");
        } else {
            System.out.println("Member konnt nicht gefunden werden!");
        }
    }



    /**
     * @Funktion Die methode fragt vom Container die Liste ab und übergibt diese an MemberView zur Ausgabe
     */
    public void dump(){

        util.sortList(Container.getContainer().getCurrentList());
        employeeView.dump(Container.getContainer().getCurrentList());
    }

    public void dumpAbteilung(String key){
        List<Employee> list = util.searchAbteilung(key);
        util.sortList(list);

        employeeView.dump(list);
    }

    public void dumpExpertise(String key){
        List<Employee> list = util.searchExpertise(key);
        util.sortList(list);
        employeeView.dumpExpertise(list,key);
    }

    /**
     * Liefert einen bestimmten Employee zurück
     * @param id
     * @return
     */
    public Employee getEmployee(int id) {
        for ( Employee employee : container.getCurrentList()) {
            if (id == employee.getID() ){
                return employee;
            }
        }
        return null;
    }
}
