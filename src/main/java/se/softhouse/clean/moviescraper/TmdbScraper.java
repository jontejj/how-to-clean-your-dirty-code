package se.softhouse.clean.moviescraper;

import java.io.InputStream;

import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class TmdbScraper
{
	public static Movie scrape(InputStream input) throws ScrapeException
	{
		try
		{
			Node movieNode = new SAXReader().read(input).selectSingleNode(
					"//movies/movie");
			if (movieNode == null)
				throw new ScrapeException("movie element not reachable in xml");

			// Set a breakpoint here and see if you can figure out the format of
			// the rating from movieNode

			Movie movie = new Movie();
			movie.title = movieNode.selectSingleNode("name").getText();
			movie.rating = movieNode.numberValueOf("rating");
			movie.tagline = movieNode.selectSingleNode("tagline").getText();
			return movie;
		}
		catch (DocumentException e)
		{
			throw new ScrapeException("Failed to parse input into a movie", e);
		}
	}
}
