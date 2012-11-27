package se.softhouse.clean.keyboardinput;

import static org.fest.assertions.Assertions.assertThat;

import java.util.EnumSet;
import java.util.Set;

import org.junit.Test;

import se.softhouse.clean.keyboardinput.KeyboardInput.Key;

public class KeyboardInputTest
{
	@Test
	public void testThatLeftAndUpCanBePressedAtTheSameTimeIndependentlyOfEachOther()
	{
		KeyboardInput input = new KeyboardInput();
		input.keyPressed(Key.LEFT);
		input.keyPressed(Key.RIGHT);

		assertThat(input.isPressed(Key.LEFT)).isTrue();
		assertThat(input.isPressed(Key.RIGHT)).isTrue();

		assertThat(input.isPressed(Key.UP)).isFalse();

		input.keyReleased(Key.RIGHT);

		assertThat(input.isPressed(Key.RIGHT)).isFalse();
		assertThat(input.isPressed(Key.LEFT)).isTrue();
	}

	@Test
	public void testWithSimpleEnumSet()
	{
		Set<Key> pressedKeys = EnumSet.noneOf(Key.class);
		pressedKeys.add(Key.LEFT);
		pressedKeys.add(Key.RIGHT);

		// Set a breakpoint here and examine pressedKeys, can you see which keys
		// that are pressed?
		assertThat(pressedKeys).containsOnly(Key.LEFT, Key.RIGHT);

		pressedKeys.remove(Key.RIGHT);

		assertThat(pressedKeys).containsOnly(Key.LEFT);
	}
}
