package live.step3.ex1;

public class OverridingParent extends ParentImpl {
  @Override
  public void welcome() {
    message("Class Parent: Hi!");
  }
}