package org.hbrs.se1.ws22.uebung3.persistence;

import org.hbrs.se1.ws22.uebung2.Member;

import java.util.List;

public class MemberView {
    /**
     * @Funktion Die Methode gibt den letzten abgespeicherten Member auf der Konsole aus
     */
    public static void dump(List<Member> memberList){
        System.out.println("Ausgabe aller Memberen: ");
        // Loesung mit For each:
        for ( Member p : memberList ) {
            System.out.println(p.toString());
        }
    }
}
