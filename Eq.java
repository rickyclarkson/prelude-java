package prelude;

public abstract class Eq<A> {
  public boolean eq(A a, A b) {
    return !neq(a, b);
  }

  public boolean neq(A a, A b) {
    return !eq(a, b);
  }

  public static <A> Eq<A> derive() {
    return new Eq<A>() {
      public boolean eq(A a, A b) {
        return a.equals(b);
      }
    };
  }
}
