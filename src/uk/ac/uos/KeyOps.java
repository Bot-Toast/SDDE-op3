package uk.ac.uos;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;


public class KeyOps {



    private final  BigInteger one = new BigInteger("1");

    //Crypto Variables
    private  BigInteger p, q, n, phi, d;

    //65537 is a nice little Fermat number that is performant and it is industry standard as an exponent.
    private  final BigInteger e = new BigInteger("65537");

    //Fixed bitsize used with rando in probPrime function.
    private  final int bitSize = 1536;
    private  Random rando = new Random();


    private File pvKeyLoc = (new File(System.getProperty("user.home"), ".\\Roaming\\private"));

    //Method to generate Crypto values - path is passed in to save in the location user wants, PrvKey path will be hardcoded.
    public void RSAKeyGen(File path1) throws IOException {

        p = probPrime();
        q = probPrime();
        n = p.multiply(q);
        phi = p.subtract(one).multiply(q.subtract(one));
        d = e.modInverse(phi);


        //encoding to be saved as B64.
        String pKey = Encoding.b64Encoder(e);
        String modulus = Encoding.b64Encoder(n);
        String prvKey = Encoding.b64Encoder(d);

        //This code saves the .key files to disk.

        FileOps.writeKeysToFile(path1, pKey, modulus);
        FileOps.writeKeysToFile(pvKeyLoc, prvKey, modulus);



    }

    //Method to help keep code clean, but also to add a bit of seed randomisation using JVM time in nanoseconds.
    private BigInteger probPrime(){
        rando.setSeed(System.nanoTime());

        return BigInteger.probablePrime(bitSize, rando);

    }
    //getter
    public File getPvKeyLoc (){
        return this.pvKeyLoc;

    }
    //setter
    public void setPvKeyLoc(File pkLoc){
        this.pvKeyLoc = pkLoc;

    }

}
