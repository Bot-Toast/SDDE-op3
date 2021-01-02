package uk.ac.uos;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BagOfHolding {


    //Loads keys in B64
    public static  List<String> pubKeyLoad = new ArrayList<>();

    //Loads keys once decoded as BigInt Strings.
    public static  BigInteger[] pubKeyBigInt = new BigInteger[2];

    //Loads keys in B64
    public static List<String> prvKeyLoad = new ArrayList<>();

    //Loads keys once decoded as BigInt Strings.
    public static BigInteger[] prvKeyBigInt = new BigInteger[2] ;

    //Files read in are stored here.
    public static List<String> fileReadList = new ArrayList<>();

    //To then be transferred here and written to disk (Have yet to find out why using a single list makes the program commit seppuku, possibly acts a buffer between functions?)
    public static List<String> fileWriteList = new ArrayList<>();





}
