package uk.ac.uos;


import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        FileOps fO = new FileOps();

        KeyOps kg = new KeyOps();


       /* Scanner kbInput = new Scanner(System.in);
        System.out.println("please choose destination folder for public key: ");
        String pbPath = kbInput.nextLine();
        System.out.println("please choose destination folder for private key: ");
        String prvPath = kbInput.nextLine();
        kbInput.close();

        kg.RSAKeyGen(pbPath, prvPath); */


        Scanner input1 = new Scanner(new File("C:\\Users\\Blyat\\Documents\\public.key"));
        Scanner input2 = new Scanner(new File("C:\\Users\\Blyat\\Documents\\private.key"));
        Scanner fileIn = new Scanner(new File("C:\\Users\\Blyat\\Documents\\input.txt"));


        String exp64;
        String modU64;
        String prv64;


        kg.pubKeyLoad(input1);
        exp64 = BagOfHolding.pubKeyLoad.get(1);
        kg.prvKeyLoad(input2);
        modU64 = BagOfHolding.prvKeyLoad.get(0);
        prv64 = BagOfHolding.prvKeyLoad.get(1);

        BigInteger expBI = Encoding.b64Decoder(exp64);
        BagOfHolding.pubKeyBigInt[1] = expBI;
        System.out.println("this is pub exp: " + expBI);
        BigInteger modUBI = Encoding.b64Decoder(modU64);
        BagOfHolding.pubKeyBigInt[0] = modUBI;
        System.out.println("this is prv mod: " + modUBI);
        BigInteger prvBI = Encoding.b64Decoder(prv64);
        BagOfHolding.prvKeyBigInt[1] = prvBI;
        System.out.println("this is prv exp: " + prvBI);


        FileOps.fileReadToEncrypt();

        /* byte[] thbyTe = new byte[128];
        InputStream is = new FileInputStream("C:\\Users\\Blyat\\Documents\\output.txt");
        OutputStream os = new FileOutputStream("C:\\Users\\Blyat\\Documents\\output1.txt");
        int readBytes = 0;

        while ((readBytes = is.read(thbyTe)) != -1) {

            BigInteger ciph = new BigInteger(thbyTe, 0, readBytes);
            System.out.println(ciph);

            BigInteger decrypted = Decrypt.decryptFile(ciph, prvBI, modUBI);
            String x = Encoding.bigIntToBytes(decrypted);
            System.out.println("this message is decrypted?: " + x);
        }


         while (fileIn.hasNextLine() == true) {
                String temp2 = fileIn.nextLine();
                BagOfHolding.holdThings = temp2.getBytes(StandardCharsets.US_ASCII);

                BigInteger ciph = new BigInteger(String.valueOf());
                System.out.println(ciph);

                BigInteger decrypted = Decrypt.decryptFile(ciph, prvBI, modUBI);
                String x = Encoding.bigIntToBytes(decrypted);
                System.out.println("this message is decrypted?: " + x);
            }








       }






        /* System.out.println("this is Plaintext: " + str);
        String str = null;
        byte[] getmebytes;
        getmebytes = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(getmebytes.length + " bytes");

        // kg.RSAKeyGen(tempArrB); */

    }
}