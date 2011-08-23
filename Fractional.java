package prelude;

public abstract class Fractional<A> {
  public final Num<A> num;

  public Fractional(Num<A> num) {
    this.num = num;
  }

  public A divide(A x, A y) {
    return num.multiply(x, recip(y));
  }

  public A recip(A x) {
    return divide(num.fromInteger(1), x);
  }

  public abstract A fromRational(Rational rational);
}
