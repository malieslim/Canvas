/**
 * Represents a square shape, which is a specific type of rectangle with equal dimensions.
 *
 * <p>This class extends the {@link Rectangle} class, initializing both width and height
 * to the same side length value.
 */
public class Square extends Rectangle {

    /**
     * Constructs a new Square with the specified side length.
     *
     * @param length the side length of the square
     */
    public Square(int length) {
        super(length, length);
    }

    /**
     * Indicates whether some other object is a square with the same dimensions.
     *
     * @param other the reference object with which to compare
     * @return true if the other object is a Square with an equal side length; false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Square otherSquare = (Square) other;
        return this.getWidth() == otherSquare.getWidth();
    }

}
