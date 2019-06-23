package com.github.maikoncanuto.clark.concurrent.core.processors;

import com.github.maikoncanuto.clark.concurrent.core.realms.Data;
import com.github.maikoncanuto.clark.concurrent.core.realms.Result;
import com.github.maikoncanuto.clark.concurrent.core.types.ProcessorType;
import com.github.maikoncanuto.clark.concurrent.core.realms.Processor;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.Math.*;

public class AsynchronousProcessor implements ProcessorType {

    private final Integer NUMBER_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private final ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_PROCESSORS);

    private AsynchronousProcessor() {
    }

    public static AsynchronousProcessor getInstance() {
        return new AsynchronousProcessor();
    }

    public Result run(final Data data, final Processor processor) throws ExecutionException, InterruptedException {
        try {
            final List<Future<Result>> results = new LinkedList<>();
            final List dataElementsToProcess = data.getElementsToProcess();

            Integer index = 0, initialPosition = 0,
                    positionOrigin = dataElementsToProcess.size(),
                    itemsByList = round(dataElementsToProcess.size() / NUMBER_PROCESSORS);

            while ((index < NUMBER_PROCESSORS) || !(initialPosition > dataElementsToProcess.size())) {
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
}
