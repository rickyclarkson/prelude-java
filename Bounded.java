package prelude;

public interface Bounded<A> {
  A minBound();
  A maxBound();
}
