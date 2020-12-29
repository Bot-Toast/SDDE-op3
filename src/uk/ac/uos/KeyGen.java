package uk.ac.uos;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.EmptyStackException;
import java.util.Random;

public class KeyGen {

    FileOps fO = new FileOps();

    private final static BigInteger one = new BigInteger("1");
    private final static BigInteger zero = new BigInteger("0");


    private BigInteger p, q, n, phi, d, c;
    private BigInteger e = BigInteger.valueOf(65537);
    private int bitSize = 256;
    private int eBitSize = 256;
    private Random rando = new Random();

    Encrypt ec = new Encrypt();
    Decrypt dc = new Decrypt();

    //Generate PRNG primes
    public  void RSAKeyGen() throws IOException {
        p = probPrime(p);
        q = probPrime(q);
        n = p.multiply(q);
        phi = p.subtract(one).multiply(q.subtract(one));
        d = e.modInverse(phi);
        BigInteger x = euclid(phi, e);

        String pKey = Encoding.b64Encoder(e);
        String modulus = Encoding.b64Encoder(n);
        String prvKey = Encoding.b64Encoder(d);
        System.out.println("This is exponent: " +pKey+ "\n");
        System.out.println("This is modulus: " +modulus+ "\n");
        System.out.println("This is decode: " +prvKey+ "\n");


      fO.writeToFile("C:\\Users\\Blyat\\Documents\\public", pKey, modulus);
      fO.writeToFile("C:\\Users\\Blyat\\Documents\\private", prvKey, modulus);





       /* BigInteger mestr = null;// = new BigInteger();
        System.out.println("this is BIGINT before encryption: " +mestr);
        BigInteger f = ec.encrypt(mestr,e,n);
        System.out.println("this is ENCRYPTED: " +f);
        String fb = Encoding.b64Encoder(f);
        System.out.println("this is base64 encoded: " +fb);
        BigInteger fbc = Encoding.b64Decoder(fb);
        System.out.println("this is base64 decoded: " +fbc);

        BigInteger g = dc.decrypt(fbc,d,n);
        System.out.println("\n" + "THIS IS DECRYPTED: " +g+ "\n");


        byte[] backout = g.toByteArray();

        String srt = new String(backout);
        System.out.println("this is Text is encoded back to Unicode: " +srt);*/










    }

    private BigInteger phiFinder(BigInteger p, BigInteger q){
        BigInteger thi = p.subtract(one).multiply(q.subtract(one));
        return thi;
    }

    private void euler(BigInteger p,BigInteger q){
       BigInteger n = p.multiply(q);
       BigInteger phi = p.subtract(one).multiply(q.subtract(one));
        BigInteger a = BigInteger.valueOf(5);
        BigInteger z = a.modPow(phi, n);
        System.out.println("this is Z: " +z);

    }

    private BigInteger eDerive(BigInteger phi) {
        BigInteger z = BigInteger.probablePrime(eBitSize, rando);

        if (phi.gcd(z).equals(BigInteger.ONE)) {

            System.out.println("this is z: " + z);
            return z;

        } else System.out.println("this is z: " +z+ "\n" + "this is phi: " +phi); return eDerive(phi);

    }


    private BigInteger euclid(BigInteger phi, BigInteger e){
        if (e == BigInteger.ZERO){

      //      System.out.println("this is e: " + e);
            return phi;

        } if (phi == BigInteger.ZERO) {

            System.out.println("ERROR");

        } else;
            return euclid(e, phi.mod(e));


    }


    private BigInteger probPrime(BigInteger a){
        a = BigInteger.probablePrime(bitSize, rando);


        return a;

    }
}
