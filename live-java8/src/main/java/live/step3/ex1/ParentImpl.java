package live.step3.ex1;

public class ParentImpl implements Parent {
  String lastMessage = "";

  @Override
  public void message(String body) {
    lastMessage = body;
  }

  @Override
  public String getLastMessage() {
    return lastMessage;
  }
}
