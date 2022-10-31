package org.hbrs.se1.ws22.uebung2;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


//Funktion: Speichert Member-Objekte
public class Container {
    private ArrayList<Member> speicher = new ArrayList<>();

    /**
     * @Funktion Die Methode fuegt Member ein, wenn dieser nicht bereits schon abgespeichert ist
     * @param member
     * @throws ContainerException, wenn Member bereits gespeichert wurde
     */
    public void addMember(Member member) throws ContainerException{
        for (Member memberSpeicher : speicher){
            if(Objects.equals(memberSpeicher.getID(), member.getID())){
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() +" ist bereits vorhanden!");
            }
        }
        speicher.add(member);
    }


    /**
     * @Funktion: Die Methode Loescht Member uber die uebergebende ID
     * @param id
     * @return String
     */
    public String deleteMember(Integer id){
        for(int i = 0; i < speicher.size(); i++){
            if(Objects.equals(speicher.get(i).getID(), id)){
                speicher.remove(i);
                return "Member " + id + " wurde erfolgreich entfernt.";
            }
        }
        return "Member " + id + " konnte nicht gefunden werden.";
    }
    // Keine Traceback, keine Konsolenausgabe über den Fehler, keine Einheitlichkeit der Fehlermeldung
    // Aenderung des Strings moeglich, dies fuehrt zu moegliche Veraenderung des Fehlers

    /**
     * @Funktion Die Funktion gibt die IDs der aktuell abgespeicherten Member auf die Console aus
     */
    public void dump(){
        for(Member i: speicher){
            System.out.println(i.toString());
        }
    }

    /**
     * @Funktion Die Methode gibt die Anzahl der abgespeicherten Member im Container zurueck
     * @return int
     */
    public int size(){
        return speicher.size();
    }
}
