package io.mk.executor;

import java.util.List;

public class TransacaoExecutorSequencial implements TransacaoExecutor {

    @Override
    public Resumo execute(List<Transacao> transacoes) {
        Resumo resumo = new Resumo();

        for(Transacao transacao : transacoes){
            if(transacao.process()){
                resumo.addSucesso();
            }else{
                resumo.addFalha();
            }
        }

        return resumo;
    }
}
