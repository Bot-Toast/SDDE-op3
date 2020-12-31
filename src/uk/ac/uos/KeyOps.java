package uk.ac.uos;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

import static uk.ac.uos.BagOfHolding.prvKeyLoad;
import static uk.ac.uos.BagOfHolding.pubKeyLoad;

public class KeyOps {



    private final static BigInteger one = new BigInteger("1");

    private BigInteger p, q, n, phi, d;
    private final BigInteger e = new BigInteger("65537");
    private int bitSize = 1536;
    private int eBitSize = 256;
    private Random rando = new Random();



    //Generate Crypto Values - with file paths for saving, PrvKey will be coded.
    public  void RSAKeyGen(String path1, String path2) throws IOException {
        p = probPrime(p);
        q = probPrime(q);
        n = p.multiply(q);
        phi = p.subtract(one).multiply(q.subtract(one));
        d = e.modInverse(phi);


        String pKey = Encoding.b64Encoder(e);
        String modulus = Encoding.b64Encoder(n);
        String prvKey = Encoding.b64Encoder(d);
        System.out.println("This is exponent: " +pKey+ "\n");
        System.out.println("This is modulus: " +modulus+ "\n");
        System.out.println("This is decode: " +prvKey+ "\n");


        FileOps.writeKeysToFile(path1, pKey, modulus);
        FileOps.writeKeysToFile(path2, prvKey, modulus);


    }

    public void prvKeyLoad(Scanner input2)

        {

        while (input2.hasNextLine()) {
            String temp1 = input2.nextLine();
            prvKeyLoad.add(temp1);
        }

    }

    public void pubKeyLoad(Scanner input1)

        {


        while (input1.hasNextLine()) {
            String temp1 = input1.nextLine();
            pubKeyLoad.add(temp1);


        }

    }


    //method to help keep code clean, but also add a bit of seed randomisation using nanoseconds.
    private BigInteger probPrime(BigInteger a){
        rando.setSeed(System.nanoTime());
        return a = BigInteger.probablePrime(bitSize, rando);

    }
}
