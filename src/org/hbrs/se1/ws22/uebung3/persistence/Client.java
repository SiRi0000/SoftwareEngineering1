package org.hbrs.se1.ws22.uebung3.persistence;

import org.hbrs.se1.ws22.uebung2.ContainerException;
import org.hbrs.se1.ws22.uebung2.Member;

import java.util.List;
import java.util.Objects;

//CONTROLLER
public class Client {
    private List<Member> speicher = Container.getContainer().getCurrentList();
    private Main main = new Main();

    /**
     * @Funktion Die Methode erzeugt Member-Objekte
     * @param id
     * @return
     * @throws ContainerException
     */

    public Member createMember(int id) throws ContainerException {
        return new ConcreteMember(id);
    }
    /**
     * @Funktion Die Methode fuegt Member ein, wenn dieser nicht bereits schon abgespeichert ist
     * @param member
     * @throws ContainerException, wenn Member bereits gespeichert wurde
     */
    public void addMember(Member member) throws ContainerException{
        for (Member memberSpeicher :speicher){
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

    /**
     * @Funktion Die methode fragt vom Container die Liste ab und übergibt diese an MemberView zur Ausgabe
     */
    public void display(){
        MemberView.dump(Container.getContainer().getCurrentList());
    }


}
