package org.hbrs.se1.ws22.uebung9;

import java.io.UnsupportedEncodingException;

public interface setGetDocument extends Document {
    void setID(int id);
    int getID();

    @Override
    int size() throws UnsupportedEncodingException;
}

