package live;

import live.domain.Artist;
import live.domain.Track;

import java.io.Closeable;
import java.io.File;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class ScratchBook {

  public static void main(String[] args) {
    new ScratchBook().scratch1();
  }

  private void scratch1() {
    Artist.theBeatles().stream()
        .filter(artist -> {
          System.out.println(artist.getName());
          return artist.isFrom("London");
        }).count();
  }

  private void scratch2() {
        int count = Stream.of(1, 2, 3)
            .reduce(0, (acc, element) -> acc + element);
        assertEquals(6, count);
  }
}
