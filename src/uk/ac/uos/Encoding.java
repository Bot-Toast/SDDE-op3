package uk.ac.uos;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Encoding {

    //Encodes keys & files into b64
    public static String b64Encoder(BigInteger toEncode) {
        Base64.Encoder encoder = Base64.getEncoder();

        String thing = toEncode.toString();

        byte[] encodeBigIntBytes = thing.getBytes(StandardCharsets.US_ASCII);

        return encoder.encodeToString(encodeBigIntBytes);

    }

    //Decodes keys & files from b64
    public static BigInteger b64Decoder(String toDecode) {

        byte[] bytese = Base64.getDecoder().decode(toDecode);

        String Xeee = new String(bytese, StandardCharsets.US_ASCII);

        return new BigInteger(Xeee);

    }



}