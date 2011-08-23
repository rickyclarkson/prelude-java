package prelude;

import static prelude.Ordering.LT;
import static prelude.Ordering.GT;
import static prelude.Ordering.EQ;

public final class IntOrd extends Ord<Integer> {
  private IntOrd() {
    super(Eq.<Integer>derive());
  }

  public static final IntOrd instance = new IntOrd();

  public Ordering compare(Integer x, Integer y) {
    return x > y ? GT : x < y ? LT : EQ;
  }
}
