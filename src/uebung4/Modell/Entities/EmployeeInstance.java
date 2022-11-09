package uebung4.Modell.Entities;

import uebung4.Util.Util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class EmployeeInstance implements Employee, Serializable {

    private Util util = new Util();

    private int id;
    private String firstname;
    private String lastname;
    private String role;
    private HashMap<String,Expertise.ExpLevevel> expertise = new HashMap<>();
    private String department ="-";

    public EmployeeInstance (int id, String firstname, String lastname, String role, String expertise, int expertiseLevel) {


        this.id = id;
        this.firstname = util.toRightFormat(firstname);
        this.lastname = util.toRightFormat(lastname);
        this.role = util.toRightFormat(role);
        util.toRightFormat(expertise);


            this.expertise.put(util.toRightFormat(expertise),util.tranferExpertise(expertiseLevel));


    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstname;
    }

    @Override
    public String getLastName() {
        return lastname;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setDepartment(String department) {
        this.department = util.toRightFormat(department);
    }

    @Override
    public String getDepartment() {
            return department;

    }

    @Override
    public HashMap<String,Expertise.ExpLevevel> getExpertise() {
        return expertise;
    }

    public String printExpertise(){
        String e = "";
        for (Map.Entry<String, Expertise.ExpLevevel> set: expertise.entrySet()){
         e += "| "+set.getKey() + ": " + set.getValue()+" ";
        }
        return e;
    }

    @Override
    public void setExpertise(String expert, int level) throws EmployeeException {
       if(expertise.size() != 3){

           expertise.putIfAbsent(util.toRightFormat(expert), util.tranferExpertise(level));
       }
       else{
           throw new EmployeeException(EmployeeException.ExceptionType.ExpertiseFull,"Three expertises have already been assigned to this member!");
       }
    }

    public String toString(){
        return getFirstName()+" " + getLastName()+ ": "+ getExpertise();
    }
}
