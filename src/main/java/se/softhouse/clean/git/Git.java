package se.softhouse.clean.git;

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
		try
		{
			return GitCommands.valueOf(command).execute(parameters);
		}
		catch (IllegalArgumentException unknownCommand)
		{
			throw new UnsupportedOperationException(command
					+ " is not supported by git", unknownCommand);
		}
	}

	private interface GitCommand
	{
		String execute(String... parameters);
	}

	/**
	 * <pre>
	 * Pros with this code:
	 * 1. Name clashes, the compiler will discover them.
	 * 2. If you want to implement a new command all you need to do is add it to this enum. Nothing else.
	 * 3. The compiler will force you to implement the GitCommand when adding a new command (maintainability).
	 * 4. The more commands that are added the more you save on performance versus the if/else statement as the enum uses a Map internally.
	 * 
	 * Cons:
	 * 1. Not as concise as the if/else statement
	 */
	private enum GitCommands implements GitCommand
	{
		status {
			public String execute(String... pathSpecs)
			{
				return "Status for: " + Arrays.toString(pathSpecs);
			}
		},
		commit {
			public String execute(String... filePaths)
			{
				return "Committed: " + Arrays.toString(filePaths);
			}
		},
		log {
			public String execute(String... pathsToShowLogFor)
			{
				return "Log for:" + Arrays.toString(pathsToShowLogFor);
			}
		},
		diff {
			public String execute(String... versions)
			{
				return "Diff between: " + Arrays.toString(versions);
			}
		}
	}
}
