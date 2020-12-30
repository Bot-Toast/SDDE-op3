package uk.ac.uos;

import java.math.BigInteger;

public class Encrypt {


   public static BigInteger encryptFile(BigInteger m, BigInteger e, BigInteger n) {
        BigInteger c;
        return c = m.modPow(e, n);

    }

}
