package io.mk.poc;

import io.mk.poc.dto.ResultadoPosicaoEstoque;
import io.mk.poc.entity.PosicaoEstoqueRequest;
import io.mk.poc.entity.Produto;
import io.mk.poc.executors.PosicaoEstoqueParaleloExecutor;
import io.mk.poc.executors.PosicaoEstoqueSequencialExecutor;
import io.mk.poc.executors.RequestExecutor;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Produto> produtos = new LinkedList<>();
        for(int i = 0; i < 999000; i++){
            Produto produto = new Produto();
            produto.setEstabelecimento("Estabelecimento " + i + " " + new Date());
            produto.setProduto("Produto " + i + " " + new Date());
            produto.setProtocolo("Protocolo " + i + " " + new Date());
            produto.setRegistro("Registro " + i + " " + new Date());
            produtos.add(produto);
        }

        PosicaoEstoqueRequest request = new PosicaoEstoqueRequest();
        request.setProdutos(produtos);

        RequestExecutor requestExecutor =  new PosicaoEstoqueParaleloExecutor();
        ResultadoPosicaoEstoque resultadoPosicaoEstoque = requestExecutor.executeFillObject(request);
        System.out.println(resultadoPosicaoEstoque.getPosicoes().size());
    }
}
