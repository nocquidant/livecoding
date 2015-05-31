package live.step5.entity;

import javax.persistence.*;

@Entity
public class Student5 {
  @Id
  @GeneratedValue
  private Long id;

  @Version
  private Long version;

  @Basic
  private String name;

  @Basic
  private String registrationNb;

  @OneToOne(mappedBy = "student")
  private Scholarship5 scholarship;

  public Student5() {

  }

  public Student5(String name, String registrationNb) {
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

  public Scholarship5 getScholarship() {
    return scholarship;
  }

  public void setScholarship(Scholarship5 scholarship) {
    this.scholarship = scholarship;
    if (scholarship.getStudent() != this) {
      scholarship.setStudent(this);
    }
  }
}
