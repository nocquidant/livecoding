package live.step4;

import live.JpaApp;
import live.step4.entity.Student4;

import javax.persistence.EntityManager;

public class SubApp4bis extends JpaApp.SubApp {

  public void execute() {
    EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();

      Student4 s = em.find(Student4.class, 1L);
      s.setName("Romain");

      em.getTransaction().commit();
    } catch(Exception e) {
      e.printStackTrace();
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
    } finally {
      em.close();
    }
  }
}