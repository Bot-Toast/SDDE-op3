package uk.ac.uos;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class Main {
    public static void main(String[] args) {

        KeyGen kg = new KeyGen();

        String str = "convert dis shit";
        byte[] getmebytes = str.getBytes(StandardCharsets.UTF_8);

        String strb = new String(getmebytes);
        System.out.println("THIS IS STRB: "+strb);



        kg.RSAKeyGen(getmebytes);


    }
}
