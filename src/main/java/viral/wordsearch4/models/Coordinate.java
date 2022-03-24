package viral.wordsearch4.models;

import java.util.Objects;

public class Coordinate {
	

	public int x;
	public int y;
	
	public Coordinate(int w, int h) {
		this.x = w;
		this.y = h;
	}

	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		return x == other.x && y == other.y;
	}
	
	
	
}
