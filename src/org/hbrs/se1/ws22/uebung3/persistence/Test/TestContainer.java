package org.hbrs.se1.ws22.uebung3.persistence.Test;

import org.hbrs.se1.ws22.uebung2.ContainerException;
import org.hbrs.se1.ws22.uebung2.Member;
import org.hbrs.se1.ws22.uebung3.persistence.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestContainer {
    Main main;
    Client client;
    Container container;

    Member mem1;
    Member mem2;
    Member mem3;

    PersistenceStrategyStream<Member> stream ;
    PersistenceStrategyMongoDB<Member> mongoDB ;

   @BeforeEach
    void setUp() throws ContainerException {
       main = new Main();
       client = new Client();
       container = Container.getContainer();

       mem1 = client.createMember(1);
       mem2 = client.createMember(2);
       mem3 = client.createMember(3);

       stream = new PersistenceStrategyStream<>();
       mongoDB = new PersistenceStrategyMongoDB<>();

   }
   @AfterEach
   void tearDown(){
       main = null;
       client = null;
       container = null;
       mem1 = null;
       mem2 = null;
       mem3 = null;
       stream = null;
       mongoDB = null;
   }


    @Test
    void pos_applyingPersistenceStragetyStream() throws ContainerException, PersistenceException {

       // Setting PersistenceStragetyStream on Container
        main.setStrategy(stream);

        //state of Container after adding Member to the List
        Assertions.assertEquals(0,container.size());
        client.addMember(mem1);
        Assertions.assertEquals(1,container.size());
        client.addMember(mem2);
        Assertions.assertEquals(2,container.size());
        client.addMember(mem3);
        Assertions.assertEquals(3,container.size());

        //state of Container after persistent saving
        container.store();
        Assertions.assertEquals(3,container.size());


        //state of Container after deletion of all Member in Container
        client.deleteMember(1);
        client.deleteMember(2);
        client.deleteMember(3);
        Assertions.assertEquals(0,container.size());

        //state of Container after loading List from Stream
        container.load();
        Assertions.assertEquals(3,container.size());
   }

   @Test
    void neg_noStrategySetted(){
       Assertions.assertThrows(PersistenceException.class, ()->container.store());
       Assertions.assertThrows(PersistenceException.class, ()->container.load());

   }

   @Test
    void neg_usingPersistenceStragetyMongoDB() throws ContainerException {
       main.setStrategy(mongoDB);

       client.addMember(mem1);
       Assertions.assertEquals(1,container.size());
       client.addMember(mem2);
       Assertions.assertEquals(2,container.size());
       client.addMember(mem3);
       Assertions.assertEquals(3,container.size());

       Assertions.assertThrows(PersistenceException.class, ()->container.store());
       Assertions.assertThrows(PersistenceException.class, ()->container.load());

   }

   @Test
    void neg_wrongPath() throws PersistenceException, ContainerException {

       //change Location
       stream.setLocation("/Projectlol/SE1");
       //Set Strategy
       main.setStrategy(stream);

       //add member to the List
       client.addMember(mem1);
       Assertions.assertEquals(1,container.size());
       client.addMember(mem2);
       Assertions.assertEquals(2,container.size());
       client.addMember(mem3);
       Assertions.assertEquals(3,container.size());


       Assertions.assertThrows(PersistenceException.class, ()->container.store());
       Assertions.assertThrows(PersistenceException.class, ()->container.load());

   }
}
