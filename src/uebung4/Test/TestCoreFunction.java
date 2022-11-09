package uebung4.Test;



import org.hbrs.se1.ws22.uebung2.Member;
import org.hbrs.se1.ws22.uebung3.persistence.ConcreteMember;
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

    int[] employeeID = {20,12,89};

    @BeforeEach
    void setUp(){


        eingabe = new EingabeView();
        stream = new PersistenceStrategyStream<>();
        util = new Util();

        for(Integer i : employeeID ){
            eingabe.deleteEmployee(i);
        }


    }

    @AfterEach
    void tearDown(){

    }



    @Test
    void testAddEmployee() {


        try {
            //pos_Normal_ValidInput

            eingabe.addEmployee(20, "Julius", "Peterson", "Manager", "Java",2);
            eingabe.addEmployee(89, "Max", "Mustermann", "Fachkraft", "MsOffice",3);

            //Right format
            eingabe.addEmployee(12, "pEtEr", "sChmiDT", "mitarbeiter", "HTML", 1);
            Employee employee = eingabe.getEmployee(12);

            assertEquals("Peter",employee.getFirstName());
            assertEquals("Schmidt",employee.getLastName());
            assertEquals("Mitarbeiter",employee.getRole());
            assertEquals("Html ",util.getExpertiseKey(employee.getExpertise()));
            assertEquals("-",employee.getDepartment());

            assertEquals(3, container.size());

            //neg_SameMemebr

            ContainerException sameMember = Assertions.assertThrows(ContainerException.class, ()->eingabe.addEmployee(20, "Julius", "Peterson", "Manager", "Java",2));
            assertEquals("Employee with ID 20 already exists!", sameMember.getMessage());
            //neg_inValidInput

            EmployeeException s = Assertions.assertThrows(EmployeeException.class, ()-> eingabe.addEmployee(2,"123", "Mustermann","Fachkraft" , "McOffice",3));
            assertEquals("Firstname is invalid!",s.getMessage());
            assertEquals(3, container.size());

            EmployeeException s1 = Assertions.assertThrows(EmployeeException.class, ()-> eingabe.addEmployee(2,"Max", "123","Fachkraft" , "McOffice",3));
            assertEquals("Lastname is invalid!",s1.getMessage());
            assertEquals(3, container.size());

            EmployeeException s2 = Assertions.assertThrows(EmployeeException.class, ()-> eingabe.addEmployee(2,"Max", "Mustermann","123" , "McOffice",3));
            assertEquals("Role is invalid!",s2.getMessage());
            assertEquals(3, container.size());

            EmployeeException s3 = Assertions.assertThrows(EmployeeException.class, ()-> eingabe.addEmployee(2,"Max", "Mustermann","Fachkraft" , "123",3));
            assertEquals("Expertise is invalid!",s3.getMessage());
            assertEquals(3, container.size());



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
            eingabe.addEmployee(1, "Julius", "Peterson", "Manager", "Java",2);
            eingabe.addEmployee(2, "Peter", "Schmidt", "Mitarbeiter", "Html",1);
            eingabe.addEmployee(3, "Hans", "Peterson", "Manager", "Java",2);
            eingabe.addEmployee(4, "Emily", "Schmidt", "Mitarbeiter", "Html",1);

            assertEquals(4,container.size());




            //Laden überschreiben (size ernidrieg sich auf 3)
            container.loadForce();

            assertEquals(3,container.size());



        } catch (EmployeeException e) {
            e.printStackTrace();
        } catch (ContainerException e) {
            e.printStackTrace();
        }



    }


    @Test
    void tesLoadMerge2(){

        try{
            assertEquals(0,container.size());

            //neue Employees in die liste einfügen
            eingabe.addEmployee(10, "Julius", "Peterson", "Manager", "Java",2);
            eingabe.addEmployee(11, "Peter", "Schmidt", "Mitarbeiter", "Html",1);

            assertEquals(2,container.size());

            //laden merga (size() erhöht sich auf 5)

            container.loadMerge();

            assertEquals(5,container.size());

        }catch (EmployeeException e) {
            e.printStackTrace();
        } catch (ContainerException e) {
            e.printStackTrace();
        }

    }


}
