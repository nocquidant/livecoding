package live.step6;

import live.JpaApp;
import live.step6.entity.ExamResult6;
import live.step6.entity.Student6;

import javax.persistence.EntityManager;
import java.util.List;

public class SubApp6 extends JpaApp.SubApp {

  public void execute() {
    EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();

      Student6 bertrand = new Student6("Bertrand", "123A");
      ExamResult6 math = new ExamResult6("math", "01/01/2015", 16);
      ExamResult6 it = new ExamResult6("it", "10/01/2015", 11);

      bertrand.getResults().add(math);
      bertrand.getResults().add(it);

      em.persist(bertrand);

      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
    } finally {
      em.close();
    }

    em = emf.createEntityManager();
    try {
      em.getTransaction().begin();

      Student6 bertrand = em.find(Student6.class, 1L);
      List<ExamResult6> results =  bertrand.getResults();

      for (ExamResult6 each : results) {
        System.out.println("mark for: " + each.getExam() + " is: " + each.getMark());
      }

      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
    } finally {
      em.close();
    }
  }
}