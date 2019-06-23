package io.mk.clark.entity;

import java.util.List;

public class PosicaoEstoqueRequest {

    private List<Produto> produtos;

    public PosicaoEstoqueRequest() {
    }

    public PosicaoEstoqueRequest(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
