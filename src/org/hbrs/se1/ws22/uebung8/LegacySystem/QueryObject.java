package org.hbrs.se1.ws22.uebung8.LegacySystem;

public class QueryObject {
    private String land;
    private String province;

    private String hotelTitel;

    public QueryObject(String land, String province){
        this.land = land;
        this.province = province;
    }

    public QueryObject(String land, String ort, String hotelTitel){
        new QueryObject(land, ort);
        this.hotelTitel = hotelTitel;
    }

    public String getLand(){return land;}
    public String getProvince(){return province;}
    public String getHotelTitel(){return hotelTitel;}

}
