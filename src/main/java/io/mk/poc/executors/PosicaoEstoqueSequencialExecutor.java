package io.mk.poc.executors;

import io.mk.poc.dto.ResultadoPosicaoEstoque;
import io.mk.poc.entity.PosicaoEstoque;
import io.mk.poc.entity.PosicaoEstoqueRequest;
import io.mk.poc.entity.Produto;

public class PosicaoEstoqueSequencialExecutor implements RequestExecutor {

    @Override
    public ResultadoPosicaoEstoque executeFillObject(PosicaoEstoqueRequest request) {
        ResultadoPosicaoEstoque resultadoPosicaoEstoque = new ResultadoPosicaoEstoque();

        for(Produto produto : request.getProdutos()){
            PosicaoEstoque posicaoEstoque = new PosicaoEstoque();
            posicaoEstoque.setEstabelecimento(produto.getEstabelecimento());
            posicaoEstoque.setProduto(produto.getProduto());
            posicaoEstoque.setProtocolo(produto.getProtocolo());
            posicaoEstoque.setRegistro(produto.getRegistro());

            resultadoPosicaoEstoque.getPosicoes().add(posicaoEstoque);
            System.out.println(posicaoEstoque);
        }

        return resultadoPosicaoEstoque;
    }
}
