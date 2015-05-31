package live.step3;

import live.ApplicationMvc;
import live.step3.booking.Booking;
import live.step3.notif.SmsNotification;

public class SubApp3 implements ApplicationMvc.SubApp {
  public void execute() {
    Booking booking = new Booking(new SmsNotification());
    booking.book();
  }
}
