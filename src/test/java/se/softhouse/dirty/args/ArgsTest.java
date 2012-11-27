package se.softhouse.dirty.args;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;

public class ArgsTest
{
	@Test
	public void testArgs()
	{
		Date now = new Date();

		Args args = new Args();

		args.put("--ignore_whitespace", true);
		args.put("--commit-date", now);
		args.put("--message", "Hello World");
		args.put("--answer-to-everything", 42);

		// TODO(lesson3): Can the compiler remind us if "--answer-to-everything"
		// changes type? As it's now you would get a runtime exception on this
		// line because it's not a boolean if you would change it's type
		assertThat(args.getBoolean("--ignore_whitespace")).isTrue();
		assertThat(args.getDate("--commit-date")).isEqualTo(now);
		assertThat(args.getString("--message")).isEqualTo("Hello World");
		assertThat(args.getInt("--answer-to-everything")).isEqualTo(42);
	}
}
