package converter;

public class BaseTwo extends NumberBase{
    BaseTwo(int number) {
        super(number);
        baseConverter = new BaseTenToOther();
    }
}
