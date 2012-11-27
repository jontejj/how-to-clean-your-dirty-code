package se.softhouse.clean.args;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * A typical container for parsed arguments from a command line parser
 */
public class Args
{
	/**
	 * Heterogeneous key for storage in Args
	 * 
	 * @param <T>
	 *            the type of data this key is bound with
	 */
	public static final class Argument<T>
	{
		// The parser would use this name in a real argument parser
		@SuppressWarnings("unused")
		private final String	argumentName;

		private Argument(String argName)
		{
			argumentName = argName;
		};
	}

	public static <T> Argument<T> newArgument(String argumentName)
	{
		return new Argument<T>(argumentName);
	}

	/**
	 * Argument is the argument name as given from the command line, value is the
	 * parameter for each argument, for instance:
	 * 
	 * "java HelloWorldApp -n 42"
	 * 
	 * the argument name would be "-n" and the parameter 42 (stored as a real
	 * integer)
	 */
	private final Map<Argument<?>, Object>	args	= Maps.newHashMap();

	public <T> void put(Argument<T> key, T value)
	{
		args.put(key, value);
	}

	public <T> T get(Argument<T> key)
	{
		// Cast is safe as the put method guarantees a value of T
		@SuppressWarnings("unchecked")
		T arg = (T) args.get(key);
		return arg;
	}
}
