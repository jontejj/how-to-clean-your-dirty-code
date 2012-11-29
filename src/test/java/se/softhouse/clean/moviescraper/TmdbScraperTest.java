package se.softhouse.clean.moviescraper;

import static com.google.common.io.Resources.getResource;
import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;

public class TmdbScraperTest
{
	@Test
	public void testScrapingTitleAndDescriptionAndRating()
			throws ScrapeException, IOException
	{
		Movie sincity = TmdbScraper.scrape(getResource("sincity.xml")
				.openStream());

		assertThat(sincity.title).isEqualTo("Sin City");
		assertThat(sincity.rating).isEqualTo(6.8);
		assertThat(sincity.tagline).isEqualTo(
				"There is no justice without sin.");

	}
}
