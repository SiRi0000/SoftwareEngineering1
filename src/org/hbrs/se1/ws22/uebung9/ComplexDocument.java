package org.hbrs.se1.ws22.uebung9;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ComplexDocument implements Document{
    protected ArrayList<Document> list = new ArrayList<Document>();

    @Override
    public int size() throws UnsupportedEncodingException {
        int size = 0;
        for (Document doc : list) {
            size += doc.size();

        }
        return size;
    }

    public void addDocument(Document doc) {
        list.add(doc);
    }

    public void removeDocument(Document doc) {
        list.remove(doc);
    }


}
