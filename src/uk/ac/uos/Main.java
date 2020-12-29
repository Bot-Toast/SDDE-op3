package uk.ac.uos;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        FileOps fO = new FileOps();

        KeyGen kg = new KeyGen();



        Scanner input1 = new Scanner(new File("C:\\Users\\Blyat\\Documents\\public.key"));
        Scanner input2 = new Scanner(new File("C:\\Users\\Blyat\\Documents\\private.key"));
        List<String> pubKeyLoad = new ArrayList<String>();
        List<String> prvKeyLoad = new ArrayList<String>();
        String exp64;
        String modU64;
        String prv64;







        prvKeyLoad.add(input2.nextLine());
        while (input1.hasNextLine()) {
            String temp1 = input1.nextLine();
            pubKeyLoad.add(temp1);


        }

        while (input2.hasNextLine()) {
            String temp1 = input2.nextLine();
            prvKeyLoad.add(temp1);


        }


        exp64 = pubKeyLoad.get(1);
        modU64 = pubKeyLoad.get(0);
        prv64 = prvKeyLoad.get(1);

       BigInteger expBI = Encoding.b64Decoder(exp64);
       BigInteger modUBI = Encoding.b64Decoder(modU64);
       BigInteger prvBI = Encoding.b64Decoder(prv64);
        System.out.println("exponent: "+expBI);
        System.out.println("modulus: " +modUBI);
        System.out.println("decode: " +prvBI);


        StringBuilder sb = new StringBuilder();

        Scanner fileIn = new Scanner(new File("C:\\Users\\Blyat\\Documents\\input.txt"));
       while (fileIn.hasNextLine()) {
           String temp2 = fileIn.nextLine();
           //fileIn.forEachRemaining(s -> sb.append(s).append(temp2));
           System.out.println("this is TEMP: "+temp2);
           byte[] bMSMA = temp2.getBytes(StandardCharsets.US_ASCII);
           BigInteger strnig = new BigInteger(bMSMA);
           System.out.println(strnig);
           BigInteger bigsuk = Encrypt.encrypt(strnig, expBI, modUBI);
           System.out.println(bigsuk);
           String medsuk = Encoding.b64Encoder(bigsuk);
           System.out.println(medsuk);
           BigInteger tinysuk = Encoding.b64Decoder(medsuk);
           System.out.println(tinysuk);
           BigInteger smallsuck = Decrypt.decrypt(bigsuk, prvBI, modUBI);
           System.out.println(smallsuck);

       }






        /* System.out.println("this is Plaintext: " + str);
        String str = null;
        byte[] getmebytes;
        getmebytes = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(getmebytes.length + " bytes");

        // kg.RSAKeyGen(tempArrB); */

    }
}
