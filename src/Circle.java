/**
 * Represents a circle shape defined by its radius.
 *
 * <p>This class extends the {@link Shape} abstract class, providing implementations
 * for geometric calculations and a text-based grid approximation to draw a circle.
 */
public class Circle extends Shape {
    private int radius;
    private static final double TOLERANCE = 0.3;

    /**
     * Constructs a new Circle with the specified radius.
     *
     * @param radius the radius of the circle
     */
    public Circle(int radius){
        this.radius = radius;
    }

    /**
     * Returns the radius of this circle.
     *
     * @return the radius as an integer
     */
    public int getRadius(){
        return this.radius;
    }

    @Override
    public double area() {
        return this.radius * this.radius * Math.PI;
    }

    @Override
    public double perimeter() {
        return 2 * this.radius * Math.PI;
    }

    @Override
    public int getWidth() {
        return 2 * this.radius + 1;
    }

    @Override
    public int getHeight() {
        return 2 * this.radius + 1;
    }

    /**
     * Returns a text-based graphical representation of the circle using a coordinate grid.
     *
     * @return a string multi-line representation approximating a circular shape
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = -this.radius; i <= this.radius; i++) {
            for (int j = -this.radius; j <= this.radius; j++) {
                // Calculate the distance from the current cell (i,j) to the center (0,0) using Pythagorean theorem
                double distance = Math.sqrt(i * i + j * j);
                //If the distance is less than or equal to the radius, draw a star
                if (distance <= this.radius + TOLERANCE) {
                    result += GRID_UNIT;
                } else {
                    result += "   ";
                }
            }
            result += "\n";
        }
        return result;
    }

    /**
     * Indicates whether some other object is a circle with the same radius.
     *
     * @param other the reference object with which to compare
     * @return true if the other object is a Circle with an equal radius; false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if(other == this){
            return true;
        }
        if (other == null || getClass() != other.getClass()){
            return false;
        }
        Circle otherCircle = (Circle) other;
        return this.radius == otherCircle.getRadius();
    }
}