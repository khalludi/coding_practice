/**
* The field approach to singletons is useful because it is simple
* clear. 
* 
* Note: prone to reflective attacks using AccessibleObject.
* setAccessible() which can be avoided with a check in constructor.
*/
public class ElvisField {
  public static final ElvisField INSTANCE = new ElvisField();

  private ElvisField() {}

  public void leaveTheBuilding() {
    System.out.println("Whoa baby, I'm outta here!");
  }

  public static void main(String[] args) {
    ElvisField elvis = ElvisField.INSTANCE;
    elvis.leaveTheBuilding();
  }
}
