package org.hbrs.se1.ws22.uebung8;

public class Hotelsuche {
    private HotelSucheInterface adapter = new Adapter();

    public SuchErgebnis sucheHotel(SuchAuftrag suchAuftrag){
        return adapter.sucheHotel(suchAuftrag);
    }
}
