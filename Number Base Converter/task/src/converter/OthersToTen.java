package converter;

import java.math.BigInteger;

import static java.lang.Math.*;

public class OthersToTen implements BaseConverter{

    @Override
    public String convert(String number, int base) {

        int pw = 0;
        BigInteger result = BigInteger.ZERO;

        for (int i = number.length() - 1; i >= 0; i--) {

            int digit = strToNum(number.substring(i, i + 1));

            long multPow = (long) (pow(base, pw++)) * digit;

            BigInteger longToBigInt = new BigInteger(String.valueOf(multPow));
            BigInteger addOld = result.add(longToBigInt);
            result = addOld.add(BigInteger.ZERO);
        }
        return String.valueOf(result);
    }

    public int strToNum (String strNum) {

        if (strNum.charAt(0) >= '0' && strNum.charAt(0) <= '9') {
            return Integer.parseInt(strNum);
        }
        return alphaToNum(strNum.toUpperCase());
    }

    public int alphaToNum(String str) {
        return str.charAt(0) - 55;
    }
}
