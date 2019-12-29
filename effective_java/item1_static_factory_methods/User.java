public class User {
  
  private final String name;
  private final String email;
  private final String country;

  /**
  * Need a singleton instance of the class?
  */
  private static volatile User instance = null;

  /**
  * Standard constructor.
  */
  public User(String name, String email, String country) {
    this.name = name;
    this.email = email;
    this.country = country;
  }

  /**
  * Need a default value? Use a static factory method so that
  * the constructor doesn't have to be modified. (Less rigid).
  */
  public static User createWithDefaultCountry(
    String name, String email) {
    return new User(name, email, "Argentina");  
  }

  /**
  * Need a singleton instance? Use an instance-controlled static
  * factory method. Notice that the constructor is clean from
  * unnecessary, unrelated tasks.
  *
  * Sidenote: It is better to use enum type because it is both
  * serialization-safe and thread-safe.
  */
  public static User getSingletonInstance(
    String name, String email, String country) {
    if (instance == null) {
      synchronized (User.class) {
        if (instance == null) {
          instance = new User(name, email, country);  
        }  
      }  
    }
    return instance;
  }
}
