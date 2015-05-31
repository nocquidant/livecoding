package live.step5.entity;

import javax.persistence.*;

@Entity
public class Scholarship5 {
  @Id
  @GeneratedValue
  private Long id;

  @Version
  private Long version;

  @Basic
  private String description;

  @Basic
  private Integer amount;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(unique = true)
  private Student5 student;

  public Scholarship5() {

  }

  public Scholarship5(String description, Integer amount) {
    this.description = description;
    this.amount = amount;
  }

  public Long getId() {
    return id;
  }

  public Student5 getStudent() {
    return student;
  }

  public void setStudent(Student5 student) {
    this.student = student;
    if (student.getScholarship() != this) {
      student.setScholarship(this);
    }
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }
}
