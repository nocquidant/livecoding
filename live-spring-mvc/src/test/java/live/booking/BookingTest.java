package live.booking;

import live.step3.booking.Booking;
import live.step3.notif.Notification;
import org.junit.Test;

import static org.mockito.AdditionalMatchers.eq;
import static org.mockito.Mockito.*;

public class BookingTest {
  @Test
  public void booking() {
    Notification notifMock = mock(Notification.class);

    Booking booking = new Booking(notifMock);
    Integer status = booking.book();

    verify(notifMock, times(1));
    eq(status, 0);
  }
}