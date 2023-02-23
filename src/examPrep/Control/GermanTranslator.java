package examPrep.Control;

import java.util.SortedMap;
import java.util.TreeMap;

public class GermanTranslator implements Translator {
    private String date = "OKT/2023";
    @Override
    public String translateNumber(int zahl) {
        if (zahl <= 0 || zahl > 10) {
            return "Übersetzung der Zahl " + zahl + " nicht möglich (Version " + Translator.version+ " )";
        }
        /*ArrayList<String> list = new ArrayList<>();
        list.add(1,"eins");
        list.add(2,"zwei");
        list.add(3,"drei");
        list.add(4,"vier");
        list.add(5,"fuenft");
        list.add(6,"sechs");
        list.add(7,"sieben");
        list.add(8,"acht");
        list.add(9,"neun");
        list.add(10,"zehn");
        return list.get(zahl);*/

        SortedMap<Integer, String> mapList = new TreeMap<>();
        mapList.put(1, "eins");
        mapList.put(2, "zwei");
        mapList.put(3, "drei");
        mapList.put(4, "vier");
        mapList.put(5, "fuenft");
        mapList.put(6, "sechs");
        mapList.put(7, "sieben");
        mapList.put(8, "acht");
        mapList.put(9, "neun");
        mapList.put(10, "zehn");

        return mapList.get(zahl);
    }
    public void setDate(String date){
        this.date = date;
    }
}
