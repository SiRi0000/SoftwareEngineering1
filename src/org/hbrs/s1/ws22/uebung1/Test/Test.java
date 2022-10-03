package org.hbrs.s1.ws22.uebung1.Test;

import org.hbrs.s1.ws22.uebung1.control.Creator;
import org.hbrs.s1.ws22.uebung1.control.GermanTranslator;
import org.hbrs.s1.ws22.uebung1.view.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class Test {
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
    void testPosGrenzwerte(){
        Assertions.assertEquals("eins", germanTranslator.translateNumber(1));
        Assertions.assertEquals("zehn", germanTranslator.translateNumber(10));
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
    void testNeggroeßerZehn(){
        Assertions.assertEquals("Übersetzung der Zahl 11 nicht möglich (1.0)", germanTranslator.translateNumber(11));
    }

}
