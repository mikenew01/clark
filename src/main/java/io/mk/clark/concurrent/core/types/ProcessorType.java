package io.mk.clark.concurrent.core.types;

import io.mk.clark.concurrent.core.realms.Data;
import io.mk.clark.concurrent.core.realms.Processor;
import io.mk.clark.concurrent.core.realms.Result;

import java.util.concurrent.ExecutionException;

public interface ProcessorType<T, K> {

    Result run(Data<T> data, Processor<T, K> processor) throws ExecutionException, InterruptedException;

}
