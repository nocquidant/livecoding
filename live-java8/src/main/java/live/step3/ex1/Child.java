package live.step3.ex1;

public interface Child extends Parent {
  @Override
  default void welcome() {
    message("Child: Hi!");
  }
}