package examPrep.Control;


public class Factory {

    public static final Translator createGermanTranslator(){
        GermanTranslator germanTranslator = new GermanTranslator();
        germanTranslator.setDate("11-11-2023");
        return germanTranslator;
    }


}
