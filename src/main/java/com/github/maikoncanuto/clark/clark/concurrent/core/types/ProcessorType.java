package com.github.maikoncanuto.clark.clark.concurrent.core.types;

import com.github.maikoncanuto.clark.clark.concurrent.core.realms.Data;
import com.github.maikoncanuto.clark.clark.concurrent.core.realms.Result;
import com.github.maikoncanuto.clark.clark.concurrent.core.realms.Processor;

import java.util.concurrent.ExecutionException;

public interface ProcessorType<T, K> {

    Result run(Data<T> data, Processor<T, K> processor) throws ExecutionException, InterruptedException;

}
