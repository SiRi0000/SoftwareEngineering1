package org.hbrs.se1.ws22.uebung3.persistence;

import org.hbrs.se1.ws22.uebung2.ContainerException;
import org.hbrs.se1.ws22.uebung2.Member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


//Funktion: Speichert Member-Objekte
public class Container {
    private ArrayList<Member> speicher = new ArrayList<>();
    private PersistenceStrategy strategy = null;

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
     * @return
     */
    public static Container getContainer(){
        return container;
    }


    /**
     * @Funktion Die Methode setzt eine Strategie auf den Container
     * @param strategy
     */
    public void setStrategy(PersistenceStrategy strategy){
        this.strategy = strategy;
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
    public void store() throws PersistenceException{
        try{
            if(strategy == null){
                throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Es wurde keine Strategie gesetz!");
            }
            strategy.save(speicher);
        } catch(UnsupportedOperationException e){
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Es wurde eine Methode aufgerufen, die nicht implementiert wurde!");
        }


    }


    /**
     * @Funktion Die Methode lädt die Member-Objekte aus dem Speicher
     * @throws PersistenceException
     */

    public void load() throws PersistenceException{
        try{
            if(strategy == null){
                throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Es wurde keine Strategie gesetz!");
            }

            speicher = (ArrayList<Member>) strategy.load();
        } catch (UnsupportedOperationException e){
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Es wurde eine Methode aufgerufen, die nicht implementiert wurde!");

        }
    }

    /**
     * @Funktion die Methode gibt die aktuelle Liste zurueck
     * @return
     */

    public List<Member> getCurrentList(){
        return speicher;
    }
}
