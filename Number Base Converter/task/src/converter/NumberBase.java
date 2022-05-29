package converter;

public class NumberBase {

    protected BaseConverter baseConverter;
    private final int number;

    NumberBase(int number) {
        this.number = number;
    }

    public String performConversion(int base) {
        return baseConverter.convert(number, base);
    }
}
