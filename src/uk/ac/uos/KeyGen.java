package uk.ac.uos;

import java.math.BigInteger;
import java.util.Random;

public class KeyGen {

    private final static BigInteger one = new BigInteger("1");

    private BigInteger p, q, n, phi, d, c;
    private BigInteger e = BigInteger.valueOf(65537);
    private int bitSize = 256;
    private int eBitSize = 256;
    private Random rando = new Random();

    //Generate PRNG primes
    void RSA() {
        p = probPrime(p);
        q = probPrime(q);
        n = p.multiply(q);
        phi = p.subtract(one).multiply(q.subtract(one));




        System.out.println(q);
        System.out.println(p);
        System.out.println(n);
        System.out.println(phi);
        System.out.println("this is E: " +e);
        System.out.println("this is C: " +c);

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

        } else System.out.println("this is phi " +phi+ "\n" + "this is e: " +e);
            return euclid(e, phi.mod(e));


    }
    private BigInteger probPrime(BigInteger a){
        a = BigInteger.probablePrime(bitSize, rando);
        System.out.println("this is A: " + a);

        return a;
    }
}
