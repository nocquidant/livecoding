package live.step4;

import live.JpaApp;
import live.step4.entity.Student4;

import javax.persistence.EntityManager;
import java.util.List;

public class SubApp4 extends JpaApp.SubApp {

  public void execute() {
    // CREATE
    EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();

      Student4 bertrand = new Student4("Bertrand", "123A");
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

      Student4 s = em.find(Student4.class, 1L);
      s.setName("Nicolas");
      s.setName("Toto");

      List<Student4> all = em.createQuery("from Student4 s").getResultList();
      System.out.println("??? " + all.size());

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