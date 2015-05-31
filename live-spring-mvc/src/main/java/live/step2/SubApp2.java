package live.step2;

import live.ApplicationMvc;
import live.step2.booking.Booking;

public class SubApp2 implements ApplicationMvc.SubApp {
  public void execute() {
    Booking booking = new Booking();
    booking.book();
  }
}
