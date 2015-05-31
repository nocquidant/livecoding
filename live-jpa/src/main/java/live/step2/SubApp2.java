package live.step2;

import live.JpaApp;
import live.step2.entity.Student2;

import javax.persistence.EntityManager;

public class SubApp2 extends JpaApp.SubApp {

  public void execute() {
    EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();

      // if (true) throw new RuntimeException("oups");

      Student2 bertrand = new Student2("Bertrand", "123A");
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
  }
}