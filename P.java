package prelude;

public final class P {
  public static <A, B> P2<A, B> p(final A a, final B b) {
    return new P2<A, B>() {
      public A _1() {
        return a;
      }

      public B _2() {
        return b;
      }
    };
  }
}
