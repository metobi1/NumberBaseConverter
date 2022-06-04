package converter;

public class BaseOthers extends NumberBase{

    BaseOthers(String number) {
        super(number);
        baseConverter = new TenToOthers();
    }
}
