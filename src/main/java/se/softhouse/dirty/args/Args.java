package se.softhouse.dirty.args;

import java.util.Date;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * A typical container for parsed arguments from a command line parser
 */
public class Args
{
	/**
	 * Argument is the argument name as given from the command line, value is the
	 * parameter for each argument, for instance:
	 * 
	 * "java HelloWorldApp -n 42"
	 * 
	 * the argument name would be "-n" and the parameter 42 (stored as a real
	 * integer)
	 */
	private final Map<String, Object>	args	= Maps.newHashMap();

	public void put(String key, Object value)
	{
		args.put(key, value);
	}

	public String getString(String key)
	{
		return (String) args.get(key);
	}

	public boolean getBoolean(String key)
	{
		return (Boolean) args.get(key);
	}

	public int getInt(String key)
	{
		return (Integer) args.get(key);
	}

	public Date getDate(String key)
	{
		return (Date) args.get(key);
	}
}
