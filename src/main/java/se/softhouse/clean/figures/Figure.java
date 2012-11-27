package se.softhouse.clean.figures;

public abstract class Figure
{
	public abstract double area();

	public static class Rectangle extends Figure
	{
		double	length;
		double	width;

		public Rectangle(double length, double width)
		{
			this.length = length;
			this.width = width;
		}

		@Override
		public double area()
		{
			return length * width;
		}
	}

	public static class Square extends Rectangle
	{
		public Square(double size)
		{
			super(size, size);
		}
	}

	public static class Circle extends Figure
	{
		double	radius;

		public Circle(double radius)
		{
			this.radius = radius;
		}

		@Override
		public double area()
		{
			return Math.PI * (radius * radius);
		}

	}
}
