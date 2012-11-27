package se.softhouse.dirty.keyboardinput;

public class KeyboardInput
{
	/* Each key is represented by a single bit */
	static int	KEY_UP			= (1 << 0); // 000001
	static int	KEY_RIGHT		= (1 << 1); // 000010
	static int	KEY_DOWN		= (1 << 2); // 000100
	static int	KEY_LEFT		= (1 << 3); // 001000
	static int	KEY_BUTTON1		= (1 << 4); // 010000
	static int	KEY_BUTTON2		= (1 << 5); // 100000

	int			pressedButtons	= 0;

	/**
	 * Sets the pressedButtons using OR
	 */
	void keyPressed(int key)
	{
		pressedButtons |= key;
	}

	/**
	 * Turns the key in pressedButtons off using AND and ~
	 */
	void keyReleased(int key)
	{
		pressedButtons &= ~key;
	}

	/**
	 * Tests whether a bit is set using AND
	 */
	boolean isPressed(int key)
	{
		return (pressedButtons & key) == key;
	}
}
