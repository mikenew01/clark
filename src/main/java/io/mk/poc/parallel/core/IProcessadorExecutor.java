package io.mk.poc.parallel.core;

public interface IProcessadorExecutor<T> {

    ResultadoExecutor run(DadosRequisicao<T> dadosRequisicao, IProcessadorRequisicao<T> processadorRequisicao);

}
