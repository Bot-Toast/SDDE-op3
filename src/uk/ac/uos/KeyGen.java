package uk.ac.uos;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.EmptyStackException;
import java.util.Random;

public class KeyGen {

    private final static BigInteger one = new BigInteger("1");

    private BigInteger p, q, n, phi, d, c;
    private BigInteger e = BigInteger.valueOf(65537);
    private int bitSize = 256 ;
    private int eBitSize = 256;
    private Random rando = new Random();

    Encrypt ec = new Encrypt();
    Decrypt dc = new Decrypt();

    //Generate PRNG primes
    public  void RSAKeyGen(byte[] mes) {
        p = probPrime(p);
        q = probPrime(q);
        n = p.multiply(q);
        phi = p.subtract(one).multiply(q.subtract(one));

        d = e.modInverse(phi);
        BigInteger x = euclid(phi, e);
        System.out.println(x);


        BigInteger mestr = new BigInteger(mes);
        System.out.println("this is PLAINTEXT: " +mestr);
        BigInteger f = ec.encrypt(mestr,e,n);
        String fb = Encoding.b64Encoder(f);
        BigInteger fbc = Encoding.b64Decoder(fb);


        BigInteger g = dc.decrypt(fbc,d,n);


        byte[] backout = g.toByteArray();

        String srt = new String(backout);
        System.out.println("this is SRT: " +srt);

        System.out.println("this is PLAINTEXT: " +mes);
        System.out.println("this is ENCRYPTED: " +f);
        System.out.println("this is FB: " +fb);
        System.out.println("this is FBC: " +fbc);
        System.out.println("THIS IS DECRYPTED: " +g);





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

            System.out.println("this is e: " + e);
            return phi;

        } if (phi == BigInteger.ZERO) {

            System.out.println("ERROR");

        } else System.out.println("this is phi " +phi+ "\n" + "this is e: " +e);
            return euclid(e, phi.mod(e));


    }


    private BigInteger probPrime(BigInteger a){
        a = BigInteger.probablePrime(bitSize, rando);
        System.out.println("this is A: " + a);

        return a;

    }
}
