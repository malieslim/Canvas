public class Square extends Rectangle {
    public Square(int length) {
        super(length, length);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Square square = (Square) object;
        return this.getWidth() == square.getWidth();
    }

}
