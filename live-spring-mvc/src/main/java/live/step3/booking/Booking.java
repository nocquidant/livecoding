package live.step3.booking;

import live.step3.notif.Notification;

public class Booking {
  Notification notif;

  public Booking(Notification notif) {
    this.notif = notif;
  }

  public Integer book() {
    // logic to book seat
    System.out.println("Seat booked");
    notif.sendNotification();
    return 0;
  }
}
