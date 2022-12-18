package org.hbrs.se1.ws22.uebung8.LegacySystem;

public class QueryResult {
    private String land;
    private String province;

    private String hotelTitel;


    public QueryResult(String land, String ort, String hotelName){
        this.land = land;
        this.province = ort;
        this.hotelTitel = hotelName;
    }
    public String getLand(){return land;}
    public String getProvince(){return province;}
    public String getHotelTitel(){return hotelTitel;}
}
