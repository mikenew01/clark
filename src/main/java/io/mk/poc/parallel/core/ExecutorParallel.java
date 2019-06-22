package io.mk.poc.parallel.core;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorParallel implements IProcessadorExecutor {

    private final Integer CORS = Runtime.getRuntime().availableProcessors();
    private final ExecutorService executorService = Executors.newFixedThreadPool(CORS);

    private ExecutorParallel() {
    }

    public static ExecutorParallel getInstance() {
        return new ExecutorParallel();
    }

    public ResultadoExecutor run(DadosRequisicao dadosRequisicao, IProcessadorRequisicao processadorRequisicao) {
        try {
            final List<Future<ResultadoExecutor>> resultadosExecutors = new LinkedList<>();

            Integer i = 0,
                    inicialSubLista = 0,
                    listaInicial = dadosRequisicao.getLista().size(),
                    elementosPorLista = Math.round(dadosRequisicao.getLista().size() / CORS);

            while ((i < CORS) || !(inicialSubLista > dadosRequisicao.getLista().size())) {
                Integer posicaoFinal = inicialSubLista + elementosPorLista;

                if (posicaoFinal > dadosRequisicao.getLista().size())
                    posicaoFinal = dadosRequisicao.getLista().size();

                List lista = dadosRequisicao.getLista().subList(inicialSubLista, posicaoFinal);

                Future<ResultadoExecutor> resultadoExecutorFuture = executorService.submit(new Callable<ResultadoExecutor>() {
                    @Override
                    public ResultadoExecutor call() {
                        return processadorRequisicao.run(lista);
                    }
                });

                resultadosExecutors.add(resultadoExecutorFuture);
                inicialSubLista += elementosPorLista;
                listaInicial -= elementosPorLista;
                i++;
            }

            final ResultadoExecutor resultadoFinal = new ResultadoExecutor();
            for (Future<ResultadoExecutor> future : resultadosExecutors) {
                try {
                    resultadoFinal.getLista().addAll(future.get().getLista());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            return resultadoFinal;
        } finally {
            executorService.shutdown();
        }
    }
}
