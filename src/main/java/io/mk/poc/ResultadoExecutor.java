package io.mk.poc;

import java.util.LinkedList;
import java.util.List;

public class ResultadoExecutor<T> {

    private List<T> lista = new LinkedList<>();

    public ResultadoExecutor(){
    }

    public ResultadoExecutor(List<T> lista) {
        this.lista = lista;
    }

    public List<T> getLista() {
        return lista;
    }
}
