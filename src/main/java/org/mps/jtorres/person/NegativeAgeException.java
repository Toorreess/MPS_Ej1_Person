package org.mps.jtorres.person;

public class NegativeAgeException extends RuntimeException{
    public NegativeAgeException(String e){
        super(e);
    }
}
