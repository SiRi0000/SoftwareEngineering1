package org.hbrs.se1.ws22.uebung2.Test;

import org.hbrs.se1.ws22.uebung2.ConcreteMember;
import org.hbrs.se1.ws22.uebung2.Container;
import org.hbrs.se1.ws22.uebung2.ContainerException;
import org.hbrs.se1.ws22.uebung2.Member;
import org.junit.jupiter.api.*;


//Test Container
public class TestContainer {
    Member member1,member2, member3;
    Container container;

    @BeforeEach
    void setUp(){
        container = new Container();
        member1 = new ConcreteMember(1);
        member2 = new ConcreteMember(2);
        member3 = new ConcreteMember(3);
    }

    @AfterEach
    void tearDown(){
        container = null;
        member1 = null;
        member2 = null;
        member3 = null;
    }

    @Test
    void testInitialisierungContainer(){
        Assertions.assertEquals(0, container.size());
    }



    @Test
    void pos_testAddMember() throws ContainerException {

        container.addMember(member1);
        Assertions.assertEquals(1, container.size());
        container.addMember(member2);
        Assertions.assertEquals(2, container.size());
        container.addMember(member3);
        Assertions.assertEquals(3, container.size());


    }

    @Test
    void neg_testAddMemberBeiMemberVorhanden() throws ContainerException {
        container.addMember(member3);
        Assertions.assertThrows(ContainerException.class, ()->{container.addMember(member3);});
    }

    @Test
    void pos_testDeleteMember() throws ContainerException {
        container.addMember(member2);
        container.addMember(member3);
        container.addMember(member1);
        Assertions.assertEquals("Member 1 wurde erfolgreich entfernt.",container.deleteMember(1));
        Assertions.assertEquals(2, container.size());
        Assertions.assertEquals("Member 3 wurde erfolgreich entfernt.",container.deleteMember(3));
        Assertions.assertEquals(1, container.size());
        Assertions.assertEquals("Member 2 wurde erfolgreich entfernt.",container.deleteMember(2));
        Assertions.assertEquals(0, container.size());

    }

    @Test
    void neg_testDeleteMemberNichtImContainer() throws ContainerException {
        container.addMember(member1);
        container.addMember(member2);
        Assertions.assertEquals("Member 3 konnte nicht gefunden werden.", container.deleteMember(3));

    }

    @Test
    void neg_testDeleteMemberLeerenContainer(){
        Assertions.assertEquals("Member 1 konnte nicht gefunden werden.", container.deleteMember(1));
    }


    @Test
    void pos_testDumpBeiContainerNichtLeer() throws ContainerException {
        container.addMember(member1);
        container.addMember(member2);
        container.addMember(member3);
        container.dump();
        Assertions.assertEquals(3,container.size());
    }



    //Auf null als Parameter Testen

    //Try Catch um Ecxeption zu pruefen > test laeuft weiter obwohl etwas gecatch wurde

}
