package org.hbrs.se1.ws22.uebung8;

import org.hbrs.se1.ws22.uebung8.LegacySystem.QueryResult;

import java.util.ArrayList;

public class Datenbank {
    private ArrayList<QueryResult> db = new ArrayList<>();

    public Datenbank(){
        setDatabase();
    }

    private void setDatabase(){
        QueryResult result1 = new QueryResult("Thailand", "Bangkok", "BanyanTree");
        QueryResult result2 = new QueryResult("Thailand", "Bangkok", "Hilton");
        QueryResult result3 = new QueryResult("Deutschland", "Bonn", "Motel1");

        db.add(result1);
        db.add(result2);
        db.add(result3);
    }

    public ArrayList<QueryResult> getDataBase(){
        return db;
    }
}
