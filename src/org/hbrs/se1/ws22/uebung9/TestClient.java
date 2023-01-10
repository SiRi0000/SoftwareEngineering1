package org.hbrs.se1.ws22.uebung9;

import java.io.UnsupportedEncodingException;

public class TestClient {
    public static void main(String[] args) throws UnsupportedEncodingException {

        //Create Component for test
        GraficDocument doc4 = new GraficDocument("localhost:8080");
        doc4.setID(4);

        TextDocument doc5 = new TextDocument("Software Engineering I ist eine Vorlesung in den Studiengaengen BIS und BCS", TextDocument.Encoding.UTF32);
        doc5.setID(5);

        ComplexDocument doc3 = new ComplexDocument();

        TextDocument doc2 = new TextDocument("Die Klausur im Fach SE findet bald statt", TextDocument.Encoding.UTF8);

        ComplexDocument doc0 = new ComplexDocument();

        //Build up a tree structure
        //Add documents to complex document

        doc3.addDocument(doc4);
        doc3.addDocument(doc5);

        doc0.addDocument(doc2);
        doc0.addDocument(doc3);

        //Caluculate the size of the tree structure

        System.out.println("Size of the tree structure: " + doc0.size() + " Bytes");

    }
}
