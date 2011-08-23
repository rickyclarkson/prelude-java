package prelude;

public final class IntEnumeration extends Enumeration<Integer> {
  private IntEnumeration() {
  }

  public static final IntEnumeration instance = new IntEnumeration();

  public Integer succ(Integer x) {
    return x + 1;
  }

  public Integer pred(Integer x) {
    return x - 1;
  }

  public Integer toEnum(int x) {
    return x;
  }

  public int fromEnum(Integer x) {
    return x;
  }
}
