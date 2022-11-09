package uebung4.Controller;




import uebung4.Modell.Container;
import uebung4.Modell.Entities.Employee;
import uebung4.Modell.Entities.EmployeeException;
import uebung4.Modell.Exception.ContainerException;
import uebung4.Util.Util;

import java.util.Scanner;

public class Main {
    private static boolean run = true;


    public static void main(String[] args){

        Util util = new Util();
        Container container = Container.getContainer();
        EingabeView eingabeView = new EingabeView();
        Scanner scanner = new Scanner(System.in);



        System.out.println("Employee-Tool V1.2 by Senma");
        System.out.println();
        System.out.println("Welcome! Please enter a command of your choice. \"Enter help to see all command.\"");

        while(run) {


            System.out.print("> ");

            String strInput = scanner.nextLine();

            // Extrahiert ein Array aus der Eingabe
            String[] strings = strInput.split(" ");
            String firstE = strings[0];

            switch (firstE) {


                case "help":
                    System.out.printf("===========================================================================================================================================================%n");
                    System.out.printf("| %-15s | %-70s | %-60s |%n", "COMMAND", "FUNCTION", "INPUT FORMAT");
                    System.out.printf("===========================================================================================================================================================%n");
                    System.out.printf("| %-15s | %-70s | %-60s |%n", "e n t e r", "Add member to the list.", "enter id firstname lastname role expertise expertiseLevel");

                    System.out.printf("| %-15s | %-70s | %-60s |%n", "s t o r e", "Save list of employees to the database. ", "store");

                    System.out.printf("| %-15s | %-70s | %-60s |%n", "l o a d", "Load employee list from database and merge with current list.", "load merge ");

                    System.out.printf("| %-15s | %-70s | %-60s |%n", "", "Load employee list from database and overwrites current list.", "load force ");

                    System.out.printf("| %-15s | %-70s | %-60s |%n", "d u m p", "Output of all employees(without expertise)", "dump");

                    System.out.printf("| %-15s | %-70s | %-60s |%n", "", "Output of all employees in a certain department.", "dump department departmentName");

                    System.out.printf("| %-15s | %-70s | %-60s |%n", "s e a r c h", "Search for employees with a specific expertise.", "search expertiseName");

                    System.out.printf("| %-15s | %-70s | %-60s |%n", "e x i t", "Exit the program.", "exit");

                    System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------%n");
                    break;


                case "enter":

                    try {

                        eingabeView.addEmployee(Integer.parseInt(strings[1]), strings[2], strings[3], strings[4], strings[5], Integer.parseInt(strings[6]));

                        //Add Department
                        String firstname = util.toRightFormat(strings[2]);
                        String lastname = util.toRightFormat(strings[3]);
                        Employee employee = eingabeView.getEmployee(Integer.parseInt(strings[1]));
                        System.out.println("Please enter department or tap enter to skip.");

                        System.out.print("> ");

                        String strEnter = scanner.nextLine();

                        if (strEnter.equals("")) {

                        }
                        else{
                            //add department
                            String[] strings1 = strEnter.split(" ");
                            employee.setDepartment(strings1[0]);

                            System.out.println(firstname + " " + lastname + " was successfully assigned to " + employee.getDepartment() + " Department.");
                        }



                            //ADD EXPERTISE

                            System.out.println("Please enter further expertises with expertise level or tap to skip.");
                            System.out.print("> ");

                            String strInput1 = scanner.nextLine();


                            //NO ADDING EXPERTISE
                            if (strInput1.equals("")) {
                                System.out.println(firstname + " " + lastname + " was successfully added.");
                                System.out.println();
                                System.out.println("Please enter a command of your choice.");
                                break;
                            } else {
                                //Add Expertise 1
                                String[] strings2 = strInput1.split(" ");
                                employee.setExpertise(strings2[0], Integer.parseInt(strings2[1]));
                                System.out.println("Add more or tab \"f\" to finish adding expertise.");
                                System.out.print("> ");

                                String newString = scanner.nextLine();
                                if (newString.equals("f")) {
                                    System.out.println(firstname + " " + lastname + " was successfully added.");
                                    System.out.println();
                                    System.out.println("Please enter a command of your choice.");
                                    break;
                                } else {
                                    //Adding Expertise 2
                                    String[] strings3 = newString.split(" ");
                                    employee.setExpertise(strings3[0], Integer.parseInt(strings3[1]));
                                    System.out.println("Please enter a command of your choice.");
                                    break;

                                }
                            }


            } catch(NumberFormatException e){
                System.out.println("Something went wrong. Please check your ID and Expertise Level input.");
                System.out.println("The ID has to be a number! The Expertise Level must be in the range 1 through 3!");
                System.out.println("Try again :)");
                break;
            } catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Something went wrong. Please check your input you did . Is your input according to the specification?");
                System.out.println("Enter help if you forgot the input format:)");
                break;
            } catch(ContainerException e){
                System.out.println(e.getMessage());
                System.out.println();
                System.out.println("Please enter a command of your choice.");
                break;
            } catch(EmployeeException e){
                if (e.getExceptionTypeType().equals(EmployeeException.ExceptionType.StringIsNumeric)) {
                    System.out.println(e.getMessage());
                    System.out.println();
                    System.out.println("Please enter a command of your choice.");
                    break;
                }
                if (e.getExceptionTypeType().equals(EmployeeException.ExceptionType.ExpertiseFull)) {
                    System.out.println(e.getMessage());
                    System.out.println();
                    System.out.println("Please enter a command of your choice.");
                    break;
                }

            }



                case "store":

                    if(container.getCurrentList().isEmpty()){
                        System.out.println("The employee list is empty. Please add employee to the list.");
                        System.out.println("Enter help if you forgot how to add employee:)");
                        break;
                    }
                    container.store();
                    System.out.println("Employee list has been successfully saved.");
                    System.out.println();
                    System.out.println("Please enter a command of your choice.");
                    break;


                case "load":

                    try{

                        if(strings[1].equalsIgnoreCase("merge")){
                            container.loadMerge();
                            System.out.println("The list has been successfully load.");
                            System.out.println();
                            System.out.println("Please enter a command of your choice.");
                            break;

                        } else if(strings[1].equalsIgnoreCase("force")){
                            container.loadForce();
                            System.out.println("The list has been successfully load.");
                            System.out.println();
                            System.out.println("Please enter a command of you choice.");
                            break;
                        } else {
                            System.out.println("No loading option has been selected. Enter help to see the loading options. ");
                            break;
                        }

                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Something went wrong. You have to enter how you want to load the list from the database.");
                        System.out.println("Enter help to see the loading options. Try again:)");
                        break;
                    }



                case "dump":

                    if(container.getCurrentList().isEmpty()){
                        System.out.println("The employee list is empty. Please add employee to the list.");
                        System.out.println("Enter help if you forgot how to add employee:)");
                        break;
                    }

                    if(strings.length == 1){
                        eingabeView.dump();
                        System.out.println();
                        System.out.println("Please enter a command of your choice.");
                        break;
                    }
                    if(strings[1].equalsIgnoreCase("department")) {

                        try{
                            eingabeView.dumpAbteilung(strings[2]);
                            System.out.println();
                            System.out.println("Please enter a command of your choice.");
                            break;

                        } catch (ArrayIndexOutOfBoundsException e){
                            System.out.println("Please enter \"dump department\" a department that you are looking for.");
                            break;
                        }
                    }
                    System.out.println("You have a typing mistake. If needed enter help to see all command and input format.");
                    break;



                case "search":

                    try{
                        eingabeView.dumpExpertise(strings[1]);
                        System.out.println();
                        System.out.println("Please enter a command of your choice.");
                        break;

                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Please enter after search an expertise that you are looking for.");
                        break;
                    }



                case "exit":
                    System.out.println("Program has been shut down successfully. See you next time:)");
                    run = false;
            }
        }

    }
}
