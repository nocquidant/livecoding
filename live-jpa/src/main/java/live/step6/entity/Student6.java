package live.step6.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student6 {
  @Id
  @GeneratedValue
  private Long id;

  @Version
  private Long version;

  @Basic
  private String name;

  @Basic
  private String registrationNb;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(referencedColumnName = "id")
  private List<ExamResult6> results = new ArrayList<>();

  public Student6() {

  }

  public Student6(String name, String registrationNb) {
    this.name = name;
    this.registrationNb = registrationNb;
  }

  public List<ExamResult6> getResults() {
    return results;
  }

  public void setResults(List<ExamResult6> results) {
    this.results = results;
  }

  public Long getId() {
    return id;
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
}
