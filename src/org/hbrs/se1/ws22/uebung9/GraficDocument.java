package org.hbrs.se1.ws22.uebung9;

import java.io.UnsupportedEncodingException;

public class GraficDocument extends CoreDocument{
    private String url;

    public GraficDocument(String url) {
        this.url = url;
    }
    @Override
    public int size()  {
        return 1200;
    }
}
