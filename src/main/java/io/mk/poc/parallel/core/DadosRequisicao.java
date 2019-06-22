package io.mk.poc.parallel.core;

import java.util.LinkedList;
import java.util.List;

public class DadosRequisicao<T> {

    private List<T> lista = new LinkedList<>();

    public DadosRequisicao(List<T> lista) {
        this.lista = lista;
    }

    public List<T> getLista() {
        return lista;
    }
}
