package org.hbrs.se1.ws22.uebung8;

public class SuchErgebnis {
    private String land;
    private String ort;

    private String hotelName;



    public SuchErgebnis(String land, String ort, String hotelName){
        this.land = land;
        this.ort = ort;
        this.hotelName = hotelName;
    }

    public String getLand(){return land;}
    public String getProvince(){return ort;}
    public String getHotelTitel(){return hotelName;}
    public String toString (){
        return "Hotelname : " +hotelName +" Ort: " + ort +" Land: "+land;
    }
}
