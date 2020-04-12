package BAOSWithStrategy;

public class DoubleStrategy implements Strategy {
    @Override
    public int nextAfter(int currentVal) {
        return 2 * currentVal;
    }
}
