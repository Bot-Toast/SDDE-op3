package uk.ac.uos;

import java.math.BigInteger;

public class Encrypt {


   public static byte[] encryptFile(byte[] m, BigInteger e, BigInteger n) {

        return (new BigInteger(m).modPow(e, n)).toByteArray();

    }

}
