package live.step2;

import live.domain.Album;
import live.domain.Artist;
import live.domain.Track;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static junit.framework.TestCase.assertEquals;

public class Streams {

  private void aDefinition() {
    String def = "Streams allow us to write collections-processing code at a higher" +
        "level of abstraction";

    // Stream interface contains a series of functions that we’ll explore throughout this step
  }

  private void fromExternalIterationToInternalIteration() {
    // Example Counting London-based artists using a for loop
    long count = 0;
    for (Artist artist : Artist.theBeatles()) {
      if (artist.isFrom("London")) {
        count++;
      }
    }

    // Issues?
    // - a lot of boilerplate code
    // - hard to write a parallel version of this for loop
    // - the code doesn’t fluently convey the intent of the programmer

    // Under the cover? -> external iteration
    // Same as:
    count = 0;
    Iterator<Artist> iterator = Artist.theBeatles().iterator();
    while (iterator.hasNext()) {
      Artist artist = iterator.next();
      if (artist.isFrom("London")) {
        count++;
      }
    }

    // See image external iteration

    // Issues?
    //  - inherently serial in nature
    //  - what and how are conflated
    // -> hard to abstract away the different behavioral operations that we’ll encounter later

    // Counting London-based artists using internal iteration
    count = Artist.theBeatles().stream()
        .filter(artist -> artist.isFrom("London"))
        .count();

    // We clearly have 2 operations:
    //  - Finding all the artists from London
    //  - Counting a list of artists
    // The test is defined by a function

    // See image internal iteration

    // DEFINITION A Stream is a tool for building up complex operations on collec‐
    // tions using a functional approach.

    // *NB* 2 operations doesn't mean 2 loops!
    //  - the Stream object returned isn’t a new collection—it’s a recipe
    // for creating a new collection

    // Just the filter, no collect step
    Artist.theBeatles().stream().filter(artist -> artist.isFrom("London"));

    // DEFINITION lazy vs eager
    //  - Methods such as filter that build up the Stream recipe
    // but don’t force a new value to be generated at the end are referred to as lazy
    //  - Methods such as count that generate a final value out of the Stream sequence are called eager

    // Not printing out artist names due to lazy evaluation
    Artist.theBeatles().stream()
        .filter(artist -> {
          System.out.println(artist.getName());
          return artist.isFrom("London");
        });

    // Printing out artist names
    count = Artist.theBeatles().stream()
        .filter(artist -> {
          System.out.println(artist.getName());
          return artist.isFrom("London");
        })
        .count();

    // It’s very easy to figure out whether an operation is eager or lazy: look at what it returns.
    // If it gives you back a Stream , it’s lazy;
    // if it gives you back another value or void , then it’s eager.

    // “Why would we want to have the differentiator between lazy and
    // eager options?” By waiting until we know more about what result and operations are
    // needed, we can perform the computations more efficiently
  }

  private void commonStreamOperations() {
    // Let's see some common Stream operations
    // Refer to the Javadoc for the new API to see what else is available

    //
    // ** collect(toList()) **
    //

    // DEFINITION
    // collect(toList()) is an eager operation that generates a list from the values in a Stream

    // Here’s an example of this operation
    List<String> collected = Stream.of("a", "b", "c")
        .collect(toList());
    assertEquals(asList("a", "b", "c"), collected);

    //
    // ** map **
    //

    // DEFINITION
    // If you’ve got a function that converts a value of one type into anoth‐
    // er, map lets you apply this function to a stream of values, producing
    // another stream of the new values.

    // See image theMapOperation.png

    // Converting strings to uppercase equivalents using a for loop
    collected = new ArrayList<>();
    for (String string : asList("a", "b", "hello")) {
      String uppercaseString = string.toUpperCase();
      collected.add(uppercaseString);
    }
    assertEquals(asList("A", "B", "HELLO"), collected);

    // Converting strings to uppercase equivalents using map
    collected = Stream.of("a", "b", "hello")
        .map(string -> string.toUpperCase())
        .collect(toList());
    assertEquals(asList("A", "B", "HELLO"), collected);


    //
    // ** filter **
    //

    // DEFINITION
    // Any time you’re looping over some data and checking each element,
    // you might want to think about using the new filter method on
    // Stream.

    // See image theFilterOperation.png

    // Looping over a list and using an if statement
    List<String> beginningWithNumbers = new ArrayList<>();
    for (String value : asList("a", "1abc", "abc1")) {
      if (isDigit(value.charAt(0))) {
        beginningWithNumbers.add(value);
      }
    }

    assertEquals(asList("1abc"), beginningWithNumbers);

    // Functional style
    beginningWithNumbers = Stream.of("a", "1abc", "abc1")
        .filter(value -> isDigit(value.charAt(0)))
        .collect(toList());

    assertEquals(asList("1abc"), beginningWithNumbers);

    //
    // ** flatMap **
    //

    // DEFINITION
    // flatMap lets you replace a value with a Stream and
    // concatenates all the streams together.

    // See image theFlatMapOperation.png

    // A map operation replaces a value in a Stream with a new value.
    // Sometimes you want a variant of map in which you produce a new Stream object
    // as the replacement.

    List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
        .flatMap(numbers -> numbers.stream())
        .collect(toList());

    assertEquals(asList(1, 2, 3, 4), together);

    //
    // ** max and min **
    //

    // max and min operations that are provided by the Streams API

    // Finding the shortest track with streams
    List<Track> tracks = asList(new Track("Bakai", 524),
        new Track("Violets for Your Furs", 378),
        new Track("Time Was", 451));

    Track shortestTrack = tracks.stream()
        .min(Comparator.comparing(track -> track.getLength())) // comparing in java8
        .get();

    assertEquals(tracks.get(1), shortestTrack);

    // It’s now possible for max to be called on an empty Stream so that it returns what’s known
    // as an Optional value.

    //
    // ** reduce **
    //

    // - when you’ve got a collection of values and you want to generate a single result.
    // - count, min, and max methods are common use cases. All of these are forms of reduction.

    // Implementing sum using reduce
    int count = Stream.of(1, 2, 3)
        .reduce(0, (acc, element) -> acc + element);  // acc is the accumulator and holds the current sum
    assertEquals(6, count);

    // See additionUsingReduction.png

    // The reduce pattern (pseudo code)
    // Object accumulator = initialValue;
    // for (Object element : collection) {
    //   accumulator = combine(accumulator, element);
    // }

    //
    // ** putting operation together
    //

    // problem to solve: for a given album, find the nationality of every band playing on that album.

    Album album = new Album(); // TODO

    Set<String> origins = album.getMusicians() // getMusicians  returns a Stream
        .filter(artist -> artist.getName().startsWith("The")) //  filter the artists to include only bands
        .map(artist -> artist.getNationality())  //turn the band into its nationality
        .collect(toSet());
  }

  private void multipleStreamCalls() {
    Album album = new Album(); // TODO

    //
    // Stream misuse
    //

    List<Artist> musicians = album.getMusicians()
        .collect(toList());

    List<Artist> bands = musicians.stream()
        .filter(artist -> artist.getName().startsWith("The"))
        .collect(toList());

    Set<String> origins = bands.stream()
        .map(artist -> artist.getNationality())
        .collect(toSet());

    //
    // Idiomatically chained stream calls
    //

    origins = album.getMusicians()
        .filter(artist -> artist.getName().startsWith("The"))
        .map(artist -> artist.getNationality())
        .collect(toSet());

    // - It’s harder to read what’s going on because the ratio of boilerplate code to actual
    // business logic is worse.
    // - It’s less efficient because it requires eagerly creating new collection objects at each
    // intermediate step.
    // - It clutters your method with meaningless garbage variables that are needed only as
    // intermediate results.
    // - It makes operations harder to automatically parallelize.
  }

  private void maybeToContinue() {
    // Advanced Collections and Collectors
    // Data parallelism
    // Testing, Debugging, and Refactoring
  }


  static class Test {

    private ActionEvent lastEvent;

    private void registerHandler() {
      JButton button = new JButton();
      button.addActionListener((ActionEvent event) -> {
        this.lastEvent = event;
      });
    }
  }


  private boolean isDigit(char c) {
    return false;
  }

  public static void main(String[] args) {



    Artist.theBeatles().stream()
        .filter(artist -> {
          System.out.println(artist.getName());
          return artist.isFrom("London");
        }).count();

//    int count = Stream.of(1, 2, 3)
//        .reduce(0, (acc, element) -> acc + element);
//    assertEquals(6, count);
  }
}
