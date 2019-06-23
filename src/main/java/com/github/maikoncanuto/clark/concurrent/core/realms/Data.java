package com.github.maikoncanuto.clark.concurrent.core.realms;

import java.util.LinkedList;
import java.util.List;

/***
 * Contains the information in list format for batch processing.
 *
 * @param <T>
 * @author Maikon Canuto.
 */
public class Data<T> {

    private List<T> elementsToProcess = new LinkedList<>();

    public Data(List<T> elementsToProcess) { this.elementsToProcess = elementsToProcess; }

    /***
     * Contains items already processed successfully.
     * @return List<T>
     */
    public List<T> getElementsToProcess() { return elementsToProcess; }

}
