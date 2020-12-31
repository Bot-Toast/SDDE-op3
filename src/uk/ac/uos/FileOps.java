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

        while ((readBytes = isToEncrypt.read(fileBuffer1)) != -1) {


            BigInteger temp3 = new BigInteger(fileBuffer1, 0, readBytes);
            System.out.println("dis read temp3 : " + temp3);


            BigInteger expOWN = BagOfHolding.pubKeyBigInt[1];
            BigInteger modUBI = BagOfHolding.pubKeyBigInt[0];
            BigInteger prvOwn = BagOfHolding.prvKeyBigInt[1];
            BigInteger f = Encrypt.encryptFile(fileBuffer1, expOWN, modUBI);
            System.out.println("encrypt : " + f + " HEHEHHE");
            System.out.println(f);
            byte[] bigg = f.toByteArray();
            String bis = Encoding.b64Clone(bigg);
            System.out.println(bis);

          //String cg = Encoding.b64DecoderClone(fcc);
          //  System.out.println(cg);

          //  byte[] tj = f.toByteArray();
         //   String fc = new String(tj, StandardCharsets.ISO_8859_1);
             BagOfHolding.stringArray.add(bis);
                decryptWriteFilesBack();

            /*  String tis = Encoding.b64Encoder(f);
            BigInteger sti = Encoding.b64Decoder(tis);
            BigInteger frr = Decrypt.decryptFile(sti, prvOwn, modUBI);
            System.out.println("this is STI   " +sti);
            byte[] thini = frr.toByteArray();
            String sdt = new String(thini);
            BagOfHolding.stringArray.add(sdt);
            System.out.println(sdt); */


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

        Scanner sc = new Scanner("C:\\Users\\Blyat\\Documents\\output.txt");

        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            byte[] f = s.getBytes();
            String z = Encoding.b64DecoderClone(f);
            System.out.println(z);



        }
    }
}









