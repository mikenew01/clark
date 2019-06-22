package io.mk.executor;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class TransacaoExecutorParalelo implements TransacaoExecutor {

    private Integer PROCESSADORES = 1000; //Definicao de cors
    private final ExecutorService executorService = Executors.newFixedThreadPool(PROCESSADORES); //Criação dos cors para um executor

    //Metodo para processar itens da lista
    @Override
    public Resumo execute(List<Transacao> transacoes) {
        Integer numeroElementosPorLista = transacoes.size() / PROCESSADORES; //determinando quantidade de elementos por lista
        List<Future<Resumo>> resumos = new LinkedList<>(); // Cria objetos para processamento

        Integer posicaoInicial = 0; //Posicao inicial

        //Percorre os nucleos
        for(Integer i = 0; i < PROCESSADORES; i++){

            //Cria a sublista com a quantidade de elementos definidos
            List<Transacao> subLista = transacoes.subList(posicaoInicial, posicaoInicial + numeroElementosPorLista);

            //
            Future<Resumo> resumoFuture = executorService.submit(new Callable<Resumo>() {
                public Resumo call() throws Exception {
                    Resumo resumo = new Resumo();

                    for (Transacao transacao : subLista) {
                        if (transacao.process()) {
                            resumo.addSucesso();
                        } else {
                            resumo.addFalha();
                        }
                    }

                    return resumo;
                }
            });

            resumos.add(resumoFuture);
            posicaoInicial += numeroElementosPorLista;
        }

        Resumo resumoFinal = new Resumo();
        for(Future<Resumo> futureResumo : resumos){
            try {
                resumoFinal.addResumo(futureResumo.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        return resumoFinal;
    }
}
