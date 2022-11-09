package uebung4.Modell;



import uebung4.Modell.Entities.Employee;
import uebung4.Modell.Exception.ContainerException;
import uebung4.Modell.Persistence.PersistenceException;
import uebung4.Modell.Persistence.PersistenceStrategy;
import uebung4.Modell.Persistence.PersistenceStrategyStream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Container implements Serializable{



    //Funktion: Speichert Member-Objekte
        private List<Employee> speicher = new ArrayList<>();
        private PersistenceStrategy<Employee> strategy = new PersistenceStrategyStream<>();

        /**
         * Singleton-Pattern: 2. Es wird ein statisches und privates Obrjekt der Klasse erzeugt -> Zugriff von außen nicht möglich
         * -> statische Variablen existieren nur einmal und können von allen anderen Klassen genutzt werden
         */
        private static Container container = new Container();


        /**
         * Singleton-Pattern: 1. Konstuktor wird als privat deklariert, damit es nicht mehr von außen zugreifbar ist
         */
        private Container(){}


        /**
         * Singleton-Pattern: 3. Über die statische Methode wird der Zugriff auf das einzige Objekt gewährleistet
         *
         * @return
         */
        public static Container getContainer(){

            return container;
        }



        /**
         * @Funktion Die Methode setzt eine Strategie auf den Container
         * @param strategy
         */
        //public void setStrategy(PersistenceStrategy<Employee> strategy){
            //this.strategy = strategy;
        //}



        /**
         * @Funktion Die Methode fuegt Member ein, wenn dieser nicht bereits schon abgespeichert ist
         * @param employee
         * @throws ContainerException, wenn Member bereits gespeichert wurde
         */
        public void addEmployee(Employee employee) throws ContainerException {
            for (Employee memberSpeicher :speicher){
                if(Objects.equals(memberSpeicher.getID(), employee.getID())){
                    throw new ContainerException("Das Member-Objekt mit der ID " + employee.getID() +" ist bereits vorhanden!");
                }
            }
            speicher.add(employee);
        }

        /**
         * @Funktion: Die Methode Loescht Member uber die uebergebende ID
         * @param id
         * @return String
         */
        public String deleteEmployee(Integer id){

            for(int i = 0; i < speicher.size(); i++){
                if(Objects.equals(speicher.get(i).getID(), id)){
                    speicher.remove(i);
                    return "Member " + id + " wurde erfolgreich entfernt.";
                }
            }
            return "Member " + id + " konnte nicht gefunden werden.";
        }





        /**
         * @Funktion Die Methode gibt die Anzahl der abgespeicherten Member im Container zurueck
         * @return int
         */
        public int size(){
            return speicher.size();
        }


        /**
         * @Fuktion Die Methode speichert die aktuell in einem Container-Objekt hinzugefügkten Member-Objekte
         * persistent(dauerhaft) auf einem Datenspeicher ab
         * @throws PersistenceException
         */
        public void store()  {

            try{

                if(strategy == null){
                    throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "No strategy was set!");
                }

                strategy.save(speicher);
                System.out.println("Employee list has been successfully saved.");


            } catch (PersistenceException e ){
                if(e.getExceptionTypeType().equals(PersistenceException.ExceptionType.NoStrategyIsSet)){
                    e.getMessage();
                } else if (e.getExceptionTypeType().equals(PersistenceException.ExceptionType.ConnectionNotAvailable)) {
                    e.getMessage();
                } else if(e.getExceptionTypeType().equals(PersistenceException.ExceptionType.ImplementationNotAvailable)){

                }
            } catch (UnsupportedOperationException e){
                System.out.println("A method was called that was not implemented.");
            }


        }


        /**
         * @Funktion Die Methode lädt die Member-Objekte aus dem Speicher
         * @throws PersistenceException
         */

        public void loadForce() {

            try{

                if(strategy == null){
                    throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Es wurde keine Strategie gesetz!");
                }

                speicher = (List<Employee>) strategy.load();


            } catch (PersistenceException e ){
                if(e.getExceptionTypeType().equals(PersistenceException.ExceptionType.NoStrategyIsSet)){
                    e.getMessage();
                } else if (e.getExceptionTypeType().equals(PersistenceException.ExceptionType.ConnectionNotAvailable)) {
                    e.getMessage();
                } else if(e.getExceptionTypeType().equals(PersistenceException.ExceptionType.ImplementationNotAvailable)){

                }
            } catch (UnsupportedOperationException e){
                System.out.println("A method was called that was not implemented.");
            }
        }

        public void loadMerge() {

            try{
                if(strategy == null){
                    throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Es wurde keine Strategie gesetz!");
                }

                speicher.addAll((strategy.load()));

            } catch (PersistenceException e ){
                if(e.getExceptionTypeType().equals(PersistenceException.ExceptionType.NoStrategyIsSet)){
                    e.getMessage();
                } else if (e.getExceptionTypeType().equals(PersistenceException.ExceptionType.ConnectionNotAvailable)) {
                    e.getMessage();
                } else if(e.getExceptionTypeType().equals(PersistenceException.ExceptionType.ImplementationNotAvailable)){

                }
            } catch (UnsupportedOperationException e){
                System.out.println("A method was called that was not implemented.");
            }
        }

        /**
         * @Funktion die Methode gibt die aktuelle Liste zurueck
         * @return
         */

        public List<Employee> getCurrentList(){
            return speicher;
        }


}
