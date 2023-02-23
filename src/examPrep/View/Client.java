package examPrep.View;

import examPrep.Control.Factory;

public class Client {

    // Problem: Andere Translator kann nicht displayed werden
    // Lösung : Translator wird von außen auf den Client gesetzt
    public void display(int zahl){
        System.out.println(Factory.createGermanTranslator().translateNumber(zahl));
    }

}
