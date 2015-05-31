package live.step3.notif;

public class SmsNotification implements Notification {
  @Override
  public void sendNotification() {
    // logic to send email
    System.out.println("Sms sent...");
  }
}
