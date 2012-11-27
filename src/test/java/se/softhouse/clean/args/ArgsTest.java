package se.softhouse.clean.args;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;

import se.softhouse.clean.args.Args.Argument;

public class ArgsTest
{
	private static final Argument<Boolean>	ignoreWhitespace	= Args.newArgument("--ignore_whitespace");
	private static final Argument<Date>		commitDate			= Args.newArgument("--commit-date");
	private static final Argument<String>	commitMessage		= Args.newArgument("--message");
	private static final Argument<Integer>	answerToEverything	= Args.newArgument("--answer-to-everything");

	@Test
	public void testArgs()
	{
		Date now = new Date();

		Args args = new Args();
		args.put(ignoreWhitespace, true);
		args.put(commitDate, now);
		args.put(commitMessage, "Hello World");
		args.put(answerToEverything, 42);

		assertThat(args.get(ignoreWhitespace)).isTrue();
		assertThat(args.get(commitDate)).isEqualTo(now);
		assertThat(args.get(commitMessage)).isEqualTo("Hello World");
		assertThat(args.get(answerToEverything)).isEqualTo(42);
	}
}
