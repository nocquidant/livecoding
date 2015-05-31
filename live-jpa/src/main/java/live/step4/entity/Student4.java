package live.step4.entity;

import javax.persistence.*;

@Entity
public class Student4 {
  @Id
  @GeneratedValue
  private Long id;

  //@Version
  //private Long version;

  @Basic
  private String name;

  @Basic
  private String registrationNb;

  public Student4() {

  }

  public Student4(String name, String registrationNb) {
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
