package org.hbrs.se1.ws22.uebung2;

import java.util.ArrayList;
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

    /**
     * @Funktion Die Methode gibt den letzten abgespeicherten Member auf der Konsole aus
     */
    public void dump(){
        if (size() !=0){
            Member memberAktuell = speicher.get(speicher.size()-1);
            System.out.println(memberAktuell.toString());
        } else {
            throw new IndexOutOfBoundsException("Speicher ist Leer!");
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
