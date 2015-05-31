package live.domain;

import java.util.List;
import java.util.stream.Stream;

/**
 * A single release of music, comprising several tracks
 */
public class Album {
  // he name of the album (e.g., “Revolver”)
  private String name;

  // A list of tracks
  private List<Track> tracks;

  // A list of artists who helped create the music on this album
  private List<Artist> musicians;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Stream<Artist> getMusicians() {
    return musicians.stream();
  }
}
