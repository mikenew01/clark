package com.github.maikoncanuto.clark;

import com.github.maikoncanuto.clark.concurrent.core.handlers.ProcessorHandler;
import com.github.maikoncanuto.clark.concurrent.core.realms.Data;
import com.github.maikoncanuto.clark.concurrent.core.realms.Result;
import com.github.maikoncanuto.clark.concurrent.core.realms.Type;
import com.github.maikoncanuto.clark.entity.PosicaoEstoque;
import com.github.maikoncanuto.clark.entity.PosicaoEstoqueRequest;
import com.github.maikoncanuto.clark.entity.Produto;
import com.github.maikoncanuto.clark.processors.PosicaoEstoqueProcessor;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Produto> produtos = new LinkedList<>();
        for (int i = 0; i < 700000; i++) {
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
