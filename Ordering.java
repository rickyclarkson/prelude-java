package prelude;

public enum Ordering {
  LT, EQ, GT;

  public static final Eq<Ordering> eq = Eq.derive();
  public static final Ord<Ordering> ord = Ord.derive(JavaEnum.<Ordering>ordinal());
}
