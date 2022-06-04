package converter;

public class BaseTen extends NumberBase{

    BaseTen(String number) {
        super(number);
        baseConverter = new OthersToTen();
    }
}
