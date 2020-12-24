public class RationalNumber extends Number {
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super();//this value is ignored!

    if (deno == 0) {
      numerator = 0;
      denominator = 1;
    }

    else {
      if (deno <= -1) {
        numerator = nume * -1;
        denominator = deno * -1;
      }

      else {
        numerator = nume;
        denominator = deno;
      }

      reduce();
    }
  }

  public double getValue(){
    return (double) numerator / denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    return new RationalNumber(denominator, numerator);
  }
  /**
  // *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return (this.getNumerator() == other.getNumerator() && this.getDenominator() == other.getDenominator());
  }

  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    if (getDenominator() == 1) return Integer.toString(this.getNumerator());
    if (getNumerator() == 0) return Integer.toString(0);
    return this.getNumerator() + "/" + this.getDenominator();
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    a = Math.abs(a);
    b = Math.abs(b);
    while (a != b) {
      if (a >= b) a = a - b;
      else b = b - a;
    }
    return a;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    if (numerator == 0 || denominator == 0) {
      numerator = 0;
      denominator = 1;
    }

    else {
      if (denominator < 0) {
        numerator *= -1;
        denominator *= -1;
      }

      int gcd = gcd(Math.abs(this.getNumerator()), this.getDenominator());
      numerator = this.getNumerator()/gcd;
      denominator = this.getDenominator()/gcd;
    }
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    int a = this.getNumerator() * other.getNumerator();
    int b = this.getDenominator() * other.getDenominator();

    return new RationalNumber(a, b);
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    int a = this.getNumerator() * other.getDenominator();
    int b = this.getDenominator() * other.getNumerator();

    return new RationalNumber(a, b);
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    int a = this.getNumerator() * other.getDenominator() + this.getDenominator() * other.getNumerator();
    int b = this.getDenominator() * other.getDenominator();

    return new RationalNumber(a, b);
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    int a = this.getNumerator() * other.getDenominator() - this.getDenominator() * other.getNumerator();
    int b = this.getDenominator() * other.getDenominator();

    return new RationalNumber(a, b);
  }
}
