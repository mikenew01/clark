package com.github.maikoncanuto.clark.concurrent.core.realms;

import java.util.LinkedList;
import java.util.List;

public class Result<T> {

    private List<T> processedElements = new LinkedList<>(), unprocessedElements = new LinkedList<>();

    public Result() {
    }

    public List<T> getProcessedElements() { return processedElements; }

    public List<T> getUnprocessedElements() { return unprocessedElements; }

}
