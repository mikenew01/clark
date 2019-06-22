package io.mk.executor;

import java.util.List;

public interface TransacaoExecutor {

    Resumo execute(List<Transacao> transacoes);

}
