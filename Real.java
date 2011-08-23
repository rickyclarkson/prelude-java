package prelude;

public abstract class Real<A> {
  public final Num<A> num;
  public final Ord<A> ord;

  public Real(Num<A> num, Ord<A> ord) {
    this.num = num;
    this.ord = ord;
  }

  public abstract Rational toRational(A x);
}
