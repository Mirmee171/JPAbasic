package paper.foil.service;

import paper.foil.jpashoping.step1.Member;
import paper.foil.sample.ProxyInf;
import paper.foil.sample.entityManagerFactory.UniqueEntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class ProxyTarget implements ProxyInf {
    @Override
    public void process(EntityManager entityManager) {
        Member member = new Member();
        member.setId(2L);
        member.setTeamId(1L);
        member.setUsername("paperFoil");

        entityManager.persist(member);
    }
}
