package uk.ac.uos;

import java.math.BigInteger;

public class Decrypt {

    public static byte[] decryptFile(byte[] c, BigInteger d, BigInteger n){


        return (new BigInteger(c)).modPow(d, n).toByteArray();


    }
}
