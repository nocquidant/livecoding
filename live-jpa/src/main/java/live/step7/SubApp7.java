package live.step7;

import live.JpaApp;
import live.step7.entity.ExamResult7;
import live.step7.entity.Student7;

import javax.persistence.EntityManager;
import java.util.List;

public class SubApp7 extends JpaApp.SubApp {

  public void execute() {
    EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();

      Student7 bertrand = new Student7("Bertrand", "123A");
      ExamResult7 math = new ExamResult7("math", "01/01/2015", 16);
      ExamResult7 it = new ExamResult7("it", "10/01/2015", 11);

      bertrand.getResults().add(math);
      bertrand.getResults().add(it);

      em.persist(bertrand);

      Student7 nic = new Student7("Nicolas", "321A");
      ExamResult7 mathNic = new ExamResult7("math", "01/01/2015", 14);
      ExamResult7 itNic = new ExamResult7("it", "10/01/2015", 14);

      nic.getResults().add(mathNic);
      nic.getResults().add(itNic);

      em.persist(nic);

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

      List<Student7> students = em.createQuery("from Student7 s").getResultList();
      //List<Student7> students = em.createQuery("from Student7 s join fetch s.results").getResultList();

      for (Student7 s : students) {
        int size = s.getResults().size();
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