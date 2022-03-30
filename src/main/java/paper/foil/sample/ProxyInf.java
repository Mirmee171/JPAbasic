package paper.foil.sample;

import paper.foil.jpashoping.step1.Member;

import javax.persistence.EntityManager;

@FunctionalInterface
public interface ProxyInf {
    void process(EntityManager entityManager);
}
