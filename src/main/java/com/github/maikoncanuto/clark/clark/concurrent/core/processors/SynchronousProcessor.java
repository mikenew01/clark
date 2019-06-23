package com.github.maikoncanuto.clark.clark.concurrent.core.processors;

import com.github.maikoncanuto.clark.clark.concurrent.core.realms.Data;
import com.github.maikoncanuto.clark.clark.concurrent.core.realms.Result;
import com.github.maikoncanuto.clark.clark.concurrent.core.types.ProcessorType;
import com.github.maikoncanuto.clark.clark.concurrent.core.realms.Processor;

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
