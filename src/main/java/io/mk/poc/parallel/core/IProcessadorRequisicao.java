package io.mk.poc.parallel.core;

import io.mk.poc.entity.Produto;

import java.util.List;

public interface IProcessadorRequisicao<T> {

    ResultadoExecutor<T> run(List<Produto> lista);

}
