package live.step1;

import live.ApplicationMvc;
import live.step1.booking.Booking;

public class SubApp1 implements ApplicationMvc.SubApp {
  public void execute() {
    Booking booking = new Booking();
    booking.book();
  }
}
