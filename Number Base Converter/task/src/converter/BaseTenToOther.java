package converter;

import java.util.ArrayList;
import java.util.List;

public class BaseTenToOther implements BaseConverter{
    @Override
    public String convert(int number, int base) {
        int quotient = number;
        int remainder;
        List<Integer> remainders = new ArrayList<>();

        while (true) {

            if (quotient < base) {
                remainder = quotient;
                remainders.add(remainder);
                break;
            }

            remainder = quotient % base;
            remainders.add(remainder);
            quotient = quotient / base;
        }
        return reverseList(remainders);
    }

    private String greaterThanNine(int number) {
        if (number == 10) {
            return "A";
        } else if (number == 11) {
            return "B";
        } else if (number == 12) {
            return "C";
        } else if (number == 13) {
            return "D";
        } else if (number == 14) {
            return "E";
        } else if (number == 15) {
            return "F";
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
