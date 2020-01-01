/**
* Preferred approach.
*
* The enum construction allows for seriability, security against
* reflection attacks, and guarantees single instantiation. Only tricky
* part is if the singleton must extend a superclass other than
* Enum (though an enum can implement interfaces).
*/
public enum ElvisEnum {
  INSTANCE;

  public void leaveTheBuilding() {
    System.out.println("Whoa baby, I'm outta here!");
  }

  public static void main(String[] args) {
    ElvisEnum elvis = ElvisEnum.INSTANCE;
    elvis.leaveTheBuilding();
  }
}
