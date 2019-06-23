package com.github.maikoncanuto.clark.concurrent.core.processors;

import com.github.maikoncanuto.clark.concurrent.core.realms.Data;
import com.github.maikoncanuto.clark.concurrent.core.realms.Result;
import com.github.maikoncanuto.clark.concurrent.core.types.ProcessorType;
import com.github.maikoncanuto.clark.concurrent.core.realms.Processor;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.Math.*;

/***
 * Class responsible for containing parallel processing logic.
 *
 * @author Maikon Canuto.
 */
public class AsynchronousProcessor implements ProcessorType {

    private final Integer NUMBER_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private final ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_PROCESSORS);

    private AsynchronousProcessor() {
    }

    /***
     * Method for creating an instance of the Asynchronous class.
     *
     * @return AsynchronousProcessor
     */
    public static AsynchronousProcessor getInstance() {
        return new AsynchronousProcessor();
    }

    /***
     * Method for asynchronous processing receiving
     * @param data with information for processing and a
     * @param processor for determining the custom processor.
     *
     * @param data
     * @param processor
     * @return Result<T>
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public Result run(final Data data, final Processor processor) throws ExecutionException, InterruptedException {
        try {
            final List<Future<Result>> results = new LinkedList<>();
            final List dataElementsToProcess = data.getElementsToProcess();

            Integer index = 0, initialPosition = 0,
                    positionOrigin = dataElementsToProcess.size(),
                    itemsByList = getItemsByData(dataElementsToProcess.size(), NUMBER_PROCESSORS);

            while (getProcessingCondition(index, initialPosition, dataElementsToProcess.size(), positionOrigin)) {
                Integer finalPosition = initialPosition + itemsByList;

                if (finalPosition > dataElementsToProcess.size())
                    finalPosition = dataElementsToProcess.size();

                final List lot = dataElementsToProcess.subList(initialPosition, finalPosition);

                Future<Result> resultadoExecutorFuture = executorService.submit(new Callable<Result>() {
                    @Override
                    public Result call() { return processor.run(lot); }
                });

                results.add(resultadoExecutorFuture);
                initialPosition += itemsByList;
                positionOrigin -= itemsByList;
                index++;
            }

            final Result finalResult = new Result();

            for (Future<Result> future : results)
                finalResult.getProcessedElements().addAll(future.get().getProcessedElements());

            return finalResult;
        } finally {
            executorService.shutdown();
        }
    }

    /***
     * Method for determining the quantity of items per batch.
     *
     * @param dataSize
     * @param numberProcessors
     * @return Integer
     */
    private Integer getItemsByData(final Integer dataSize, final Integer numberProcessors){
        if(NUMBER_PROCESSORS <= 0)
            return dataSize;

        if(dataSize <= numberProcessors)
            return dataSize;

        return round(dataSize / NUMBER_PROCESSORS);
    }

    /***
     * Method for determining the stop condition during the processing action.
     *
     * @param index
     * @param initialPosition
     * @param dataSize
     * @param positionOrigin
     * @return Boolean
     */
    private Boolean getProcessingCondition(final Integer index,
                                           final Integer initialPosition,
                                           final Integer dataSize,
                                           final Integer positionOrigin){
        return ((index < NUMBER_PROCESSORS) || !(initialPosition > dataSize)) && positionOrigin > 0;
    }
}
