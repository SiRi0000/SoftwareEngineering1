package org.hbrs.se1.ws22.uebung1.control;

public class Factory {
    /* Anwendung des Factory Method Design Pattern
     * Design Pattern: Herangehensweise an widerkehrendes Problem
     * Problem: Inkonsistente Erzeugung von Objekten und inkonsistente Parametrisierung von Objekten
     * Lösung: Bereitstellung einer Klasse zur konsistenten und zentralen Erzeugung von Objekten
     */
    public static Translator createTranslator(){
        //Datum Konsistenz einsetzen in den GermanTranslator
        GermanTranslator germanTranslator = new GermanTranslator();
        germanTranslator.setDate("Okt/2022");
        return germanTranslator;
    }
}
