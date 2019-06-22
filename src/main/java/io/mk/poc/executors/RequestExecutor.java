package io.mk.poc.executors;

import io.mk.poc.dto.ResultadoPosicaoEstoque;
import io.mk.poc.entity.PosicaoEstoqueRequest;

public interface RequestExecutor {

    ResultadoPosicaoEstoque executeFillObject(PosicaoEstoqueRequest request);

}
