package paper.foil.sample;

import paper.foil.jpashoping.step1.Member;
import paper.foil.service.ProxyTarget;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProxyMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("hello");

        // use lamda
        Member member = new Member();
        member.setId(2L);
        member.setTeamId(1L);
        member.setUsername("paperFoil");

        ProxyInf proxyInf = new ProxyServer((entityManager -> {
            entityManager.persist(member);
        }));

        proxyInf.process(entityManagerFactory.createEntityManager());

        // use class
        ProxyInf proxyInf1 = new ProxyServer(new ProxyTarget());

        proxyInf1.process(entityManagerFactory.createEntityManager());

    }
}
