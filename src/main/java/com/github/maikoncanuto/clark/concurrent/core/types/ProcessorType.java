package com.github.maikoncanuto.clark.concurrent.core.types;

import com.github.maikoncanuto.clark.concurrent.core.realms.Data;
import com.github.maikoncanuto.clark.concurrent.core.realms.Result;
import com.github.maikoncanuto.clark.concurrent.core.realms.Processor;

import java.util.concurrent.ExecutionException;


/***
 * Interface responsible for grouping the types of processors, asynchronous and synchronous.
 *
 * @param <T> - Return type
 * @param <K> - Parameter list type
 * @author Maikon Canuto.
 */
public interface ProcessorType<T, K> {

    /***
     * Method responsible for containing the processing logic.
     *
     * @param data
     * @param processor
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    Result run(Data<T> data, Processor<T, K> processor) throws ExecutionException, InterruptedException;

}
