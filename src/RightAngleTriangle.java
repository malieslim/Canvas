/**
 * Represents a right-angled triangle shape defined by its base and height.
 *
 * <p>This class extends the {@link Shape} abstract class, providing implementations
 * for calculating triangular geometric properties and rendering its textual approximation.
 */
public class RightAngleTriangle extends Shape {
    private int base;
    private int height;

    /**
     * Constructs a new RightAngleTriangle with the specified base and height.
     *
     * @param base   the base length of the triangle
     * @param height the height length of the triangle
     */
    public RightAngleTriangle(int base, int height){
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return (double) (this.base * this.height) / 2;
    }

    @Override
    public double perimeter() {
        double third = Math.sqrt(this.base * this.base + this.height * this.height);
        return this.base + this.height + third;
    }

    @Override
    public int getWidth() {
        return this.base;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    /**
     * Returns a text-based graphical representation of the right-angled triangle.
     *
     * @return a string row-by-row representation forming a triangle shape
     */
    @Override
    public String toString() {
        String result = "";

        for (int i = 1; i <= this.height; i++) {
            // Calculate the number of stars for the current row.
            // Math.max ensures we always print at least one star.
            int starsCount = Math.max(1, ((int) ((double) i * base / height)));
            String row = GRID_UNIT.repeat(starsCount);
            // Add spaces to fill the rest of the triangle's width, keeping the grid aligned
            String padding = "   ".repeat(this.base - starsCount);
            result += row + padding+ "\n";
        }
        return result;
    }

    /**
     * Indicates whether some other object is a right-angled triangle with the same dimensions.
     *
     * @param other the reference object with which to compare
     * @return true if the other object is a RightAngleTriangle with equal base and height;
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
        RightAngleTriangle otherTriangle = (RightAngleTriangle) other;
        return this.base == otherTriangle.getWidth() && this.height == otherTriangle.getHeight();
    }
}