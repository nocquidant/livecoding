package live.step1.entity;

public class ExamResult1 {
  private String exam;
  private String date;
  private Integer mark;

  public ExamResult1() {
  }

  public ExamResult1(String exam, String date, Integer mark) {
    this.exam = exam;
    this.date = date;
    this.mark = mark;
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
