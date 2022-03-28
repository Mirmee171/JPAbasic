package bong.lines.sample;

import bong.lines.jpashoping.step1.Member;

import javax.persistence.*;

public class HelloWorldJPA implements HelloWorldJPAExecutor {

    private boolean isAdmin;
    private HelloWorldJPAExecutor executor;

    public HelloWorldJPA(String user, String pwd){
        if("ReadyKim".equals(user) && "correct_pwd".equals(pwd))
            isAdmin = true;
    }

    @Override
    public void runCommand(String command) throws Exception {
        if (isAdmin) {
            executor.runCommand(command);
        }
    }

}
