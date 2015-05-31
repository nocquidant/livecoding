package live.step1;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class LambdaExpressions {
  JButton button = null;

  private void aDefinition() {
    String def = "A lambda expression is a method without a name" +
        " that is used to pass around behaviour as if it were data";
  }

  private void firstLambdaExpression() {
    // Using an anonymous inner class to associate behavior with a button click
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        System.out.println("button clicked");
      }
    });

    // - The interface has a single method, actionPerformed
    // - Boilerplate, fairly hard to read because it obscures the programmer’s intent.

    // Using a lambda expression to associate behavior with a button click
    button.addActionListener(event -> System.out.println("button clicked"));

    // - Instead of passing in an object that implements an interface,
    // we’re passing in a block of code — a function without a name
    // event is the name of a parameter
    // - Javac is inferring the type of the variable event from its context
    // (the signature of addActionListener)
  }

  private void differentWaysWeCanWriteLambdaExpressions() {
    // a lambda expression with no arguments at all
    Runnable noArguments = () -> System.out.println("Hello World");

    // only one argument which lets us leave out the parentheses around the arguments
    ActionListener oneArgument = event -> System.out.println("button clicked");

    // full block of code (instead of just an expression)
    Runnable multiStatement = () -> {
      System.out.print("Hello");
      System.out.println(" World");
    };

    // lambda can be used for methods that take more than one argument
    BinaryOperator<Long> add = (x, y) -> x + y;

    // it’s sometimes good to have the option of explicitly writing the type
    BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;

    // => parentheses are necessary for multiple args & explicitly writing the type
  }

  private void usingValues() {
    // A final local variable being captured by an anonymous inner class
     String name = getUserName();
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        System.out.println("hi " + name);
      }
    });

    // - This restriction is relaxed a bit in Java 8
    // - It’s possible to refer to variables that aren’t final ;
    // however, they still have to be effectively final

    // An effectively final variable being captured by an anonymous inner class
    String someone = getUserName();
    button.addActionListener(event -> System.out.println("hi " + someone));

    // - Lambda expressions are "closures"?
    // - Not really: http://stackoverflow.com/questions/17204279/does-java-8-support-closures
    //    In short "real closures" in Java would be a big scary proposition for everyone concerned.
    //    The "closures for finals" hack is a pragmatic compromise that does work, and that is good
    //    enough in practice.
  }

  private void functionalInterfaces() {
    // - A functional interface is an interface with a single abstract method
    // that is used as the type of a lambda expression.

//     public interface ActionListener extends EventListener {
//       void actionPerformed(ActionEvent event);
//     }
    // -> takes one argument and produces no result

    // - It doesn’t matter what the single method on the interface
    // is called—as long as it has a compatible method signature.

    // - Functional interfaces may take two parameters (or more) and return a value

    // See images for important functional interfaces in Java

    //
    // @FunctionalInterface annotation
    //

    // It should be applied to any interface that is intended to be used as a func‐
    // tional interface...

    // There are some interfaces in Java that have only a
    // single method but aren’t normally meant to be implemented by lambda expressions

    // for instance, java.lang.Comparable and java.io.Closeable are not lambdas
    // They have a mutating state and are not a pure function
  }

  /**
   * There are certain circumstances in which you need to manually provide type hints
   */
  private void typeInference() {
    // An extension of the target type inference introduced in Java 7.

    Map<String, Integer> oldWordCounts = new HashMap<String, Integer>();
    Map<String, Integer> diamondWordCounts = new HashMap<>(); // type inferred from the type of diamondWordCounts

    // Also works for methods (not in Java 7)

    useHashmap(new HashMap<>());

    // it’s not magic: javac looks for information close to your lambda expression and
    // uses this information to figure out what the correct type should be.

    //
    // Let's see some examples
    //

    // A lambda that tells you whether an Integer is greater than 5 -> a Predicate
    Predicate<Integer> atLeast5 = x -> x > 5;

    // A Predicate is a lambda expression that returns a value
    // In this case, the body of the lambda is an expression
    // When that happens, the return value of the lambda is the value its body evaluates to.

    // A more complex type inference example
    BinaryOperator<Long> addLongs = (x, y) -> x + y;

    // The inference is smart, but if it doesn’t have enough information,
    // it won’t be able to make the right decision

    // Code doesn’t compile due to missing generics
    //BinaryOperator add = (x, y) -> x + y;
  }

  private void keyPoints() {
    // - A lambda expression is a method without a name that is used to pass around behavior
    // as if it were data.

    // - Lambda expressions look like this: BinaryOperator<Integer> add = (x, y) → x + y.

    // - A functional interface is an interface with a single abstract method that is used as
    // the type of a lambda expression.
  }

  public static void main(String[] args) {
    LambdaExpressions chapter = new LambdaExpressions();
    chapter.aDefinition();
    chapter.firstLambdaExpression();
    chapter.usingValues();
    chapter.functionalInterfaces();
    chapter.typeInference();
    chapter.keyPoints();
  }

  //
  // In order to compile...
  //

  private String getUserName() {
    return "toto";
  }

  private void useHashmap(Map<String, String> values) {
  } // does not work in java7

  static class MyComparable implements Comparable<Object> {
    @Override public int compareTo(Object o) {
      return 0;
    }
  }

  @FunctionalInterface
  static interface MyNotFunctionnalInterface {
    void firstMethod();
    //void secondMethod();
  }
}
