package converter;

public class BaseSixteen extends NumberBase{
    BaseSixteen(int number) {
        super(number);
        baseConverter = new BaseTenToOther();
    }
}
