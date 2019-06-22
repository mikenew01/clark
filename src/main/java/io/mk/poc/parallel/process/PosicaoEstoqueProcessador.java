package io.mk.poc.parallel.process;

import io.mk.poc.entity.PosicaoEstoque;
import io.mk.poc.entity.Produto;
import io.mk.poc.parallel.core.IProcessadorRequisicao;
import io.mk.poc.parallel.core.ResultadoExecutor;

import java.util.List;

public class PosicaoEstoqueProcessador implements IProcessadorRequisicao<PosicaoEstoque> {

    public PosicaoEstoqueProcessador() {
    }

    @Override
    public ResultadoExecutor<PosicaoEstoque> run(final List<Produto> lista) {
        final ResultadoExecutor<PosicaoEstoque> resultado = new ResultadoExecutor<>();

        for (Produto produto : lista) {
            final PosicaoEstoque posicaoEstoque = new PosicaoEstoque();
            posicaoEstoque.setRegistro(produto.getRegistro());
            posicaoEstoque.setEstabelecimento(produto.getEstabelecimento());
            posicaoEstoque.setProduto(produto.getProduto());
            posicaoEstoque.setProtocolo(produto.getProtocolo());

            resultado.getLista().add(posicaoEstoque);
            System.out.println(posicaoEstoque);
        }

        return resultado;
    }
}
