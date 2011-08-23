package prelude;

import java.util.concurrent.atomic.AtomicReference;

final class Thunk<A> {
  final AtomicReference<A> evaluated = new AtomicReference<A>();
  final P1<A> p;

  Thunk(P1<A> p) {
    this.p = p;
  }

  public A get() {
    if (evaluated.get() != null)
      return evaluated.get();
    evaluated.compareAndSet(null, p._1());
    return evaluated.get();
  }
}
