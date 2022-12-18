package org.hbrs.se1.ws22.uebung8;

import org.hbrs.se1.ws22.uebung8.LegacySystem.QueryObject;
import org.hbrs.se1.ws22.uebung8.LegacySystem.QueryResult;
import org.hbrs.se1.ws22.uebung8.LegacySystem.ReiseAnbierterLegacy;

public class Adapter implements HotelSucheInterface{

    private ReiseAnbierterLegacy reiseAnbierterLegacy = new ReiseAnbierterLegacy();
    @Override
    public SuchErgebnis sucheHotel(SuchAuftrag suchAuftrag) {
        //Eingabe Transformieren
        QueryObject eingabeOld = transformEingabe(suchAuftrag);

        // Delegation auf Alt System
        QueryResult oldResult = reiseAnbierterLegacy.executeQuery(eingabeOld);

        //Transdormation Ausgabe

        SuchErgebnis ergebnis = transformAusgabe(oldResult);

        return ergebnis;
    }

    public QueryObject transformEingabe(SuchAuftrag suchAuftrag){
        QueryObject queryObject = new QueryObject(suchAuftrag.getLand(), suchAuftrag.getOrt());
        return queryObject;
    }

    public SuchErgebnis transformAusgabe(QueryResult result){
        SuchErgebnis suchErgebnis = new SuchErgebnis(result.getLand(), result.getProvince(), result.getHotelTitel());
        return suchErgebnis;
    }
}
