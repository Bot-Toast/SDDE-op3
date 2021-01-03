package uk.ac.uos;

import java.math.BigInteger;

public class CryptoOps {

    //Method to perform standard decryption
    public static BigInteger decryptFile(BigInteger c) {


        BigInteger n = BagOfHolding.prvKeyBigInt[0];
        BigInteger d = BagOfHolding.prvKeyBigInt[1];

            return c.modPow(d, n);


    }

    //Method to perform standard encryption.
    public static BigInteger encryptFile(BigInteger m) {


        BigInteger n = BagOfHolding.pubKeyBigInt[0];
        BigInteger e = BagOfHolding.pubKeyBigInt[1];


            return m.modPow(e, n);

    }

}
