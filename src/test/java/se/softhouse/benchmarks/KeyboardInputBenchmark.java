package se.softhouse.benchmarks;

import se.softhouse.clean.keyboardinput.KeyboardInput;
import se.softhouse.clean.keyboardinput.KeyboardInputTest;

import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

/**
 * Times {@link se.softhouse.dirty.keyboardinput.KeyboardInput} vs clean
 * {@link KeyboardInput}, i.e bitfields vs EnumSet
 */
public class KeyboardInputBenchmark extends SimpleBenchmark
{
	public void timeEnumSet(int reps)
	{
		for (int i = 0; i < reps; i++)
		{
			new KeyboardInputTest()
					.testThatLeftAndUpCanBePressedAtTheSameTimeIndependentlyOfEachOther();
		}
	}

	public void timeBitfield(int reps)
	{
		for (int i = 0; i < reps; i++)
		{
			new se.softhouse.dirty.keyboardinput.KeyboardInputTest()
					.testThatLeftAndUpCanBePressedAtTheSameTimeIndependentlyOfEachOther();
		}
	}

	public static void main(String[] args) throws Exception
	{
		Runner.main(KeyboardInputBenchmark.class, args);
	}
}
