package io.mk.clark.concurrent.core.handlers;

import io.mk.clark.concurrent.core.processors.AsynchronousProcessor;
import io.mk.clark.concurrent.core.processors.SynchronousProcessor;
import io.mk.clark.concurrent.core.realms.Type;
import io.mk.clark.concurrent.core.types.ProcessorType;

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
