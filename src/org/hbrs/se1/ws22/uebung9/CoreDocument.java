package org.hbrs.se1.ws22.uebung9;

import java.io.UnsupportedEncodingException;

public abstract class CoreDocument implements setGetDocument{
    private int id;

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public abstract int size() throws UnsupportedEncodingException;
}
