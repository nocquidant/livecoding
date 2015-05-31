package live.step1.booking;

import live.step1.notif.EmailNotification;

public class Booking {
  EmailNotification emailNotif = new EmailNotification();

  public Integer book() {
    // logic to book seat
    System.out.println("Seat booked");
    emailNotif.sendEmail();
    return 0;
  }
}
