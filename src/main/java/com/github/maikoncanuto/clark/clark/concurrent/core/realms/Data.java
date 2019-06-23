package com.github.maikoncanuto.clark.clark.concurrent.core.realms;

import java.util.LinkedList;
import java.util.List;

public class Data<T> {

    private List<T> elementsToProcess = new LinkedList<>();

    public Data(List<T> elementsToProcess) { this.elementsToProcess = elementsToProcess; }

    public List<T> getElementsToProcess() { return elementsToProcess; }

}
