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

}
