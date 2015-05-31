package live.step3.entity;

import javax.persistence.*;

@Entity
public class Student3 {
  @Id
  @GeneratedValue
  private Long id;

  @Basic
  private String name;

  @Basic
  private String registrationNb;

  public Student3() {

  }

  public Student3(String name, String registrationNb) {
    this.name = name;
    this.registrationNb = registrationNb;
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
