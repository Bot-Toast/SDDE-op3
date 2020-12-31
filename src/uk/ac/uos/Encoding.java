package uk.ac.uos;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Encoding {


    public static String b64Encoder(BigInteger toEncode) {
        Base64.Encoder encoder = Base64.getEncoder();

        String thing = toEncode.toString();

        byte[] encodeBigIntBytes = toEncode.toByteArray();

        String encodedBytes = encoder.encodeToString(encodeBigIntBytes);

        return encodedBytes;

    }


    public static String b64Clone(byte[] toEncode) {

        byte[] encodedBytes = Base64.getEncoder().encode(toEncode);

        return new String(encodedBytes);

    }

    public static BigInteger b64Decoder(String toDecode) {

        byte[] bytese = Base64.getDecoder().decode(toDecode);

        String Xeee = new String(bytese);

        BigInteger bigInteger = new BigInteger(Xeee);

        return bigInteger;

    }

    public static String b64DecoderClone(byte[] toDecode) {

        byte[] bytese = Base64.getDecoder().decode(toDecode);

        return new String(bytese);

    }

    public static String utf8Encoder (BigInteger toEncode) {


        byte[] encodeBigIntBytes = toEncode.toByteArray();

        String encodedBytes = new String(encodeBigIntBytes, StandardCharsets.UTF_8);

        return encodedBytes;

    }

    public static String bigIntToBytes(BigInteger toEncode) throws UnsupportedEncodingException {

        byte[] encodeBigIntBytes = toEncode.toByteArray();

        System.out.println(encodeBigIntBytes.length);

        String encodedBytes = new String(encodeBigIntBytes, "UTF-8");

        return encodedBytes;

    }



    public static BigInteger strToBig(String line) {

        BigInteger strBGone = new BigInteger(line);

        return strBGone;

    }


    public static BigInteger bytesToBig(byte[] toDecode) {

        String Xeee = new String(toDecode);

        BigInteger bigInteger = new BigInteger(Xeee);

        return bigInteger;

    }

}
