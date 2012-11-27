package se.softhouse.dirty.keyboardinput;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class KeyboardInputTest
{
	@Test
	public void testThatLeftAndUpCanBePressedAtTheSameTimeIndependentlyOfEachOther()
	{
		KeyboardInput input = new KeyboardInput();
		input.keyPressed(KeyboardInput.KEY_LEFT);
		input.keyPressed(KeyboardInput.KEY_RIGHT);

		// TODO(lesson4): Can we make this easier to debug? Set a breakpoint
		// here and examine input, can you see which keys that are pressed?
		assertThat(input.isPressed(KeyboardInput.KEY_LEFT)).isTrue();
		assertThat(input.isPressed(KeyboardInput.KEY_RIGHT)).isTrue();

		assertThat(input.isPressed(KeyboardInput.KEY_UP)).isFalse();

		input.keyReleased(KeyboardInput.KEY_RIGHT);

		assertThat(input.isPressed(KeyboardInput.KEY_RIGHT)).isFalse();
		assertThat(input.isPressed(KeyboardInput.KEY_LEFT)).isTrue();
	}
}
