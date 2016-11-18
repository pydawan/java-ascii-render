package com.indvd00m.ascii.render.elements;

import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IElement;
import com.indvd00m.ascii.render.api.IPoint;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-18 6:15:35 PM
 *
 */
public class Ellipse implements IElement {

	int x;
	int y;
	int width;
	int height;

	public Ellipse(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public IPoint draw(ICanvas canvas, IContext context) {
		double a = width / 2d;
		double b = height / 2d;
		double c = Math.sqrt(Math.abs(Math.pow(a, 2) - Math.pow(b, 2)));
		double f1x = x - c;
		double f1y = y;
		double f2x = x + c;
		double f2y = y;
		for (int x1 = (int) (x - a); x1 <= x + a; x1++) {
			for (int y1 = (int) (y - b); y1 <= y + b; y1++) {
				double d1 = Math.sqrt(Math.pow(f1x - x1, 2) + Math.pow(f1y - y1, 2));
				double d2 = Math.sqrt(Math.pow(f2x - x1, 2) + Math.pow(f2y - y1, 2));
				if (compare(d1 + d2, 2 * a, 0.5d) == 0)
					canvas.draw(x1, y1, "*");
			}
		}
		return new Point(x, y);
	}

	int compare(double d1, double d2, double precision) {
		double diff = d1 - d2;
		if (Math.abs(diff) < precision)
			return 0;
		if (diff < 0d)
			return -1;
		else
			return 1;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ellipse other = (Ellipse) obj;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ellipse [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append(", width=");
		builder.append(width);
		builder.append(", height=");
		builder.append(height);
		builder.append("]");
		return builder.toString();
	}

}
