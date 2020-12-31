package uk.ac.uos;

import java.io.*;
import java.math.BigInteger;


import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;


public class FileOps {

       private static int readBytes;




    public static void writeKeysToFile(String filePath, String key, String mod) throws IOException {
        File f = new File(filePath);
        f.getParentFile().mkdirs();

        FileWriter fos = new FileWriter(f + ".key");
        fos.write(mod);
        fos.write("\n");
        fos.write(key);
        fos.flush();
        fos.close();
    }


    public static void fileReadToEncrypt() throws IOException {



        BufferedInputStream isToEncrypt = new BufferedInputStream(new FileInputStream("C:\\Users\\Blyat\\Documents\\input.txt"));


        byte[] fileBuffer1 = new byte[384];
        int readBytes;
        while ((readBytes = isToEncrypt.read(fileBuffer1)) != -1) {

            String s = Encoding.b64Clone(fileBuffer1);

            System.out.println("dis read temp3 : " + s);
            BagOfHolding.stringArray.add(s);
            decryptWriteFilesBack();


           /* BigInteger expOWN = BagOfHolding.pubKeyBigInt[1];
            BigInteger modUBI = BagOfHolding.pubKeyBigInt[0];
            BigInteger prvOwn = BagOfHolding.prvKeyBigInt[1];
            BigInteger f = Encrypt.encryptFile(fileBuffer1, expOWN, modUBI);
            System.out.println("encrypt : " + f + " HEHEHHE");
            System.out.println(f);
            byte[] bigg = f.toByteArray();
            String bis = Encoding.b64Clone(bigg);
            System.out.println(bis);


             BagOfHolding.stringArray.add(bis);
                decryptWriteFilesBack(); */


        }

        isToEncrypt.close();
    }


    public static void decryptWriteFilesBack () throws IOException {
        File fp = new File("C:\\Users\\Blyat\\Documents\\output.txt");
       PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fp)));
        for (String stringOut : BagOfHolding.stringArray) {
            pw.write(stringOut);
        }


        pw.flush();
        pw.close();
    }

    public static void fileReadToDecrypt() throws IOException {

        File fileC = new File("C:\\Users\\Blyat\\Documents\\output.txt");
        Scanner sc = new Scanner(fileC);

        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(s);
            byte[] f = s.getBytes();
            String z = Encoding.b64DecoderClone(f);
            System.out.println(z);



        }
    }
}









