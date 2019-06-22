package io.mk.poc.executors;

import io.mk.poc.dto.ResultadoPosicaoEstoque;
import io.mk.poc.entity.PosicaoEstoque;
import io.mk.poc.entity.PosicaoEstoqueRequest;
import io.mk.poc.entity.Produto;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class PosicaoEstoqueParaleloExecutor implements RequestExecutor {

    private Integer CORS = Runtime.getRuntime().availableProcessors();
    private final ExecutorService executorService = Executors.newFixedThreadPool(CORS);

    public ResultadoPosicaoEstoque executeFillObject(PosicaoEstoqueRequest request){
        try{
            List<Future<ResultadoPosicaoEstoque>> resumos = new LinkedList<>();

            Integer i = 0,
                    posicaoInicialSubLista = 0,
                    quantidadeListaInicial = request.getProdutos().size(),
                    numeroElementosPorLista = Math.round(request.getProdutos().size() / CORS);

            while((i < CORS) || !(posicaoInicialSubLista > request.getProdutos().size())){
                Integer posicaoFinal = posicaoInicialSubLista + numeroElementosPorLista;
                if(posicaoFinal > request.getProdutos().size())
                    posicaoFinal = request.getProdutos().size();

                List<Produto> produtos = request.getProdutos().subList(posicaoInicialSubLista, posicaoFinal);

                Future<ResultadoPosicaoEstoque> resumoPosicao = executorService.submit(new Callable<ResultadoPosicaoEstoque>() {
                    @Override
                    public ResultadoPosicaoEstoque call() {
                        ResultadoPosicaoEstoque resultadoPosicaoEstoque = new ResultadoPosicaoEstoque();

                        for(Produto produto : produtos){
                            PosicaoEstoque posicaoEstoque = new PosicaoEstoque();
                            posicaoEstoque.setRegistro(produto.getRegistro());
                            posicaoEstoque.setEstabelecimento(produto.getEstabelecimento());
                            posicaoEstoque.setProduto(produto.getProduto());
                            posicaoEstoque.setProtocolo(produto.getProtocolo());

                            resultadoPosicaoEstoque.getPosicoes().add(posicaoEstoque);
                            System.out.println(posicaoEstoque);
                        }

                        return resultadoPosicaoEstoque;
                    }
                });

                resumos.add(resumoPosicao);
                posicaoInicialSubLista += numeroElementosPorLista;
                quantidadeListaInicial -= numeroElementosPorLista;
                i++;
            }

            ResultadoPosicaoEstoque resultadoFinal = new ResultadoPosicaoEstoque();
            for(Future<ResultadoPosicaoEstoque> future : resumos){
                try {
                    resultadoFinal.getPosicoes().addAll(future.get().getPosicoes());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

            return resultadoFinal;
        }finally {
            executorService.shutdown();
        }
    }
}
