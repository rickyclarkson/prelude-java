package prelude;

public abstract class Integral<A> {
  public final Real<A> real;
  public final Enumeration<A> enumeration;

  public Integral(Real<A> real, Enumeration<A> enumeration) {
    this.real = real;
    this.enumeration = enumeration;
  }

  public A quot(A x, A y) {
    return quotRem(x, y)._1();
  }

  public A rem(A x, A y) {
    return quotRem(x, y)._2();
  }

  public A div(A x, A y) {
    return divMod(x, y)._1();
  }

  public A mod(A x, A y) {
    return divMod(x, y)._2();
  }

  public abstract P2<A, A> quotRem(A x, A y);
  
  public P2<A, A> divMod(A n, A d) {
    P2<A, A> qr = quotRem(n, d);
    A q = qr._1();
    A r = qr._2();

    Num<A> num = real.num;
    if (num.eq.eq(num.signum(r), num.negate(num.signum(d))))
      return P.p(num.minus(q, num.fromInteger(1)), num.plus(r, d));
    return qr;
  }
}
