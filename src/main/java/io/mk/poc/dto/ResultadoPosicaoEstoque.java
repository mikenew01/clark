package io.mk.poc.dto;

import io.mk.poc.entity.PosicaoEstoque;

import java.util.LinkedList;
import java.util.List;

public class ResultadoPosicaoEstoque {

    private List<PosicaoEstoque> posicoes = new LinkedList<>();

    public ResultadoPosicaoEstoque() {
    }

    public ResultadoPosicaoEstoque(List<PosicaoEstoque> posicoes) {
        this.posicoes = posicoes;
    }

    public List<PosicaoEstoque> getPosicoes() {
        return posicoes;
    }
}
