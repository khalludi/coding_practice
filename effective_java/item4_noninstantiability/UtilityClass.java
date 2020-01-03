/**
* By providing a private construtor, a default constructor is not
* created and, thus, the constructor is inaccessible outside the
* class. The AssertionError is a safety just in case the constructor
* is accidentally called within the class.
*
* Example of uninstantiable classes include java.lang.Math and
* java.util.Arrays.
*/
public class UtilityClass {
  // Suppress default constructor for noninstantiability
  private UtilityClass() {
    throw new AssertionError();
  }
}
