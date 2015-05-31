package live.step4.booking;

import live.step4.notif.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Booking {
  Notification notif;

  @Autowired
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
