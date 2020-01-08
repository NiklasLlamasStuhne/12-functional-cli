package de.thro.inf.prg3.a12.icndb;

import de.thro.inf.prg3.a12.model.JokeDto;
import de.thro.inf.prg3.a12.model.ResponseWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Objects;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertTimeout;

/**
 * @author Peter Kurfer
 * Created on 12/28/17.
 */
class JokesGeneratorTests {

	private static final Logger logger = LogManager.getLogger();
    private JokeGenerator jokeGenerator = new JokeGenerator();

    @Test
    void testRandomStream() {
        /* TODO implement a test for the random joke stream */
		/* create consumer to ensure that elements are not null and print them for amusement */
		Consumer<String> consumer = MultiConsumer.of(a -> Assertions.assertNotNull(a), m -> logger.info(m));

		/* ensure termination to avoid infinite stream error */

		assertTimeout(Duration.ofSeconds(5L), () -> jokeGenerator.randomJokesStream()
			/* filter null objects */
			.filter(Objects::nonNull)
			/* skip some elements */
			.skip(3)
			/* limit to 5 elements due to infinite stream */
			.limit(5)
			/* unwrap ResponseWrapper */
			.map(ResponseWrapper::getValue)
			/* unwrap actual joke String */
			.map(JokeDto::getJoke)
			/* apply consumer */
			.forEach(consumer)

		);
    }


    @Test
    void testJokesStream() {
        /* TODO implement a test for the linear jokes generator */
		/* create consumer to ensure that elements are not null and print them for amusement */
		Consumer<String> consumer = MultiConsumer.of(Assertions::assertNotNull, logger::info);

		/* ensure termination to avoid infinite stream error */

			/* filter null objects */

			/* unwrap ResponseWrapper */

			/* skip 200 elements to force overflow */

			/* limit to 400 elements due to infinite stream */

			/* unwrap actual joke String */

			/* apply consumer */

    }

}
