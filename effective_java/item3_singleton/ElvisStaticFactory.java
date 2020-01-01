/*
* The static factory approach is useful because of the flexibility
* that allows modifying the code without breaking previous versions.
* Another advantage is that the static factory could be used in a
* supplier.
*/
public class ElvisStaticFactory {
  private static final Elvis INSTANCE = new ElvisStaticFactory();
  private ElvisStaticFactory() {}
  public static Elvis getInstance() { return INSTANCE; }

  public void leaveTheBuilding() {
    System.out.println("Whoa baby, I'm outta here!");
  }

  public static void main(String[] args) {
    ElvisStaticFactory elvis = ElvisStaticFactory.getInstance();
    elvis.leaveTheBuilding();
  }
}
