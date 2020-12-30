package uk.ac.uos;

import java.math.BigInteger;

public class Decrypt {

    public static BigInteger decryptFile(BigInteger c, BigInteger d, BigInteger n){
        BigInteger dCry;

        return dCry = c.modPow(d, n);


    }
}
