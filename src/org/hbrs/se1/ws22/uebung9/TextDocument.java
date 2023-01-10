package org.hbrs.se1.ws22.uebung9;

import java.io.UnsupportedEncodingException;

public class TextDocument extends CoreDocument{
    private String inhalt;
    private Encoding encoding;
    public TextDocument(String inhalt, Encoding encoding){
        this.inhalt = inhalt;
        this.encoding = encoding;
    }
    @Override
    public int size() throws UnsupportedEncodingException {

        if(encoding == Encoding.UTF8){
            byte [] bytes = inhalt.getBytes("UTF-8");
            return bytes.length;
        }
        else if(encoding == Encoding.UTF16){
            byte [] bytes = inhalt.getBytes("UTF-16");
            return bytes.length;
        }
        else{
            byte [] bytes = inhalt.getBytes("UTF-32");
            return bytes.length;
        }
    }
    public enum Encoding{
        UTF8, UTF16, UTF32
    }
}
