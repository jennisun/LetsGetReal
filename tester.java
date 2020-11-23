public class tester{
  public static void main(String[] args) {
    RealNumber a = new RealNumber(2);
    RealNumber b = new RealNumber(-15.5);
    RealNumber c = new RealNumber(0);
    // System.out.println(a.add(b));
    // System.out.println(a.multiply(b));
    // System.out.println(a.divide(b));
    // System.out.println(a.divide(c));
    // System.out.println(a.subtract(c));

    RationalNumber d = new RationalNumber(1, 2);
    RationalNumber e = new RationalNumber(1, 2);
    System.out.println(d.getValue());
    System.out.println(d.reciprocal().getValue());
    System.out.println(d.equals(e));
    System.out.println(d);

  }



}
