package converter;

public class ValidateNumber {

    static final int ONE = 1;
    static final int ELEVEN = 11;

    public boolean isValid(String strNum, int base) {

        boolean validNum = false;

        for (int i = 0; i < strNum.length(); i++) {

            if (isNumber(strNum.charAt(i))) {

                if (isNotValidBase(strNum.charAt(i), base, '0', ONE)) {
                    return false;
                } else {
                    validNum = true;
                }
            } else if (base >= ELEVEN) {

                String toUpper = strNum.substring(i, i + 1).toUpperCase();

                if (isAlpha(toUpper.charAt(0))) {

                    if (isNotValidBase(toUpper.charAt(0), base, 'A', ELEVEN)) {
                        return false;
                    }
                    else {
                        validNum = true;
                    }
                }
            }
        }
        return validNum;
    }

    static boolean isNumber(char numChar) {
        return inRange(numChar, '0', '9');
    }

    private boolean isNotValidBase(char numChar, int base, char minCharValue,
                                   int refBase) {

        int maxBaseNum = base - refBase;
        char maxBaseChar = (char) (maxBaseNum + minCharValue);
        return GreaterThanMaxNum(numChar, maxBaseChar);
    }

    private boolean GreaterThanMaxNum(char numChar, char maxBaseChar) {
        return numChar > maxBaseChar;
    }

    private boolean isAlpha(char numChar) {
        return inRange(numChar, 'A', 'Z');
    }

    private static boolean inRange(char value, char min, char max) {
        return value >= min && value <= max;
    }
}
