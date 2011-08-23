package prelude;

public final class Rational extends Ratio<Integer> {
  public Rational(int x, int y) {
    super(IntIntegral.instance, x, y);
  }
}
