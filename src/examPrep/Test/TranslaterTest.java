package examPrep.Test;

import examPrep.Control.GermanTranslator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class TranslaterTest {
    GermanTranslator germTrans = new GermanTranslator();
    @Test
    void germanTraslatorTest(){
        //posAeq
        Assertions.assertEquals("zwei",germTrans.translateNumber(2));

        //negAeq
        Assertions.assertEquals("Übersetzung der Zahl -1 nicht möglich (Version 1.0)", germTrans.translateNumber(-1));

        Assertions.assertEquals("Übersetzung der Zahl 15 nicht möglich (Version 1.0)", germTrans.translateNumber(15));

        Assertions.assertEquals("Übersetzung der Zahl 0 nicht möglich (Version 1.0)", germTrans.translateNumber(0));
    }

}
