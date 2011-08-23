package prelude;

public final class IntNum extends Num<Integer> {
  private IntNum() {
    super(Eq.<Integer>derive(), Show.<Integer>derive());
  }

  public Integer fromInteger(int x) {
    return x;
  }

  public Integer signum(Integer x) {
    return x < 0 ? -1 : x > 0 ? 1 : 0;
  }

  public Integer abs(Integer x) {
    return x < 0 ? -x : x;
  }

  public Integer plus(Integer x, Integer y) {
    return x + y;
  }

  public Integer minus(Integer x, Integer y) {
    return x - y;
  }

  public Integer multiply(Integer x, Integer y) {
    return x * y;
  }

  public Integer divide(Integer x, Integer y) {
    return x / y;
  }

  public static final IntNum instance = new IntNum();
}
