package com.example.demo;

import com.example.demo.exception.BusiException;

public class Test {

    public static void main(String[] args) {
        BusiException exception = new BusiException();
        throw new BusiException(exception);
    }

} 