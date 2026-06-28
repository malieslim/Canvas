/**
 * Represents a rectangle shape defined by its width and height.
 *
 * <p>This class extends the {@link Shape} abstract class, providing implementations
 * for calculating geometric properties and generating a text-based visual representation.
 */
public class Rectangle extends Shape {
    private int width;
    private int height;

    /**
     * Constructs a new Rectangle with the specified width and height.
     *
     * @param width  the width of the rectangle
     * @param height the height of the rectangle
     */
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return this.width * this.height;
    }

    @Override
    public double perimeter() {
        return 2 * (this.width + this.height);
    }

    @Override
    public int getWidth() {
        return this.width ;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    /**
     * Returns a text-based graphical representation of the rectangle using asterisks.
     *
     * @return a string row-by-row representation of the rectangle
     */
    @Override
    public String toString() {
        String row = GRID_UNIT.repeat(this.width);
        String result = "";

        for (int i = 0; i < this.height; i++) {
            result += row + "\n";
        }

        return result;
    }

    /**
     * Indicates whether some other object is a rectangle with the same dimensions.
     *
     * @param other the reference object with which to compare
     * @return true if the other object is a Rectangle with equal width and height;
     * false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if(other == this){
            return true;
        }
        if (other == null || getClass() != other.getClass()){
            return false;
        }
        Rectangle otherRectangle = (Rectangle) other;
        return this.width == otherRectangle.getWidth() && this.height == otherRectangle.getHeight();
    }
}