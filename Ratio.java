package prelude;

public class Ratio<A> {
  public final Integral<A> integral;
  public final A x;
  public final A y;

  public Ratio(Integral<A> integral, A x, A y) {
    this.integral = integral;
    this.x = x;
    this.y = y;
  }

  public static <A> Eq<Ratio<A>> eq() {
    return new Eq<Ratio<A>>() {
      public boolean eq(Ratio<A> x, Ratio<A> y) {
        return x.x.equals(y.x) && x.y.equals(y.y);
      }
    };
  }
}
