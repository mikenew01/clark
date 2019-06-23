package com.github.maikoncanuto.clark.concurrent.core.processors;

import com.github.maikoncanuto.clark.concurrent.core.realms.Data;
import com.github.maikoncanuto.clark.concurrent.core.realms.Result;
import com.github.maikoncanuto.clark.concurrent.core.types.ProcessorType;
import com.github.maikoncanuto.clark.concurrent.core.realms.Processor;

import java.util.concurrent.ExecutionException;

/***
 * Class responsible for containing the synchronous processing logic
 *
 * @author Maikon Canuto.
 */
public class SynchronousProcessor implements ProcessorType {

    private SynchronousProcessor(){}

    /***
     * Method responsible for creating SynchronousProcessor instances
     *
     * @return SynchronousProcessor
     */
    public static SynchronousProcessor getInstance(){
        return new SynchronousProcessor();
    }

    /***
     * Method for synchronous processing receiving
     * @param data with information for processing and a
     * @param processor for determining the custom processor.
     *
     * @param data
     * @param processor
     * @return Result<T>
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Override
    public Result run(Data data, Processor processor) throws ExecutionException, InterruptedException {
        return processor.run(data.getElementsToProcess());
    }
}
