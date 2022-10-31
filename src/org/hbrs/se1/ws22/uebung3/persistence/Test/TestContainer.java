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



    PersistenceStrategyStream<Member> stream ;
    PersistenceStrategyMongoDB<Member> mongoDB ;

    Member[] member = {new ConcreteMember(1),new ConcreteMember(2),new ConcreteMember(3) };


   @BeforeEach
    void setUp() throws ContainerException {
       main = new Main();
       client = new Client();
       container = Container.getContainer();


       stream = new PersistenceStrategyStream<>();
       mongoDB = new PersistenceStrategyMongoDB<>();

       for(Member member: member){
           container.deleteMember(member.getID());
       }

   }

    @Test
    void pos_applyingPersistenceStragetyStream() throws ContainerException, PersistenceException {

       // Setting PersistenceStragetyStream on Container
        main.setStrategy(stream);

        //state of Container after adding Member to the List
        Assertions.assertEquals(0,container.size());
        client.addMember(1);
        Assertions.assertEquals(1,container.size());
        client.addMember(2);
        Assertions.assertEquals(2,container.size());
        client.addMember(3);
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
       PersistenceException e = Assertions.assertThrows(PersistenceException.class, container::store); // Message kann ueberprueft werden durch e.getmassage
       Assertions.assertThrows(PersistenceException.class, container::load); //Neue schriebtweise , ersetzt Lambda Expression

   }

   @Test
    void neg_usingPersistenceStragetyMongoDB() throws ContainerException {
       main.setStrategy(mongoDB);

       client.addMember(1);
       Assertions.assertEquals(1,container.size());
       client.addMember(2);
       Assertions.assertEquals(2,container.size());
       client.addMember(3);
       Assertions.assertEquals(3,container.size());

       Assertions.assertThrows(PersistenceException.class, container::store);
       Assertions.assertThrows(PersistenceException.class, container::load);

   }

   @Test
    void neg_wrongPath() throws PersistenceException, ContainerException {

       //change Location
       stream.setLocation("/Projectlol/SE1");
       //Set Strategy
       main.setStrategy(stream);

       client.addMember(1);
       Assertions.assertEquals(1,container.size());
       client.addMember(2);
       Assertions.assertEquals(2,container.size());
       client.addMember(3);
       Assertions.assertEquals(3,container.size());

       Assertions.assertThrows(PersistenceException.class, container::store);
       Assertions.assertThrows(PersistenceException.class, container::load);

   }
}
