package live.domain;

/**
 * A single piece of music
 */
public class Track {
  // The name of the track (e.g., "Yellow Submarine")
  private String name;

  // The length of the track in second
  private Integer length;

  public Track() {

  }

  public Track(String name, Integer length) {
    this.name = name;
    this.length = length;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }
}
