package se.softhouse.clean.moviescraper;

import java.io.Serializable;

public class ScrapeException extends RuntimeException
{
	/**
	 * @see Serializable
	 */
	private static final long	serialVersionUID	= 1L;

	public ScrapeException(String message)
	{
		super(message);
	}

	public ScrapeException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
