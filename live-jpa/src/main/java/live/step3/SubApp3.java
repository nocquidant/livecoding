package live.step3;

import live.JpaApp;
import live.step3.entity.Student3;

import javax.persistence.EntityManager;

public class SubApp3 extends JpaApp.SubApp {

  public void execute() {
    // CREATE
    EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();

      Student3 bertrand = new Student3("Bertrand", "123A");
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

    // READ
    em = emf.createEntityManager();
    try {
      em.getTransaction().begin();

      Student3 s = em.find(Student3.class, 1L);

      System.out.println("s.name = " + s.getName());

      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
    } finally {
      em.close();
    }

    // UPDATE
    em = emf.createEntityManager();
    try {
      em.getTransaction().begin();

      Student3 s = em.find(Student3.class, 1L);
      s.setName("Nicolas");

      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
    } finally {
      em.close();
    }

    // DELETE
    em = emf.createEntityManager();
    try {
      em.getTransaction().begin();

      Student3 s = em.find(Student3.class, 1L);
      em.remove(s);

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