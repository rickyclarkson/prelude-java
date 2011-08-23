package prelude;

public abstract class Show<A> {
  public abstract String show(A x);

  public static <A> Show<A> derive() {
    return new Show<A>() {
      public String show(A x) {
        return x.toString();
      }
    };
  }
}
