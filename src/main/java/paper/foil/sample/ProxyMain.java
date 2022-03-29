package paper.foil.sample;

import paper.foil.jpashoping.step1.Member;
import paper.foil.sample.entityManagerFactory.UniqueEntityManagerFactory;
import paper.foil.service.ProxyTarget;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProxyMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        UniqueEntityManagerFactory.entityManagerFactory = entityManagerFactory;

        Member member = new Member();
        member.setId(2L);
        member.setTeamId(1L);
        member.setUsername("paperFoil");

        ProxyInf proxyInf = new ProxyServer(new ProxyTarget());
        proxyInf.save(member);
        UniqueEntityManagerFactory.entityManagerFactory.close();
    }
}
