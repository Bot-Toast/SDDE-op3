package uk.ac.uos;


import java.io.*;

public class Main {
    public static void main(String[] args) {

        KeyGen kg = new KeyGen();

        kg.RSAKeyGen();

/*
        File directory = new File(fileDirIn); //path to your folder  "C:\\Users\\Blyat\\Documents\\yellow"
        for (File files : directory.listFiles()) { // Loops all files within directory
            if (files.isFile()) { //Checks to see if it is a file                                         //This uses the Try and Resource which automatically closes stream once the program is finished.
                try (BufferedReader bfR = new BufferedReader(new FileReader(files.getAbsolutePath()))) {  //Gets the full path of the file for example C:\\user\pepehands.txt
                }
            }
        }

        //WRITES FILES
        //ran out of time to finish the recursive write... the program should write all the files into a single file though. So thats alright i guess?
        File textOut = new File(fileDirOut);
        try {
            PrintWriter pw =
                    new PrintWriter(
                            new BufferedWriter(
                                    new FileWriter(textOut)));
            //Foreach loop that iterates through the textArray to print lines one at a time. Using line separator and escaped \N so there is a double linebreak.
            for (String stringOut : LoadRegionalFormats.textArray) {
                pw.write(stringOut + System.lineSeparator() + "\n");
            }

            pw.close();
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
