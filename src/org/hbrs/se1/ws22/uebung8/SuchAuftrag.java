package org.hbrs.se1.ws22.uebung8;

public class SuchAuftrag {
    private String land;
    private String ort;

    private String hotelName;

    public SuchAuftrag(String land, String ort){
        this.land = land;
        this.ort = ort;
    }

    public SuchAuftrag(String land, String ort, String hotelName){
        new SuchAuftrag(land, ort);
        this.hotelName = hotelName;
    }
    public String getLand(){return land;}
    public String getOrt(){return ort;}
    public String getHotelName(){return hotelName;}
}
