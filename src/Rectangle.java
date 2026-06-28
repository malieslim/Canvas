public class Rectangle extends Shape {
    private int width;
    private int height;

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

    @Override
    public String toString() {
        String row = " * ".repeat(this.width);
        String result = "";

        for (int i = 0; i < this.height; i++) {
            result += row;

            if (i < this.height - 1) {
                result += "\n";
            }
        }

        return result;
    }

    @Override
    public boolean equals(Object object) {
        if(object == this){
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        Rectangle rectangle = (Rectangle) object;
        return this.width == rectangle.getWidth() && this.height == rectangle.getHeight();
    }
}