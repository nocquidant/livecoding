package live.step5;

import live.ApplicationMvc;
import live.step5.booking.Booking;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class SubApp5 implements ApplicationMvc.SubApp {
  public void execute() {
    ApplicationContext context = new AnnotationConfigApplicationContext(SubApp5.class);
    Booking booker = context.getBean(Booking.class);
    booker.book();
  }
}
