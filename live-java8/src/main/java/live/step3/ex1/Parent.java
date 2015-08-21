package live.step3.ex1;

public interface Parent {
  /** sends a message when called */
  void message(String body);

  default void welcome() {
    message("Parent: Hi!");
  }

  String getLastMessage();
}
