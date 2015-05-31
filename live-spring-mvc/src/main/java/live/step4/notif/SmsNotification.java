package live.step4.notif;

import org.springframework.stereotype.Component;

@Component
public class SmsNotification implements Notification {
  @Override
  public void sendNotification() {
    // logic to send email
    System.out.println("Sms sent...");
  }
}
