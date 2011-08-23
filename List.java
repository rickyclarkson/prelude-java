package prelude;

public abstract class List<A> {
  private List() {
  }

  public abstract <B> List<B> map(F<A, B> f);

  public static final class Empty<A> extends List<A> {
    public <B> List<B> map(F<A, B> f) {
      return new Empty<B>();
    }
  }

  public static final class Cons<A> extends List<A> {
    private final A head;
    private final Thunk<List<A>> tail;

    public Cons(A head, P1<List<A>> tail) {
      this.head = head;
      this.tail = new Thunk<List<A>>(tail);
    }

    public <B> List<B> map(final F<A, B> f) {
      return new Cons<B>(f.f(head), new P1<List<B>>() {
        public List<B> _1() {
	  return tail.get().map(f);
        }
      });
    }
  }

  public static <A> List<A> from(final Enumeration<A> e, final A x) {
    return new Cons<A>(x, new P1<List<A>>() {
      public List<A> _1() {
        return from(e, e.succ(x));
      }
    });
  }

  public static <A> List<A> fromThen(final Enumeration<A> e, final A x, final A y) {
    return new Cons<A>(x, new P1<List<A>>() {
      public List<A> _1() {
        return fromThen(e, y, e.toEnum(e.fromEnum(y) + (e.fromEnum(y) - e.fromEnum(x))));
      }
    });
  }

  public static <A> List<A> fromTo(final Enumeration<A> e, final Ord<A> ord, final A x, final A y) {
    return new Cons<A>(x, new P1<List<A>>() {
      public List<A> _1() {
        A next = e.succ(x);
        if (ord.greaterThanOrEqual(next, y))
	  return new Empty<A>();
	return fromTo(e, ord, next, y);
      }
    });
  }

  public static <A> List<A> fromThenTo(final Enumeration<A> e, final Ord<A> ord, final A x, final A y, final A z) {
    return new Cons<A>(x, new P1<List<A>>() {
      public List<A> _1() {
        A next = e.toEnum(e.fromEnum(x) + (e.fromEnum(y) - e.fromEnum(x)));
	if (ord.greaterThanOrEqual(next, z))
	  return new Empty<A>();
	return fromThenTo(e, ord, next, e.toEnum(e.fromEnum(next) + (e.fromEnum(y) - e.fromEnum(x))), z);
      }
    });
  }
}
