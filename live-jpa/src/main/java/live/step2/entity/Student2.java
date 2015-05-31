package live.step2.entity;

import javax.persistence.*;

@Entity
public class Student2 {
  @Id
  @GeneratedValue
  private Long id;

  @Basic
  private String name;

  @Basic
  private String registrationNb;

  public Student2() {

  }

  public Student2(String name, String registrationNb) {
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
