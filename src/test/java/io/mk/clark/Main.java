package io.mk.clark;

import io.mk.clark.concurrent.core.handlers.ProcessorHandler;
import io.mk.clark.concurrent.core.realms.Data;
import io.mk.clark.concurrent.core.realms.Result;
import io.mk.clark.concurrent.core.realms.Type;
import io.mk.clark.entity.PosicaoEstoque;
import io.mk.clark.entity.PosicaoEstoqueRequest;
import io.mk.clark.entity.Produto;
import io.mk.clark.processors.PosicaoEstoqueProcessor;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Produto> produtos = new LinkedList<>();
        for (int i = 0; i < 5000; i++) {
            Produto produto = new Produto();
            produto.setEstabelecimento("Estabelecimento " + i + " " + new Date());
            produto.setProduto("Produto " + i + " " + new Date());
            produto.setProtocolo("Protocolo " + i + " " + new Date());
            produto.setRegistro("Registro " + i + " " + new Date());
            produtos.add(produto);
        }

        PosicaoEstoqueRequest request = new PosicaoEstoqueRequest();
        request.setProdutos(produtos);

        Result<PosicaoEstoque> resultado =
                ProcessorHandler
                        .getProcessor(Type.ASYNCHRONOUS)
                        .run(new Data<>(request.getProdutos()), new PosicaoEstoqueProcessor());

        System.out.println(resultado.getProcessedElements().size());

    }
}
