package uk.ac.uos;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileOps {

    public void writeToFile(String path, String key, String mod) throws IOException {
        File f = new File(path);
        f.getParentFile().mkdirs();

        FileWriter fos = new FileWriter(f + ".key");
        fos.write("<Modulus>");
        fos.write(mod);
        fos.write("<Modulus>");
        fos.write("\n");
        fos.write("<exponent>");
        fos.write(key);
        fos.write("<exponent>");
        fos.flush();
        fos.close();
    }

    public void fileRead(String path) throws IOException {
        File f = new File(path);


        FileReader fos = new FileReader(f, StandardCharsets.UTF_8);

    }



}
