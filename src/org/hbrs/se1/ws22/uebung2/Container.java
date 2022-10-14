package org.hbrs.se1.ws22.uebung2;

import java.util.ArrayList;
import java.util.Iterator;

public class Container {
    private ArrayList<Member> speicher = new ArrayList<>();
    public void addMember(Member member) throws ContainerException{
        for (Member memberSpeicher : speicher){
            if(memberSpeicher.getID() != member.getID()){
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() +" ist bereits vorhanden!");
            }
        }
        speicher.add(member);
    }

    public String deleteMember(Integer id){
        for(int i = 0; i < speicher.size(); i++){
            if(speicher.get(i).getID() == id){
                speicher.remove(i);
                return "Member " + id + " wurde erfolgreich entfern.";
            }
        }
        return "Member " + id + " konnte nicht gefunden werden.";
    }
    // Keine Traceback, keine Konsolenausgabe über den Fehler, keine Einheitlichkeit der Fehlermeldung

    public void dump(){
        Member memberAktuell = speicher.get(speicher.size()-1);
        System.out.println(memberAktuell.toString());
    }

    public int size(){
        return speicher.size();
    }
}
