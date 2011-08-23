package prelude;

public abstract class Num<A> {
  public final Eq<A> eq;
  public final Show<A> show;

  public Num(Eq<A> eq, Show<A> show) {
    this.eq = eq;
    this.show = show;
  }

  public abstract A plus(A x, A y);
  
  public A minus(A x, A y) {
    return plus(x, negate(y));
  }

  public abstract A multiply(A x, A y);
  
  public A negate(A x) {
    return minus(fromInteger(0), x);
  }

  public abstract A abs(A x);
  public abstract A signum(A x);
  public abstract A fromInteger(int x);
}
