package io.mk.clark.processors;

import io.mk.clark.entity.PosicaoEstoque;
import io.mk.clark.entity.Produto;
import io.mk.clark.concurrent.core.realms.Processor;
import io.mk.clark.concurrent.core.realms.Result;

import java.util.List;

public class PosicaoEstoqueProcessor implements Processor<PosicaoEstoque, Produto> {

    @Override
    public Result<PosicaoEstoque> run(final List<Produto> list) {
        final Result<PosicaoEstoque> result = new Result<>();

        for (Produto produto : list) {
            final PosicaoEstoque posicaoEstoque = new PosicaoEstoque();
            posicaoEstoque.setRegistro(produto.getRegistro());
            posicaoEstoque.setEstabelecimento(produto.getEstabelecimento());
            posicaoEstoque.setProduto(produto.getProduto());
            posicaoEstoque.setProtocolo(produto.getProtocolo());

            result.getProcessedElements().add(posicaoEstoque);

            System.out.println(posicaoEstoque);
        }

        return result;
    }
}
