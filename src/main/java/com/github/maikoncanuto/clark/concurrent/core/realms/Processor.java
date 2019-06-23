package com.github.maikoncanuto.clark.concurrent.core.realms;

import java.util.List;

/***
 * Interface responsible for grouping the custom processors,
 * defining the implementation of the method
 * @param <T>
 * @param <K>
 *
 * @author Maikon Canuto.
 */
public interface Processor<T, K> {

    /***
     * Method responsible for containing the processing logic
     * @param lista
     * @return Result<T>
     */
    Result<T> run(List<K> lista);

}
