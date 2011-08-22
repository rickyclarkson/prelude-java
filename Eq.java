public abstract class Eq<A> {
  public boolean eq(A a, A b) {
    return !neq(a, b);
  }

  public boolean neq(A a, A b) {
    return !eq(a, b);
  }
}
