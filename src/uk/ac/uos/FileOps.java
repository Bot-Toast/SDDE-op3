package uk.ac.uos;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileOps {

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


        BufferedInputStream is = new BufferedInputStream(new FileInputStream("C:\\Users\\Blyat\\Documents\\input.txt"));

        int readBytes;
        byte[] bamS = new byte[192];

        while ((readBytes = is.read(bamS)) != -1) {


            BigInteger temp3 = new BigInteger(bamS, 0, readBytes);
            System.out.println("dis read temp3 : " + temp3);


            BigInteger expOWN = BagOfHolding.pubKeyBigInt[1];
            BigInteger modUBI = BagOfHolding.pubKeyBigInt[0];
            BigInteger prvOwn = BagOfHolding.prvKeyBigInt[1];
            BigInteger f = Encrypt.encryptFile(temp3, expOWN, modUBI);
            System.out.println("encrypt : " + f + " HEHEHHE");
            String tis = Encoding.b64Encoder(f);
            //System.out.println(tis);
            writeFiles(tis);


        }
        is.close();
    }

        public static void writeFiles (String tis) throws IOException {

            String fiP = "C:\\Users\\Blyat\\Documents\\output.txt";
            File fp = new File(fiP);
            fp.getParentFile().mkdirs();

            FileWriter fos = new FileWriter(fp + ".txt");
            fos.write(tis);
            fos.flush();
            fos.close();
        }

       /* while (fileIn.hasNextLine()) {
            String temp2 = fileIn.nextLine();

            BagOfHolding.holdThings = temp2.getBytes(StandardCharsets.US_ASCII);
            BigInteger temp3 = new BigInteger(BagOfHolding.holdThings);



            BigInteger expOWN = BagOfHolding.pubKeyBigInt[1];
            BigInteger modUBI = BagOfHolding.pubKeyBigInt[0];
            BagOfHolding.holdThings = temp2.getBytes(StandardCharsets.US_ASCII);
            BigInteger f = Encrypt.encryptFile(temp3,expOWN,modUBI);
            String fb = Encoding.b64Encoder(f);



            File fi = new File("C:\\Users\\Blyat\\Documents\\output");
            fi.getParentFile().mkdirs();
            FileWriter fis = new FileWriter(fi + ".txt");
            fis.write(fb);
            fis.flush();
            fis.close();


        }*/


    }






