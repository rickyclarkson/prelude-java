package prelude;

public final class JavaEnum {
  public static <A extends Enum<A>> F<A, Integer> ordinal() {
    return new F<A, Integer>() {
      public Integer f(A a) {
        return a.ordinal();
      }
    };
  }
}
