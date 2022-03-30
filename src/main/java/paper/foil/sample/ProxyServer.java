package paper.foil.sample;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ProxyServer implements ProxyInf{
    private final ProxyInf proxyInf;
    public ProxyServer(ProxyInf proxyInf) {
        this.proxyInf = proxyInf;
    }

    @Override
    public void process(EntityManager entityManager) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        try{
            proxyInf.process(entityManager);
        } catch (Exception exception) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }
}
