package se.softhouse.dirty.moviescraper;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Scrapes movie information from <a href="http://api.themoviedb.org/">TMDB</a>
 */
public class TmdbScraper
{
	public static Movie scrape(InputStream input)
			throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();

		Document doc = db.parse(input);

		Movie movie = new Movie();

		Element docEle = doc.getDocumentElement();

		// TODO(lesson6): What error message do we get if there is no "movies"
		// element? Can we get better error handling and perhaps even cleaner
		// code? Is there a better library than javax to parse xml?
		NodeList movieList = docEle.getElementsByTagName("movies");
		Element movieProperties = (Element) ((Element) movieList.item(0))
				.getElementsByTagName("movie").item(0);

		movie.title = movieProperties.getElementsByTagName("name").item(0)
				.getTextContent();

		Node ratingNode = movieProperties.getElementsByTagName("rating")
				.item(0);
		// Set a breakpoint here and see if you can figure out the format of
		// rating by looking in ratingNode, not that easy!
		movie.rating = Float.valueOf(ratingNode.getTextContent());

		movie.tagline = movieProperties.getElementsByTagName("tagline").item(0)
				.getTextContent();
		return movie;
	}
}
