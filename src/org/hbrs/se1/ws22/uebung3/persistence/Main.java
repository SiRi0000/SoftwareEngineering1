package org.hbrs.se1.ws22.uebung3.persistence;


import org.hbrs.se1.ws22.uebung2.Member;

//THE BACKEND SYSTEM
public class Main {
    public void setStrategy(PersistenceStrategy<Member> strategy){
        Container.getContainer().setStrategy(strategy);
    }

}
