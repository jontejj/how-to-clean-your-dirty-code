package se.softhouse.dirty.git;

import java.util.Arrays;

/**
 * Toy version of Git implemented in Java
 */
public class Git
{
	/**
	 * Executes {@code command} and returns the result of the command
	 * 
	 * @param parameters
	 *            the trailing parameters given after the command, differ per
	 *            command
	 */
	public String doCommand(String command, String... parameters)
	{
		if ("status".equals(command))
			return status(parameters);
		if ("commit".equals(command))
			return commit(parameters);
		else if ("log".equals(command))
			return log(parameters);
		else if ("diff".equals(command))
			return diff(parameters);

		// TODO(lesson5): These commands are starting to get out of hand, can we
		// do better?

		throw new UnsupportedOperationException(command
				+ " is not supported by git");
	}

	private String status(String... pathSpecs)
	{
		return "Status for: " + Arrays.toString(pathSpecs);
	}

	private String commit(String... filePaths)
	{
		return "Committed: " + Arrays.toString(filePaths);
	}

	private String log(String... pathsToShowLogFor)
	{
		return "Log for:" + Arrays.toString(pathsToShowLogFor);
	}

	private String diff(String... versions)
	{
		return "Diff between: " + Arrays.toString(versions);
	}
}
