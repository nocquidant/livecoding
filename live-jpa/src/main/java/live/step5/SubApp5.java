package live.step5;

import live.JpaApp;
import live.step5.entity.Scholarship5;
import live.step5.entity.Student5;

import javax.persistence.EntityManager;

public class SubApp5 extends JpaApp.SubApp {

  public void execute() {
    EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();

      Student5 bertrand = new Student5("Bertrand", "123A");
      Scholarship5 scholarship = new Scholarship5("Scolarité de B", 100);
      bertrand.setScholarship(scholarship);

      //Scholarship5 scholarshipNew = new Scholarship5("Scolarité", 100);
      //bertrand.setScholarship(scholarshipNew);

      em.persist(scholarship);
      //em.persist(scholarshipNew);

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