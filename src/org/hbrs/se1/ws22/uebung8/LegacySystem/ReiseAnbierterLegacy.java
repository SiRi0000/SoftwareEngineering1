package org.hbrs.se1.ws22.uebung8.LegacySystem;


import org.hbrs.se1.ws22.uebung8.Datenbank;

import java.util.ArrayList;

public class ReiseAnbierterLegacy {

    //Simulierte Datenbank
    private Datenbank db = new Datenbank();
    private ArrayList<QueryResult> dblist = db.getDataBase();




    public QueryResult executeQuery (QueryObject queryObject){

        for(QueryResult result : dblist){
            if(queryObject.getLand().equalsIgnoreCase(result.getLand()) & queryObject.getProvince().equalsIgnoreCase(result.getProvince())) {
                return result;
            }
        }

        return null;
    }




}
