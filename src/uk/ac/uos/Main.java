package uk.ac.uos;


import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {


        KeyOps kO = new KeyOps();

       // Scanner kbInput = new Scanner(System.in);
      //  System.out.println("please choose destination folder for public key: ");
      //  String pbPath = kbInput.nextLine();
      //  kbInput.close();


      kO.RSAKeyGen("C:\\Users\\Blyat\\Documents\\public");
      //  FileOps.prvKeyLoad();
      //  FileOps.pubKeyLoad("C:\\Users\\Blyat\\Documents\\public.key");

         //3072bit key = 384 characters before shit happens.
      //   FileOps.textReader();
       //  FileOps.fileWriter("2");


    }
}