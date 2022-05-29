package converter;

public class BaseEight extends NumberBase{
    BaseEight(int number) {
        super(number);
        baseConverter = new BaseTenToOther();
    }
}
