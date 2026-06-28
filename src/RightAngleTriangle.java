public class RightAngleTriangle extends Shape {
    private int base;
    private int height;

    public RightAngleTriangle(int base, int height){
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return (double) (base * height) / 2;
    }

    @Override
    public double perimeter() {
        double third = Math.sqrt(base * base + height * height);
        return base + height + third;
    }

    @Override
    public int getWidth() {
        return this.base;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 1; i <= this.height; i++) {
            int starsCount = Math.max(1, ((int) ((double) i * base / height)));
            String row = " * ".repeat(starsCount);
            String padding = "   ".repeat(this.base - starsCount);
            result += row + padding;

            if (i < this.height) {
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
        RightAngleTriangle triangle = (RightAngleTriangle) object;
        return this.base == triangle.getWidth() && this.height == triangle.getHeight();
    }
}