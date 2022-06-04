package converter;

public class Print {

    static void welcomeMessage() {
        System.out.print("Enter two numbers in format: {source base} {target base} " +
                "(To quit type /exit) > ");
    }

    static void baseInputErrorMsg() {
        System.out.println("The base input must be two integers in the form of" +
                " {source base} {target base}\n");
    }

    static void baseRangeErrorMsg() {
        System.out.println("The base must be in the range of 2 to 36\n");
    }

    static void numberRequestMsg(int sourceBase, int targetBase) {
        System.out.printf("Enter number in base %d to convert to base %d " +
                "(To go back type /back) > ", sourceBase, targetBase);
    }

    static void nonValidNumberErrorMsg(int sourceBase) {
        System.out.printf("The number is not a valid base %d number%n%n", sourceBase);
    }

    static void conversionResultMsg(String result) {
        System.out.printf("Conversion result: %s%n", result);
    }
}
