package org.hbrs.se1.ws22.uebung3.persistence;

import org.hbrs.se1.ws22.uebung2.Member;

import java.io.Serializable;

//Funktion der Klasse:Member-Objekt Bau
public class ConcreteMember implements Member, Serializable {
    private Integer id;
    public ConcreteMember(int id){
      this.id = id;
    }
    @Override
    public Integer getID() {
        return id;
    }
    public String toString(){
        return "Member (ID = " + getID() + ")";
    }
}
