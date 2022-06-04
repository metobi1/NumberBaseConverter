package converter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TenToOthers implements BaseConverter{
    @Override
    public String convert(String number, int base) {
        BigInteger quotient = new BigInteger(number);
        List<Integer> remainders = new ArrayList<>();

        while (true) {

            int compareVal = quotient.compareTo(new BigInteger(String.valueOf(base)));

            if (compareVal < 0) {
                remainders.add(quotient.intValue());
                break;
            }

            BigInteger[] quoAndRemainder = quotient.divideAndRemainder(BigInteger.valueOf(base));
            remainders.add(quoAndRemainder[1].intValue());
            quotient = quoAndRemainder[0];
        }
        return reverseList(remainders);
    }

    private String greaterThanNine(int number) {

        if (number > 9) {
            char alphaChar = (char) (number + 55);
            return String.valueOf(alphaChar);
        }
        return String.valueOf(number);
    }

    private String reverseList(List<Integer> toReverse) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = toReverse.size() - 1; i >= 0; i--) {
            String numToStr = greaterThanNine(toReverse.get(i));
            stringBuilder.append(numToStr);
        }
        return stringBuilder.toString();
    }

}
