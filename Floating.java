package prelude;

public abstract class Floating<A> {
  public final Fractional<A> fractional;

  public Floating(Fractional<A> fractional) {
    this.fractional = fractional;
  }

  public abstract A pi();
  public abstract A exp(A x);
  public abstract A log(A x);

  public A sqrt(A x) {
    return pow(x, fractional.divide(fractional.num.fromInteger(1), fractional.num.fromInteger(2)));
  }

  public A pow(A x, A y) {
    return exp(fractional.num.multiply(log(x), y));
  }
  
  public A logBase(A x, A y) {
    return fractional.divide(log(y), log(x));
  }

  public abstract A sin(A x);
  public abstract A cos(A x);

  public A tan(A x) {
    return fractional.divide(sin(x), cos(x));
  }

  public abstract A asin(A x);
  public abstract A acos(A x);
  public abstract A atan(A x);
  public abstract A sinh(A x);
  public abstract A cosh(A x);

  public A tanh(A x) {
    return fractional.divide(sin(x), cos(x));
  }

  public abstract A asinh(A x);
  public abstract A acosh(A x);
  public abstract A atanh(A x);
}
