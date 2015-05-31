package live.step1.entity;

public class Scholarship1 {
  private String description;
  private Integer amount;
  private Student1 student;

  public Scholarship1() {

  }

  public Scholarship1(String description, Integer amount) {
    this.description = description;
    this.amount = amount;
  }

  public Student1 getStudent() {
    return student;
  }

  public void setStudent(Student1 student) {
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
