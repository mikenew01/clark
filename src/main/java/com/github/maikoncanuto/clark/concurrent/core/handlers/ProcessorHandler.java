package com.github.maikoncanuto.clark.concurrent.core.handlers;

import com.github.maikoncanuto.clark.concurrent.core.types.ProcessorType;
import com.github.maikoncanuto.clark.concurrent.core.processors.AsynchronousProcessor;
import com.github.maikoncanuto.clark.concurrent.core.processors.SynchronousProcessor;
import com.github.maikoncanuto.clark.concurrent.core.realms.Type;

/***
 * Class responsible for handling the instances of the ProcessorType.
 *
 * @author Maikon Canuto.
 */
public class ProcessorHandler {

    private ProcessorHandler() {}

    /***
     * Method to retrieve the instance type for the ProcessorType
     *
     * @param type
     * @return AsynchronousProcessor | SynchronousProcessor
     */
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
