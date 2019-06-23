package io.mk.clark.concurrent.core.processors;

import io.mk.clark.concurrent.core.realms.Data;
import io.mk.clark.concurrent.core.realms.Processor;
import io.mk.clark.concurrent.core.realms.Result;
import io.mk.clark.concurrent.core.types.ProcessorType;

import java.util.concurrent.ExecutionException;

public class SynchronousProcessor implements ProcessorType {

    private SynchronousProcessor(){}

    public static SynchronousProcessor getInstance(){
        return new SynchronousProcessor();
    }

    @Override
    public Result run(Data data, Processor processor) throws ExecutionException, InterruptedException {
        return processor.run(data.getElementsToProcess());
    }
}
