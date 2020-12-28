package uk.ac.uos;

import java.math.BigInteger;
import java.util.Random;

public class KeyGen {

    private BigInteger p, q, n, phi, e, d, c;
    private int bitSize = 3072;
    Random rando = new Random();

    //Generate PRNG primes
    KeyGen(int bitSize) {
        probPrime(q);
        probPrime(p);



    }
    BigInteger probPrime(BigInteger a){
        a = BigInteger.probablePrime(bitSize, rando);
        return a;
    }
}
