package se.softhouse.dirty.moviescraper;

import static com.google.common.io.Resources.getResource;
import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class TmdbScraperTest
{
	@Test
	public void testScrapingTitleAndDescriptionAndRating() throws IOException,
			ParserConfigurationException, SAXException
	{
		Movie sincity = TmdbScraper.scrape(getResource("sincity.xml")
				.openStream());

		assertThat(sincity.title).isEqualTo("Sin City");
		assertThat(sincity.rating).isEqualTo(6.8f);
		assertThat(sincity.tagline).isEqualTo(
				"There is no justice without sin.");

	}
}
