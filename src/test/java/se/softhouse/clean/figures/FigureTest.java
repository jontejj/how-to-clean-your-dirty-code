package se.softhouse.clean.figures;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import se.softhouse.clean.figures.Figure.Circle;
import se.softhouse.clean.figures.Figure.Rectangle;

public class FigureTest
{
	@Test
	public void testWorkingWithSomeFigures()
	{
		Circle circle = new Circle(2.0);
		assertThat(circle.area()).isEqualTo(Math.PI * 4);

		Rectangle rectangle = new Rectangle(2, 4);
		assertThat(rectangle.area()).isEqualTo(8);
	}
}
