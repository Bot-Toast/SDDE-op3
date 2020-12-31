package uk.ac.uos;

import java.math.BigInteger;

public class CryptoOps {

    public static BigInteger decryptFile(BigInteger c, BigInteger d, BigInteger n){

       BigInteger m;


        return m = c.modPow(d, n);


    }


    public static BigInteger encryptFile(BigInteger m) {

        BigInteger c;
        BigInteger n = BagOfHolding.pubKeyBigInt[0];
        BigInteger e = BagOfHolding.pubKeyBigInt[1];


        return c = m.modPow(e, n);

    }

}
