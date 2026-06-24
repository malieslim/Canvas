public class Canvas {
    private Shape[][] shapes;
    private int width;
    private int height;
    public Canvas(int width, int height){
        this.width=width;
        this.height=height;
        this.shapes=new Shape[height][width];
    }
    public void addShape(Shape shape, int row, int col){
        if(row >=0 && row <this.height && col >=0 && col<this.width){
            shapes[row][col] = shape;
        }

    }
    public void removeShape(int row, int col){
        if(row >=0 && row <this.height && col >=0 && col<this.width){
            shapes[row][col] = null;
        }
    }
    public double getTotalArea(){
        double totalArea=0;
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if(this.shapes[i][j]!=null){
                    totalArea+=this.shapes[i][j].getArea();
                }
            }
        }
        return totalArea;
    }
    public double getTotalPerimeter(){
        double totalPerimeter=0;
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if(this.shapes[i][j]!=null){
                    totalPerimeter+=this.shapes[i][j].getPerimeter();
                }
            }
        }
        return totalPerimeter;
    }

    @Override
    public boolean equals(Object object){
       if(object==this){
           return true;
       }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        Canvas other=(Canvas) object;
        if (this.height != other.height || this.width != other.width) {
            return false;
        }
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                Shape shape1 = this.shapes[i][j];
                Shape shape2 = other.shapes[i][j];

                if (shape1 == null && shape2 == null) {
                    continue;
                }

                if (shape1 == null || shape2 == null) {
                    return false;
                }

                if (!shape1.equals(shape2)) {
                    return false;
                }
            }
        }
        return true;

    }

}
