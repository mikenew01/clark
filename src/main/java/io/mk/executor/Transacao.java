package io.mk.executor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Transacao {

    private static final Logger log = Logger.getLogger(Transacao.class.getName());

    private final Long id;

    public Transacao(Long id){
        this.id = id;
    }

    public Boolean process(){
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Boolean sucess = id % 10 != 0;
        log.log(Level.INFO, "Transacao: " + id + "; Result: " + sucess);
        return sucess;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                '}';
    }
}
