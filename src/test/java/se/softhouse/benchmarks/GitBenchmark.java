package se.softhouse.benchmarks;

import se.softhouse.clean.git.Git;
import se.softhouse.clean.git.GitTest;

import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

/**
 * Times {@link se.softhouse.dirty.git.Git} vs {@link Git}. That is, one if/else
 * based and one Enum Strategy based.
 */
public class GitBenchmark extends SimpleBenchmark
{
	public void timeIfElse(int reps)
	{
		for (int i = 0; i < reps; i++)
		{
			new se.softhouse.dirty.git.GitTest().testGitCommands();
		}
	}

	public void timeEnumLookup(int reps)
	{
		for (int i = 0; i < reps; i++)
		{
			new GitTest().testGitCommands();
		}
	}

	public static void main(String[] args) throws Exception
	{
		Runner.main(GitBenchmark.class, args);
	}
}
