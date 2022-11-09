package uebung4.Modell.Persistence;


import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<Employee> implements PersistenceStrategy<Employee> {

    // URL of file, in which the objects are stored
    public String location = "objects.ser";

    private ObjectOutputStream oos = null; // Write all primitiv datatyp as well as java objects
    private FileOutputStream fos = null; // write primitiv datatyp

    private ObjectInputStream ois = null; // read all primitiv datatyp as well as java objects
    private FileInputStream fis = null; //read primitiv datatyp

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     * In case of having problems while opening the streams, leave the code in methods load
     * and save
     */
    public void openConnection() throws PersistenceException {}

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {}

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Employee> employees) throws PersistenceException  {

        try{
            //Writting Stream
            fos = new FileOutputStream(location);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(employees);

            ois.close();
            fis.close();

        } catch (FileNotFoundException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Es wurde kein File gefunden.");
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Es wurde kein File gefunden. Ggf. ist der Path Fehlerhaft.");
        }

    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    @SuppressWarnings("unchecked")
    public List<Employee> load() throws PersistenceException  {


        List<Employee> newListe =  null;


        try {

            //reading Stream
            fis = new FileInputStream( location );
            ois = new ObjectInputStream(fis);


            Object obj = ois.readObject();

            if (obj instanceof List<?>) {
                newListe = (List<Employee>) obj;
            }

            ois.close();
            fis.close();

       }catch (FileNotFoundException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Es wurde eine Methode aufgerufen, die nicht implementiert wurde!");
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Es wurde kein File gefunden.");
        } catch (ClassNotFoundException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Etwas ging bei der Connection schief!");
        }

        return newListe;
    }
}
