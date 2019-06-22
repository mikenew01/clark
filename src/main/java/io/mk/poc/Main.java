package io.mk.poc;

import io.mk.poc.entity.PosicaoEstoque;
import io.mk.poc.entity.PosicaoEstoqueRequest;
import io.mk.poc.entity.Produto;
import io.mk.poc.parallel.core.DadosRequisicao;
import io.mk.poc.parallel.core.ExecutorParallel;
import io.mk.poc.parallel.process.PosicaoEstoqueProcessador;
import io.mk.poc.parallel.core.ResultadoExecutor;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

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

        ResultadoExecutor<PosicaoEstoque> resultadoPosicaoEstoque =
                ExecutorParallel
                .getInstance()
                .run(new DadosRequisicao<>(request.getProdutos()), new PosicaoEstoqueProcessador());
        System.out.println(resultadoPosicaoEstoque.getLista().size());
    }
}
