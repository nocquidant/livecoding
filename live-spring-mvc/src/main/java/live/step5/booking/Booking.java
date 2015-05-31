package live.step5.booking;

import live.step5.notif.Notification;
import live.step5.tracer.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Booking {
  private final Notification notif;

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
