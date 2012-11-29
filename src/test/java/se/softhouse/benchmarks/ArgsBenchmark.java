package se.softhouse.benchmarks;

import se.softhouse.clean.args.Args;
import se.softhouse.clean.args.ArgsTest;

import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

/**
 * <pre>
 * Times {@link se.softhouse.dirty.args.Args} vs clean {@link Args}.
 * 
 * Runs can be found at
 * http://microbenchmarks.appspot.com/run/jonatan.jonsson@softhouse.se/se.softhouse.benchmarks.ArgsBenchmark
 */
public class ArgsBenchmark extends SimpleBenchmark
{
	public void timeCustomKey(int reps)
	{
		for (int i = 0; i < reps; i++)
		{
			new ArgsTest().testArgs();
		}
	}

	public void timeStringKey(int reps)
	{
		for (int i = 0; i < reps; i++)
		{
			new se.softhouse.dirty.args.ArgsTest().testArgs();
		}
	}

	public static void main(String[] args) throws Exception
	{
		Runner.main(ArgsBenchmark.class, args);
	}
}
