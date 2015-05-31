package live;

import live.step1.SubApp1;
import live.step2.SubApp2;
import live.step3.SubApp3;
import live.step3.notif.SmsNotification;
import live.step3.booking.Booking;
import live.step4.SubApp4;
import live.step5.SubApp5;

public class ApplicationMvc {
  private static Integer CURRENT = 5;

  private SubApp getSubApp(Integer step) {
    if (step == 1) return new SubApp1();
    if (step == 2) return new SubApp2();
    if (step == 3) return new SubApp3();
    if (step == 4) return new SubApp4();
    if (step == 5) return new SubApp5();
    return null;
  }

  public static void main(String[] args) {
    ApplicationMvc main = new ApplicationMvc();
    try {
      main.getSubApp(CURRENT).execute();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    System.exit(0);
  }

  public static interface SubApp {
    void execute();
  }
}
