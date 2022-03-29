package paper.foil.service;

import paper.foil.jpashoping.step1.Member;
import paper.foil.sample.ProxyInf;
import paper.foil.sample.entityManagerFactory.UniqueEntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class ProxyTarget implements ProxyInf {
    @Override
    public void save(Member member) {
        EntityManagerFactory entityManagerFactory = UniqueEntityManagerFactory.entityManagerFactory;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        System.out.println("Proxy Implement!!");
        try {
            entityTransaction.begin();
            entityManager.persist(member);
            entityTransaction.commit();
        } catch (Exception exception) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }
}
