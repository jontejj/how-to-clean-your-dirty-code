package se.softhouse.dirty.figures;

public class Circle implements Figure {

	// This field is used only if shape is circle
	double		radius;


	Circle(double radius) {
		this.radius = radius;
	}

	public double area() {
		return Math.PI * (radius * radius);
	}

}
