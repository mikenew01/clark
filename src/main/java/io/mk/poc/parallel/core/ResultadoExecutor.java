package io.mk.poc.parallel.core;

import java.util.LinkedList;
import java.util.List;

public class ResultadoExecutor<T> {

    private List<T> lista = new LinkedList<>();

    public ResultadoExecutor() {
    }

    public List<T> getLista() {
        return lista;
    }
}
