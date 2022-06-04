package converter;

public class NumberBase {

    protected BaseConverter baseConverter;
    private final String number;

    NumberBase(String number) {

        this.number = number;
    }

    public String performConversion(int base) {
        return baseConverter.convert(number, base);
    }
}