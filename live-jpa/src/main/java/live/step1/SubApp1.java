package live.step1;

import live.JpaApp;
import live.step1.entity.Student1;

public class SubApp1 extends JpaApp.SubApp {
  public void execute() {
    Student1 david = new Student1("David", "998877");
    System.out.println("That's all folks!");
  }
}