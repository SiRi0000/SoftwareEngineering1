package org.hbrs.se1.ws22.uebung3.persistence;

import org.hbrs.se1.ws22.uebung2.ContainerException;
import org.hbrs.se1.ws22.uebung2.Member;

import java.util.List;
import java.util.Objects;

//CONTROLLER
public class Client {
   private final Container container = Container.getContainer();
   private final MemberView memberView = new MemberView();



    /**
     * @Funktion Die Methode fuegt Member ein, wenn dieser nicht bereits schon abgespeichert ist
     * @throws ContainerException, wenn Member bereits gespeichert wurde
     */
    public void addMember(int id) throws ContainerException{
        Member member = new ConcreteMember(id);
        try{
        container.addMember(member);
        } catch (ContainerException e){
            System.out.println("Das Member-Objekt mit der ID " + member.getID() +" ist bereits vorhanden!");
        }

    }



    /**
     * @Funktion: Die Methode Loescht Member uber die uebergebende ID
     * @param id
     * @return String
     */
    public void deleteMember(Integer id){

        String m = container.deleteMember(id);
        if(m.equals("Member " + id + " wurde erfolgreich entfernt.")){
            System.out.println("Member wure erfolgreich gelöscht");
        } else {
            System.out.println("Member konnt nicht gefunden werden!");
        }
    }



    /**
     * @Funktion Die methode fragt vom Container die Liste ab und übergibt diese an MemberView zur Ausgabe
     */
    public void display(){
        memberView.dump(Container.getContainer().getCurrentList());
    }


}
