package converter;

public class TargetBase {

    public NumberBase selectBase(int base, int number) {
        if (base == 2) {
            return new BaseTwo(number);
        } else if (base == 8) {
            return new BaseEight(number);
        }
        return new BaseSixteen(number);
    }
}
