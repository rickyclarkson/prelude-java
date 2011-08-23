package prelude;

public final class IntReal extends Real<Integer> {
  private IntReal() {
    super(IntNum.instance, IntOrd.instance);
  }

  public Rational toRational(Integer x) {
    return new Rational(x, 1);
  }

  public static final IntReal instance = new IntReal();
}
