package prelude;

public final class IntIntegral extends Integral<Integer> {
  private IntIntegral() {
    super(IntReal.instance, IntEnumeration.instance);
  }

  public P2<Integer, Integer> quotRem(Integer n, Integer d) {
    return P.p(n / d, n % d);
  }

  public static final IntIntegral instance = new IntIntegral();
}
