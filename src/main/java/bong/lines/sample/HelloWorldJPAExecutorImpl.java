package bong.lines.sample;

import bong.lines.jpashoping.step1.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HelloWorldJPAExecutorImpl implements HelloWorldJPAExecutor {

    @Override
    public void runCommand(String command) throws Exception {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        try {
            Member member = new Member();
            member.setId(2L);
            member.setUsername("Hello");
            entityManager.persist(member);
            entityTransaction.commit();
            //begin
        } catch (Exception exception) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }
}
