/**
 * Represents a generic geometric shape in a two-dimensional space.
 *
 * <p>This abstract class serves as a base for specific shape implementations,
 * defining mandatory operations for calculating spatial properties and comparisons.
 */
public abstract class Shape {
    protected static final String GRID_UNIT = " * ";

    /**
     * Returns the area of the shape.
     *
     * @return the calculated area as a double
     */
    public abstract double area();

    /**
     * Returns the perimeter of the shape.
     *
     * @return the calculated perimeter as a double
     */
    public abstract double perimeter();

    /**
     * Returns the width of the bounding box of the shape.
     *
     * @return the width as an integer
     */
    public abstract int getWidth();

    /**
     * Returns the height of the bounding box of the shape.
     *
     * @return the height as an integer
     */
    public abstract int getHeight();

    /**
     * Returns a string representation of the shape.
     *
     * @return a string describing the shape attributes
     */
    @Override
    public abstract String toString();

    /**
     * Indicates whether some other object is "equal to" this shape.
     *
     * @param other the reference object with which to compare
     * @return true if this shape is the same as the other object; false otherwise
     */
    @Override
    public abstract boolean equals(Object other);
}
