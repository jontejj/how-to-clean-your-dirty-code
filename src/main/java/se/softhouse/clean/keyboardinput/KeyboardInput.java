package se.softhouse.clean.keyboardinput;

import java.util.EnumSet;
import java.util.Set;

public class KeyboardInput
{
	public enum Key
	{
		UP, RIGHT, DOWN, LEFT, BUTTON1, BUTTON2;
	}

	private final Set<Key>	pressedKeys	= EnumSet.noneOf(Key.class);

	void keyPressed(Key key)
	{
		pressedKeys.add(key);
	}

	void keyReleased(Key key)
	{
		pressedKeys.remove(key);
	}

	boolean isPressed(Key key)
	{
		return pressedKeys.contains(key);
	}
}
