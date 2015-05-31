package live.step1.entity;

import java.util.ArrayList;
import java.util.List;

public class Student1 {
  private String name;
  private String registrationNb;
  private Scholarship1 scholarship;
  private List<ExamResult1> results = new ArrayList<>();

  public Student1() {

  }

  public Student1(String name, String registrationNb) {
    this.name = name;
    this.registrationNb = registrationNb;
  }

  public List<ExamResult1> getResults() {
    return results;
  }

  public void setResults(List<ExamResult1> results) {
    this.results = results;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRegistrationNb() {
    return registrationNb;
  }

  public void setRegistrationNb(String registrationNb) {
    this.registrationNb = registrationNb;
  }

  public Scholarship1 getScholarship() {
    return scholarship;
  }

  public void setScholarship(Scholarship1 scholarship) {
    this.scholarship = scholarship;
    if (scholarship.getStudent() != this) {
      scholarship.setStudent(this);
    }
  }
}
