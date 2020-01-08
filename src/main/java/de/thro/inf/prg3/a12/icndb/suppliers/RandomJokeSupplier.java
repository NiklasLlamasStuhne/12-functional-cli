package de.thro.inf.prg3.a12.icndb.suppliers;

import de.thro.inf.prg3.a12.icndb.ICNDBApi;
import de.thro.inf.prg3.a12.icndb.ICNDBService;
import de.thro.inf.prg3.a12.model.JokeDto;
import de.thro.inf.prg3.a12.model.ResponseWrapper;
import org.apache.commons.lang3.NotImplementedException;

import java.util.function.Supplier;

/**
 * @author Peter Kurfer
 */

public final class RandomJokeSupplier implements Supplier {

    /* ICNDB API proxy to retrieve jokes */
    private final ICNDBApi icndbApi;

    public RandomJokeSupplier() {
        icndbApi = ICNDBService.getInstance();
    }

    public ResponseWrapper<JokeDto> get() {
        /* TODO fetch a random joke synchronously

		 * return tryCatch(() -> icndbApi.getRandomJoke().get(), () -> null);

         * if an exception occurs return null */

        try {
        	return icndbApi.getRandomJoke().get();
		}catch(Exception e ){
        	return null;
		}

    }
}
