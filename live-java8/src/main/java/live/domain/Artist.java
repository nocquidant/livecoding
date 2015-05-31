package live.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * An individual or group who creates music
 */
public class Artist {
  // The name of the artist (e.g., "The Beatles")
  private String name;

  // A set of other artists who comprise this group (e.g., "John Lennon");
  // this field might be empty
  private List<Artist> members;

  // The primary location of origin of the group (e.g., "Liverpool").
  private String origin;

  public Artist(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public boolean isFrom(String city) {
    if (city.equals(origin)) {
      return true;
    }
    return false;
  }


  public static List<Artist> theBeatles() {
    Artist john = new Artist("John Lennon");
    Artist paul = new Artist("Paul McCartney");
    Artist george = new Artist("George Harrison");
    Artist ringo = new Artist("Ringo Starr");

    john.setOrigin("London");
    paul.setOrigin("London");
    george.setOrigin("London");
    ringo.setOrigin("London");

    return Stream.of(john, paul, george, ringo).collect(Collectors.toList());
  }

  public String getNationality() {
    return "todo";
  }
}
