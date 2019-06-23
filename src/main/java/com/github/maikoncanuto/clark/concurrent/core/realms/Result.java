package com.github.maikoncanuto.clark.concurrent.core.realms;

import java.util.LinkedList;
import java.util.List;

/***
 * Class responsible for maintaining the list of processing results.
 * @param <T>
 *
 * @author Maikon Canuto.
 */
public class Result<T> {

    private List<T> processedElements = new LinkedList<>(), unprocessedElements = new LinkedList<>();

    public Result() {
    }

    /***
     * Method for retrieving the processed data.
     * @return List<T>
     */
    public List<T> getProcessedElements() { return processedElements; }


    /***
     * Method for recovering raw data
     * @return List<T>
     */
    @Deprecated
    public List<T> getUnprocessedElements() { return unprocessedElements; }

}
