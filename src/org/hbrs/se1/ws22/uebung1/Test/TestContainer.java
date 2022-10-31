package org.hbrs.se1.ws22.uebung1.Test;

import org.hbrs.se1.ws22.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TestContainer {
    GermanTranslator germanTranslator;

    @BeforeEach
    void setUp(){
       germanTranslator = new GermanTranslator();
    }

    @AfterEach
    void tearDown(){
        germanTranslator = null;
    }


    @org.junit.jupiter.api.Test
    void testPosDefbereich(){
        Assertions.assertEquals("fünf",germanTranslator.translateNumber(5));
    }

    @org.junit.jupiter.api.Test
    void testNegkleinerEins(){
        Assertions.assertEquals("Übersetzung der Zahl 0 nicht möglich (1.0)", germanTranslator.translateNumber(0));
        Assertions.assertEquals("Übersetzung der Zahl -1 nicht möglich (1.0)", germanTranslator.translateNumber(-1));
    }

    @org.junit.jupiter.api.Test
    void testNeggroesserZehn(){
        Assertions.assertEquals("Übersetzung der Zahl 11 nicht möglich (1.0)", germanTranslator.translateNumber(11));
    }

}
