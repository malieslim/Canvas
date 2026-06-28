public class Circle extends Shape {
    private int radius;

    public Circle(int radius){
        this.radius = radius;
    }

    public int getRadius(){
        return radius;
    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

    @Override
    public double perimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public int getWidth() {
        return 2 * radius + 1;
    }

    @Override
    public int getHeight() {
        return 2 * radius + 1;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = -this.radius; i <= this.radius; i++) {
            for (int j = -this.radius; j <= this.radius; j++) {
                double distance = Math.sqrt(i * i + j * j);
                if (distance <= this.radius + 0.3) {
                    result += " * ";
                } else {
                    result += "   ";
                }
            }
            if(i < this.radius){
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
        Circle circle = (Circle) object;
        return this.radius == circle.getRadius();
    }
}