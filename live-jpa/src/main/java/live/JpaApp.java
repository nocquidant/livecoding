package live;

import live.step1.SubApp1;
import live.step2.SubApp2;
import live.step3.SubApp3;
import live.step4.SubApp4;
import live.step4.SubApp4bis;
import live.step5.SubApp5;
import live.step6.SubApp6;
import live.step7.SubApp7;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaApp {
  private static String CURRENT = "4";

  private SubApp getSubApp(String step) {
    if ("1".equals(step)) return new SubApp1();
    if ("2".equals(step)) return new SubApp2();
    if ("3".equals(step)) return new SubApp3();
    if ("4".equals(step)) return new SubApp4();
    if ("4bis".equals(step)) return new SubApp4bis();
    if ("5".equals(step)) return new SubApp5();
    if ("6".equals(step)) return new SubApp6();
    if ("7".equals(step)) return new SubApp7();
    return null;
  }

  public static void main(String[] args) {
    JpaApp main = new JpaApp();
    SubApp subapp = main.getSubApp(CURRENT);
    subapp.startup();
    try {
      subapp.execute();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    } finally {
      subapp.cleanup();
    }
    System.exit(0);
  }

  public static abstract class SubApp {
    public static final String DRIVER = "org.h2.Driver";

    protected EntityManagerFactory emf;

    public abstract void execute();

    public void startup() {
      try {
        Class.forName(DRIVER);
      } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
      }

      emf = Persistence.createEntityManagerFactory("livePU");
    }

    public void cleanup() {
      if (emf != null) {
        emf.close();
      }
    }
  }
}
