package io.mk.clark.concurrent.core.realms;

import java.util.List;

public interface Processor<T, K> {

    Result<T> run(List<K> lista);

}
