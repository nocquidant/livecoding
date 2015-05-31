package live.step2.booking;

import live.step2.notif.SmsNotification;

public class Booking {
  SmsNotification smsNotif = new SmsNotification();

  public Integer book() {
    // logic to book seat
    System.out.println("Seat booked");
    smsNotif.sendSms();
    return 0;
  }
}
