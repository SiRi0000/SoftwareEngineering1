package org.hbrs.se1.ws22.uebung8;

import org.hbrs.se1.ws22.uebung8.LegacySystem.ReiseAnbierterLegacy;

public class Main {
    public static void main(String[] args){
        Hotelsuche suche = new Hotelsuche();

        SuchAuftrag suchAuftrag = new SuchAuftrag("thailand", "bangkok");

        SuchErgebnis ergebnis = suche.sucheHotel(suchAuftrag);
        System.out.println(ergebnis.toString());

    }
}
