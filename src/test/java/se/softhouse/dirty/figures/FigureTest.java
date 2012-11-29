package se.softhouse.dirty.figures;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class FigureTest
{
	@Test
	public void testWorkingWithSomeFigures()
	{
		// TODO(lesson2): Prefer hierarchies to tagged classes
		Figure circle = new Circle(2.0);
		assertThat(circle.area()).isEqualTo(Math.PI * 4);

		Figure square = new Rectangle(5, 5);
		assertThat(square.area()).isEqualTo(25);
	}
}
