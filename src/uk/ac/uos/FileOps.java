package uk.ac.uos;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static uk.ac.uos.BagOfHolding.prvKeyLoad;
import static uk.ac.uos.BagOfHolding.pubKeyLoad;


public class FileOps {

    //SUPER SECRET SQUIRREL KEY STORE...
    private static File pvKeyLoc = (new File(System.getProperty("user.home"), ".\\Roaming\\private.key"));

    public static void writeKeysToFile(File filePath, String key, String mod) throws IOException {
        filePath.getParentFile().mkdirs();

        FileWriter fos = new FileWriter(filePath);
        fos.write(mod);
        fos.write("\n");
        fos.write(key);
        fos.flush();
        fos.close();
    }


    public static void pubKeyLoad(String pubKeyPath) throws FileNotFoundException {

        //Reads key from disk and stores in list.
        String exp64, pubModU64;
        Scanner input1 = new Scanner(new File(pubKeyPath));

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


    }

    public static void prvKeyLoad() throws FileNotFoundException {

        //Reads key from disk and stores in list.
        String prvModU64 , prv64;
        Scanner input2 = new Scanner(pvKeyLoc);

        while (input2.hasNextLine()) {
            String temp1 = input2.nextLine();
            prvKeyLoad.add(temp1);

        }

        //Loads and decodes!
        prvModU64 = BagOfHolding.prvKeyLoad.get(0);
        prv64 = BagOfHolding.prvKeyLoad.get(1);
        BigInteger prvBI = Encoding.b64Decoder(prv64);
        BagOfHolding.prvKeyBigInt[1] = prvBI;
        BigInteger prvModUbi = Encoding.b64Decoder(prvModU64);
        BagOfHolding.prvKeyBigInt[0] = prvModUbi;

    }

    //Method to read files in line by line, storing them in a list.
    public static void textReader() throws IOException {

        File fileP = new File("C:\\Users\\Blyat\\Documents\\output.txt");
        Scanner sce = new Scanner(fileP);

        String tikka; //String that holds the buffered input text


        while ((sce.hasNextLine())) {
            tikka = sce.nextLine();
            BagOfHolding.fileReadList.add(tikka);
        }
            //potential buffer? program broke with the removal of this For Each.
            for (String madras : BagOfHolding.fileReadList){
                if (!madras.isEmpty()) {
                    BagOfHolding.fileWriteList.add(madras);
                }
        }

    }


    //Overloaded method that Encrypts or Decrypts (depending on parameter passed) and writes the result to disk.
    public static void fileWriter(String input)  {

        File fl = new File("C:\\Users\\Blyat\\Documents\\oof.txt");
        fl.getParentFile().mkdirs();
        BufferedWriter bfWriter = null;
        try {
            bfWriter = new BufferedWriter(new FileWriter(fl));


            //temp byte arrays used for conversion.
            byte[] str2Byte;
            byte[] byte2Str;
            byte[] big2Byte;

            //temp Vars used for encoding and crypto.
            BigInteger mesSage;
            BigInteger cipHer;
            String aStr;
            String cipherStr;

            if (input.equals("1")) {

                //Loops encryption
                for (String masala : BagOfHolding.fileWriteList) {
                    str2Byte = masala.getBytes(StandardCharsets.US_ASCII);
                    mesSage = new BigInteger(str2Byte);
                    cipHer = CryptoOps.encryptFile(mesSage);
                    cipherStr = Encoding.b64Encoder(cipHer);


                    //writerOps
                    bfWriter.write(cipherStr);
                    bfWriter.newLine();
                    bfWriter.flush();
                }


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

            }else{
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










