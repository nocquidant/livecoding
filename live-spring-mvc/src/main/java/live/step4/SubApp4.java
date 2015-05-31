package live.step4;

import live.ApplicationMvc;
import live.step4.booking.Booking;
import live.step4.notif.SmsNotification;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SubApp4 implements ApplicationMvc.SubApp {
  public void execute() {
    ApplicationContext context = new AnnotationConfigApplicationContext(SubApp4.class);
    Booking booker = context.getBean(Booking.class);
    booker.book();
  }
}
