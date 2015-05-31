package live.step6.entity;

import javax.persistence.*;

@Entity
public class ExamResult6 {
  @Id
  @GeneratedValue
  private Long id;

  @Version
  private Long version;

  @Basic private String exam;
  @Basic private String date;
  @Basic private Integer mark;

  public ExamResult6() {
  }

  public ExamResult6(String exam, String date, Integer mark) {
    this.exam = exam;
    this.date = date;
    this.mark = mark;
  }

  public Long getId() {
    return id;
  }

  public String getExam() {
    return exam;
  }

  public void setExam(String exam) {
    this.exam = exam;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Integer getMark() {
    return mark;
  }

  public void setMark(Integer mark) {
    this.mark = mark;
  }
}
