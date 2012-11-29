package se.softhouse.benchmarks;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import se.softhouse.clean.moviescraper.ScrapeException;
import se.softhouse.clean.moviescraper.TmdbScraper;
import se.softhouse.clean.moviescraper.TmdbScraperTest;

import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

/**
 * Times {@link se.softhouse.dirty.moviescraper.TmdbScraper} vs clean
 * {@link TmdbScraper}, i.e javax vs dom4j
 */
public class TmdbScraperBenchmark extends SimpleBenchmark
{
	public void timeDom4j(int reps) throws ScrapeException, IOException
	{
		for (int i = 0; i < reps; i++)
		{
			new TmdbScraperTest().testScrapingTitleAndDescriptionAndRating();
		}
	}

	public void timeJavax(int reps) throws IOException,
			ParserConfigurationException, SAXException
	{
		for (int i = 0; i < reps; i++)
		{
			new se.softhouse.dirty.moviescraper.TmdbScraperTest()
					.testScrapingTitleAndDescriptionAndRating();
		}
	}

	public static void main(String[] args) throws Exception
	{
		Runner.main(TmdbScraperBenchmark.class, args);
	}
}
