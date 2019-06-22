package io.mk.executor;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        TransacaoExecutor transacaoExecutor = new TransacaoExecutorParalelo();

        List<Transacao> transacoes = new LinkedList<>();

        for(int i = 0; i < 5000; i++){
            transacoes.add(new Transacao(Long.valueOf(i)));
        }

        Resumo resumo = transacaoExecutor.execute(transacoes);

        System.out.println("Sucesso: " + resumo.getSucesso());
        System.out.println("Falha: " + resumo.getFalha());

    }

}
