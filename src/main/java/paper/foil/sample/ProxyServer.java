package paper.foil.sample;

import paper.foil.jpashoping.step1.Member;

public class ProxyServer implements ProxyInf{
    private final ProxyInf proxyInf;
    public ProxyServer(ProxyInf proxyInf) {
        this.proxyInf = proxyInf;
    }

    @Override
    public void save(Member member) {
        proxyInf.save(member);
    }

}
