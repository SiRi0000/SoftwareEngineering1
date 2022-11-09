package uebung4.Test;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uebung4.Controller.EingabeView;
import uebung4.Modell.Container;
import uebung4.Modell.Entities.Employee;
import uebung4.Modell.Entities.EmployeeException;
import uebung4.Modell.Exception.ContainerException;
import uebung4.Modell.Persistence.PersistenceStrategyStream;
import uebung4.Util.Util;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCoreFunction {
    Container container = Container.getContainer();
    List<Employee> list = container.getCurrentList();
    EingabeView eingabe;
    PersistenceStrategyStream<Employee> stream ;

    Util util;

    @BeforeEach
    void setUp(){
        eingabe = new EingabeView();
        stream = new PersistenceStrategyStream<>();
        util = new Util();

        for(Employee employee: list ){
            eingabe.deleteEmployee(employee.getID());
        }

    }

    @AfterEach
    void tearDown(){

    }



    @Test
    void testAddEmployee() {


        try {
            //pos_Normal_ValidInput

            eingabe.addEmployee(12, "Julius", "Peterson", "Manager", "Java",2);

            //Right format
            eingabe.addEmployee(1, "pEtEr", "sChmiDT", "mitarbeiter", "HTML", 1);
            Employee employee = eingabe.getEmployee(1);

            assertEquals("Peter",employee.getFirstName());
            assertEquals("Schmidt",employee.getLastName());
            assertEquals("Mitarbeiter",employee.getRole());
            assertEquals("Html ",util.getExpertiseKey(employee.getExpertise()));
            assertEquals("-",employee.getDepartment());

            assertEquals(2, container.size());

            //neg_SameMemebr

            ContainerException sameMember = Assertions.assertThrows(ContainerException.class, ()->eingabe.addEmployee(12, "Julius", "Peterson", "Manager", "Java",2));
            assertEquals("Employee with ID 12 already exists!", sameMember.getMessage());
            //neg_inValidInput

            EmployeeException s = Assertions.assertThrows(EmployeeException.class, ()-> eingabe.addEmployee(2,"123", "Mustermann","Fachkraft" , "McOffice",3));
            assertEquals("Firstname is invalid!",s.getMessage());
            assertEquals(2, container.size());

            EmployeeException s1 = Assertions.assertThrows(EmployeeException.class, ()-> eingabe.addEmployee(2,"Max", "123","Fachkraft" , "McOffice",3));
            assertEquals("Lastname is invalid!",s1.getMessage());
            assertEquals(2, container.size());

            EmployeeException s2 = Assertions.assertThrows(EmployeeException.class, ()-> eingabe.addEmployee(2,"Max", "Mustermann","123" , "McOffice",3));
            assertEquals("Role is invalid!",s2.getMessage());
            assertEquals(2, container.size());

            EmployeeException s3 = Assertions.assertThrows(EmployeeException.class, ()-> eingabe.addEmployee(2,"Max", "Mustermann","Fachkraft" , "123",3));
            assertEquals("Expertise is invalid!",s3.getMessage());
            assertEquals(2, container.size());



        } catch (ContainerException e) {
            e.printStackTrace();
        } catch (EmployeeException e) {
            e.printStackTrace();
        }





    }

    @Test
    void testStore() {

        try{
            eingabe.addEmployee(20, "Julius", "Peterson", "Manager", "Java",2);
            eingabe.addEmployee(12, "Peter", "Schmidt", "Mitarbeiter", "Html",1);
            eingabe.addEmployee(89, "Max", "Mustermann", "Fachkraft", "MsOffice",3);

            container.store();

            assertEquals(3,container.size());

        } catch (EmployeeException e) {
            e.printStackTrace();
        } catch (ContainerException e) {
            e.printStackTrace();
        }


    }


    @Test
    void testLoadForce(){

        try{
            eingabe.addEmployee(20, "Julius", "Peterson", "Manager", "Java",2);
            eingabe.addEmployee(12, "Peter", "Schmidt", "Mitarbeiter", "Html",1);
            eingabe.addEmployee(89, "Max", "Mustermann", "Fachkraft", "MsOffice",3);

            container.store();

            assertEquals(3,container.size());

            eingabe.addEmployee(123, "Anna", "Mueller", "Fachkraft", "MsOffice",2);

            container.loadForce();

            //assertEquals(3,container.size());



        } catch (EmployeeException e) {
            e.printStackTrace();
        } catch (ContainerException e) {
            e.printStackTrace();
        }



    }

    @Test
    void testLoadMerge(){

    }


}
