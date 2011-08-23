package prelude;

import static prelude.Ordering.EQ;
import static prelude.Ordering.LT;
import static prelude.Ordering.GT;

public abstract class Ord<A> {
  private final Eq<A> eq;

  public Ord(Eq<A> eq) {
    this.eq = eq;
  }

  public Ordering compare(A x, A y) {
    return eq.eq(x, y) ? EQ : lessThanOrEqual(x, y) ? LT : GT;
  }

  public boolean lessThanOrEqual(A x, A y) {
    return !Ordering.eq.eq(compare(x, y), GT);
  }

  public boolean lessThan(A x, A y) {
    return Ordering.eq.eq(compare(x, y), LT);
  }

  public boolean greaterThanOrEqual(A x, A y) {
    return !Ordering.eq.eq(compare(x, y), LT);
  }

  public A max(A x, A y) {
    return lessThanOrEqual(x, y) ? y : x;
  }

  public A min(A x, A y) {
    return lessThanOrEqual(x, y) ? x : y;
  }

  public static <A> Ord<A> derive(final F<A, Integer> f) {
    return new Ord<A>(Eq.<A>derive()) {
      public Ordering compare(A x, A y) {
        int xx = f.f(x);
	int yy = f.f(y);
	return xx > yy ? GT : xx < yy ? LT : EQ;
      }
    };
  }
}
