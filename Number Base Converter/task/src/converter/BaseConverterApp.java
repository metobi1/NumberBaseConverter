package converter;

import java.util.List;
import java.util.Scanner;

import static converter.Print.*;

public class BaseConverterApp {

    private static final Scanner scanner =
            new Scanner(System.in);
    public static void runApp() {

        while (true) {

            welcomeMessage();

            String input = scanner.nextLine();

            if ("/exit".equals(input)) {
                break;
            }

            List<String> strList = List.of(input.split(" "));
            int sourceBase;
            int targetBase;

            if (isValidInput(strList)) {
                sourceBase = Integer.parseInt(strList.get(0));
                targetBase = Integer.parseInt(strList.get(1));
            } else {
                baseInputErrorMsg();
                continue;
            }

            if (isValidBase(sourceBase, targetBase)) {
                convertNumber(sourceBase, targetBase);
            } else {
                baseRangeErrorMsg();

            }
        }
    }

    private static void convertNumber(int sourceBase, int targetBase) {

        while (true) {
            numberRequestMsg(sourceBase, targetBase);
            String strNum = scanner.next();

            if ("/back".equals(strNum)) {
                scanner.nextLine();
                break;
            }

            if (validateNumber(strNum, sourceBase)) {
                if (sourceBase == targetBase) {
                    conversionResultMsg(strNum);
                    continue;
                }
                String baseTenNum = toBaseTen(strNum, sourceBase);

                if (targetBase == 10) {
                    conversionResultMsg(baseTenNum);
                } else {
                    String otherBaseNum = fromBaseTen(baseTenNum, targetBase);
                    conversionResultMsg(otherBaseNum);
                }
            } else {
                nonValidNumberErrorMsg(sourceBase);
            }
        }
    }

    private static boolean validateNumber(String strNum, int sourceBase) {

            ValidateNumber validateNumber = new ValidateNumber();
            return validateNumber.isValid(strNum, sourceBase);
    }

    private static boolean isValidInput(List<String> strList) {

        if (strList.size() != 2) {
            return false;
        }
        for (String strNum : strList) {
            for (char charValue : strNum.toCharArray()) {
                if (!ValidateNumber.isNumber(charValue)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidBase(int sourceBase, int targetBase) {
        return inRange(sourceBase) && inRange(targetBase);
    }

    private static boolean inRange(int base) {
         return base >= 2 && base <= 36;
    }

    private static String toBaseTen(String strNum, int base) {

        NumberBase numberBase = new BaseTen(strNum);
        return numberBase.performConversion(base);
    }

    private static String  fromBaseTen(String strNum, int base) {

        NumberBase numberBase = new BaseOthers(strNum);
        return numberBase.performConversion(base);
    }
}
