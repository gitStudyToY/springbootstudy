package com.example.demo.exception;

public class BusiException extends RuntimeException {

    public BusiException(){
        super();
    }

    public BusiException(Throwable e) {
        super(e);
    }

    public BusiException(String str) {
        super(str);
    }

    public BusiException(String str,Throwable e){
        super(str,e);
    }

} 