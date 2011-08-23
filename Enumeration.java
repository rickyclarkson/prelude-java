package prelude;

public abstract class Enumeration<A> {
  public A succ(A x) {
    return toEnum(fromEnum(x) + 1);
  }

  public A pred(A x) {
    return toEnum(fromEnum(x) - 1);
  }

  public abstract A toEnum(int x);

  public abstract int fromEnum(A x);

  private final F<Integer, A> toEnum = new F<Integer, A>() {
    public A f(Integer y) {
      return toEnum(y);
    }
  };

  public List<A> enumFrom(A x) {
    return List.from(IntEnumeration.instance, fromEnum(x)).map(toEnum);
  }

  public List<A> enumFromTo(A x, A y) {
    return List.fromTo(IntEnumeration.instance, IntOrd.instance, fromEnum(x), fromEnum(y)).map(toEnum);
  }

  public List<A> enumFromThen(A x, A y) {
    return List.fromThen(IntEnumeration.instance, fromEnum(x), fromEnum(y)).map(toEnum);
  }

  public List<A> enumFromThenTo(A x, A y, A z) {
    return List.fromThenTo(IntEnumeration.instance, IntOrd.instance, fromEnum(x), fromEnum(y), fromEnum(z)).map(toEnum);
  }
}
