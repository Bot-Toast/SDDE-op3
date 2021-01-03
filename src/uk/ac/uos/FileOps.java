package uk.ac.uos;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static uk.ac.uos.BagOfHolding.prvKeyLoad;
import static uk.ac.uos.BagOfHolding.pubKeyLoad;
import uk.ac.uos.KeyOps;


public class FileOps {

    //SUPER SECRET SQUIRREL KEY STORE...

    public void writeKeysToFile(File filePath, String key, String mod) throws IOException {
        filePath.getParentFile().mkdirs();

        FileWriter fos = new FileWriter(filePath);
        fos.write(mod);
        fos.write("\n");
        fos.write(key);
        fos.flush();
        fos.close();
    }


    public void pubKeyLoad(File pubKeyPath)  {
        try {
            //Reads key from disk and stores in list.
            String exp64, pubModU64;
            Scanner input1 = new Scanner(pubKeyPath);

            while (input1.hasNextLine()) {
                String temp1 = input1.nextLine();
                pubKeyLoad.add(temp1);

            }

            //Loads and encodes!
            exp64 = BagOfHolding.pubKeyLoad.get(1);
            pubModU64 = BagOfHolding.pubKeyLoad.get(0);
            BigInteger expBI = Encoding.b64Decoder(exp64);
            BagOfHolding.pubKeyBigInt[1] = expBI;
            BigInteger pubModUBI = Encoding.b64Decoder(pubModU64);
            BagOfHolding.pubKeyBigInt[0] = pubModUBI;

        }catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

    }

    public void prvKeyLoad() {
        //File pvKeyLoc = (new File(System.getProperty("user.home"), ".\\Roaming\\private.key")); (JUST IN CASE)
        KeyOps kO = new KeyOps();
        File koFile = kO.getPvKeyLoc();
        String prvModU64, prv64;
try{
            //Reads key from disk and stores in list.

            Scanner input2 = new Scanner(koFile);

            while (input2.hasNextLine()) {
                String temp1 = input2.nextLine();
                prvKeyLoad.add(temp1);

            } } catch (FileNotFoundException e) {
        e.printStackTrace();
    }


    //Loads and decodes!
        prvModU64 = BagOfHolding.prvKeyLoad.get(0);
        prv64 = BagOfHolding.prvKeyLoad.get(1);
        BigInteger prvBI = Encoding.b64Decoder(prv64);
        BagOfHolding.prvKeyBigInt[1] = prvBI;
        BigInteger prvModUbi = Encoding.b64Decoder(prvModU64);
        BagOfHolding.prvKeyBigInt[0] = prvModUbi;
        System.out.println(prvModUbi);
        System.out.println(prvBI);
        System.out.println(BagOfHolding.pubKeyBigInt[0]);
        System.out.println(BagOfHolding.pubKeyBigInt[1]);



}


    //Method to read files in line by line, storing them in a list.
    public void textReader(File fileP) {

        try{

       BufferedReader bfr = new BufferedReader(new FileReader(fileP));
        String tikka; //String that holds the buffered input text


        while ((tikka = bfr.readLine()) != null) {
            String delimiter = (System.getProperty("line.separator"));
            String[] daRay = tikka.split(delimiter);
            BagOfHolding.fileReadList.add(tikka);

        }
            //potential buffer? program broke with the removal of this For Each.
            for (String madras : BagOfHolding.fileReadList){
                if (!madras.isEmpty()) {
                    BagOfHolding.fileWriteList.add(madras);
                    System.out.println(BagOfHolding.fileWriteList.size());
                }
        }

        }catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

    }


    //Overloaded method that Encrypts or Decrypts (depending on parameter passed) and writes the result to disk.
    public void fileWriter(File f2, String input)  {


        f2.getParentFile().mkdirs();
        BufferedWriter bfWriter = null;
        try {
            bfWriter = new BufferedWriter(new FileWriter(f2));


            //temp byte arrays used for conversion.
            byte[] str2Byte;
            byte[] big2Byte;

            //temp Vars used for encoding and crypto.
            BigInteger mesSage;
            BigInteger cipHer;
            String cipherStr;

            if (input.equals("1")) {

                //Loops encryption
                for (String masala : BagOfHolding.fileWriteList) {
                    System.out.println("THIS IS MASALA : " +masala);
                    str2Byte = masala.getBytes(StandardCharsets.US_ASCII);
                    mesSage = new BigInteger(str2Byte);
                    cipHer = CryptoOps.encryptFile(mesSage);
                    cipherStr = Encoding.b64Encoder(cipHer);
                    System.out.println(cipherStr);

                    //writerOps
                    bfWriter.write(cipherStr);
                    bfWriter.newLine();
                    bfWriter.flush();



                }

                BagOfHolding.fileReadList.clear();
                BagOfHolding.fileWriteList.clear();

            } else if (input.equals("2")) {

                //loops decryption
                for (String birayani : BagOfHolding.fileWriteList) {
                    cipHer = Encoding.b64Decoder(birayani);
                    mesSage = CryptoOps.decryptFile(cipHer);
                    big2Byte = mesSage.toByteArray();
                    String encStr = new String(big2Byte, StandardCharsets.US_ASCII);

                    //writerOps
                    bfWriter.write(encStr);
                    bfWriter.newLine();
                    bfWriter.flush();


                }
                BagOfHolding.fileReadList.clear();
                BagOfHolding.fileWriteList.clear();
            }
            else{
                System.out.println("Please select an appropriate option.");
            }


        }catch (IOException e)
            { e.printStackTrace(); }

        finally {
            BagOfHolding.fileWriteList.clear();
            System.out.println("File Write Complete");
            if (bfWriter != null) {
                System.out.println("Closing Writer");

                try { bfWriter.close(); }

                catch (IOException e)   {
                    e.printStackTrace();
                }

            } else {
                System.out.println("The writer did a wrong");

            }


        }


    }

}










