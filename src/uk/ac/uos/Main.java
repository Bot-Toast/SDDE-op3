package uk.ac.uos;


import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        FileOps fO = new FileOps();

        KeyOps kg = new KeyOps();

     /*

        Scanner kbInput = new Scanner(System.in);
        System.out.println("please choose destination folder for public key: ");
        String pbPath = kbInput.nextLine();
        System.out.println("please choose destination folder for private key: ");
        String prvPath = kbInput.nextLine();
        kbInput.close();

        kg.RSAKeyGen(pbPath, prvPath);


      */

        Scanner input1 = new Scanner(new File("C:\\Users\\Blyat\\Documents\\public.key"));
        Scanner input2 = new Scanner(new File("C:\\Users\\Blyat\\Documents\\private.key"));
        Scanner fileIn = new Scanner(new File("C:\\Users\\Blyat\\Documents\\input.txt"));


        String exp64;
        String pubModU64;
        String prvModU64;
        String prv64;


        kg.pubKeyLoad(input1);
        exp64 = BagOfHolding.pubKeyLoad.get(1);
        kg.prvKeyLoad(input2);
        pubModU64 = BagOfHolding.pubKeyLoad.get(0);
        prvModU64 = BagOfHolding.prvKeyLoad.get(0);
        prv64 = BagOfHolding.prvKeyLoad.get(1);
        System.out.println(exp64);
        System.out.println(pubModU64);
        System.out.println(prvModU64);
        System.out.println(prv64);


        BigInteger expBI = Encoding.b64Decoder(exp64);
        BagOfHolding.pubKeyBigInt[1] = expBI;
        System.out.println("this is pub exp: " + expBI);
        BigInteger pubModUBI = Encoding.b64Decoder(pubModU64);
        BagOfHolding.pubKeyBigInt[0] = pubModUBI;
        System.out.println("this is pub mod: " + pubModUBI);
        BigInteger prvBI = Encoding.b64Decoder(prv64);
        BagOfHolding.prvKeyBigInt[1] = prvBI;
        System.out.println("this is prv exp: " + prvBI);
        BigInteger prvModUbi = Encoding.b64Decoder(prvModU64);
        BagOfHolding.prvKeyBigInt[0] = prvModUbi;
        System.out.println("this is prv mod: " + prvModUbi);



       FileOps.fileReadToDecrypt();


    }
}