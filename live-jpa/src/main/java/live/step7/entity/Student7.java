package live.step7.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student7 {
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
  private List<ExamResult7> results = new ArrayList<>();

  public Student7() {

  }

  public Student7(String name, String registrationNb) {
    this.name = name;
    this.registrationNb = registrationNb;
  }

  public List<ExamResult7> getResults() {
    return results;
  }

  public void setResults(List<ExamResult7> results) {
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
