package uk.ac.uos;

import java.beans.DefaultPersistenceDelegate;
import java.io.*;
import java.math.BigInteger;


import java.nio.charset.StandardCharsets;
import java.util.*;


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



    public static void decryptWriteFilesBack () throws IOException {
        File fp = new File("C:\\Users\\Blyat\\Documents\\output.txt");
       PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fp)));
        for (Object stringOut : BagOfHolding.stringWriteList) {
            pw.write((String) stringOut);



        }
        pw.flush();
        pw.close();
    }

    public static void fileReadToDecrypt() throws IOException {


        File fileC = new File("C:\\Users\\Blyat\\Documents\\output.txt");
        Scanner sc = new Scanner(fileC);
        BufferedWriter bfr = new BufferedWriter(new FileWriter("C:\\Users\\Blyat\\Documents\\oof.txt"));
        BigInteger modUBI = BagOfHolding.prvKeyBigInt[0];
        BigInteger expOWN = BagOfHolding.prvKeyBigInt[1];


        while (sc.hasNextLine()) {

            String s = sc.nextLine();
            byte[] f = s.getBytes(StandardCharsets.UTF_8);
            String z = Encoding.b64DecoderClone(f);
            BigInteger zi = new BigInteger(z);
            BigInteger zio = CryptoOps.decryptFile(zi, expOWN, modUBI);
            byte[] bistr = zio.toByteArray();
            String zipoo = new String(bistr, StandardCharsets.UTF_8);


            bfr.write(zipoo);
            bfr.write(System.getProperty("line.separator"));

            }

        bfr.flush();
        bfr.close();
    }

    public static void pleaseWork() throws IOException {
    File fileC = new File("C:\\Users\\Blyat\\Documents\\input.txt");
    Scanner sce = new Scanner(fileC);
    BufferedWriter bfr = new BufferedWriter(new FileWriter("C:\\Users\\Blyat\\Documents\\output.txt"));


        String tikka; //String that holds the buffered input text
        while ((sce.hasNextLine() == true)) {
            tikka = sce.nextLine();
            String delimiter = System.getProperty("line.separator"); //splits by white space
            String[] tempArr = tikka.split(delimiter); //temp array holding entries of split text
            for (String madras : tempArr)
                if (!madras.isEmpty() && madras != null) {
                    BagOfHolding.tempArrs1.add(madras);
                }
        }
                    for (String fs : BagOfHolding.tempArrs1) {
                        System.out.println(fs);
                        byte[] sm = fs.getBytes(StandardCharsets.US_ASCII);
                        BigInteger m = new BigInteger(sm);
                        BigInteger z = CryptoOps.encryptFile(m);
                        String zz = (String.valueOf(z));
                        byte[] zzz = zz.getBytes(StandardCharsets.UTF_8);


                        String zzzz = Encoding.b64Clone(zzz);


                        bfr.write(zzzz);
                        bfr.newLine();



                }
              bfr.flush();
              bfr.close();
        }

    private void fileWriter(String writeInput, String path) throws IOException {

        BufferedWriter bfWriter = new BufferedWriter(new FileWriter(path));

    }

}










