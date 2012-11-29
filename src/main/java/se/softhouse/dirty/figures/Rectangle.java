package se.softhouse.dirty.figures;


public class Rectangle implements Figure {

	// These fields are used only if shape is RECTANGLE
	double		length;
	double		width;

	// Constructor for rectangle
	Rectangle(double length, double width)
	{
		this.length = length;
		this.width = width;
	}



	public double area() {
		return length * width;
	}

}
