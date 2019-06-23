package com.github.maikoncanuto.clark.clark.concurrent.core.handlers;

import com.github.maikoncanuto.clark.clark.concurrent.core.types.ProcessorType;
import com.github.maikoncanuto.clark.clark.concurrent.core.processors.AsynchronousProcessor;
import com.github.maikoncanuto.clark.clark.concurrent.core.processors.SynchronousProcessor;
import com.github.maikoncanuto.clark.clark.concurrent.core.realms.Type;

public class ProcessorHandler {

    private ProcessorHandler() {
    }

    public static ProcessorType getProcessor(Type type) {
        switch (type) {
            case ASYNCHRONOUS:
                return AsynchronousProcessor.getInstance();
            case SYNCHRONOUS:
                return SynchronousProcessor.getInstance();
            default:
                return null;
        }
    }
}
