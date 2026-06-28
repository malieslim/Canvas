public class Canvas {
    private Shape[][] shapes;
    private int width;
    private int height;

    public Canvas(int height, int width) {
        this.height = height;
        this.width = width;
        this.shapes = new Shape[height][width];
    }

    public void addShape(Shape shape, int row, int col) {
        if (row >= 0 && row < this.height && col >= 0 && col < this.width) {
            shapes[row][col] = shape;
        }
    }

    public void removeShape(int row, int col) {
        if (row >= 0 && row < this.height && col >= 0 && col < this.width) {
            shapes[row][col] = null;
        }
    }

    public double getTotalArea() {
        double totalArea = 0;
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (this.shapes[i][j] != null) {
                    totalArea += this.shapes[i][j].area();
                }
            }
        }
        return totalArea;
    }

    public double getTotalPerimeter() {
        double totalPerimeter = 0;
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (this.shapes[i][j] != null) {
                    totalPerimeter += this.shapes[i][j].perimeter();
                }
            }
        }
        return totalPerimeter;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Canvas other = (Canvas) object;
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


    @Override
    public String toString() {
        String result = "";
        final String SHAPE_SEPARATOR = "   ";

        int maxCanvasWidth = getMaxCanvasWidth();

        String emptyCellSpace = buildEmptySpace(maxCanvasWidth);

        for (int i = 0; i < this.shapes.length; i++) {

            int maxRowHeight = getMaxRowHeight(i);

            if (maxRowHeight == 0) {
                result += "\n";
                continue;
            }

            String[][] rowShapesLines = new String[this.width][];
            for (int j = 0; j < this.width; j++) {
                if (this.shapes[i][j] != null) {
                    rowShapesLines[j] = this.shapes[i][j].toString().split("\n");
                }
            }

            for (int lineIdx = 0; lineIdx < maxRowHeight; lineIdx++) {
                for (int j = 0; j < this.width; j++) {
                    if (this.shapes[i][j] == null) {
                        result += emptyCellSpace;
                    } else if (lineIdx < rowShapesLines[j].length) {
                        result += rowShapesLines[j][lineIdx];
                    } else {
                        result += buildEmptySpace(this.shapes[i][j].getWidth());
                    }

                    if (j < this.width - 1) {
                        result += SHAPE_SEPARATOR;
                    }
                }
                result += "\n";
            }
            result += "\n";
        }

        return result;
    }


    private String buildEmptySpace(int width) {
        final int CHARS_PER_UNIT = 3;
        return " ".repeat(width * CHARS_PER_UNIT);
    }

    private int getMaxCanvasWidth() {
        int maxCanvasWidth = 0;
        for (int i = 0; i < this.shapes.length; i++) {
            for (int j = 0; j < this.width; j++) {
                if (this.shapes[i][j] != null) {
                    maxCanvasWidth = Math.max(maxCanvasWidth, this.shapes[i][j].getWidth());
                }
            }
        }
        return maxCanvasWidth;
    }

    private int getMaxRowHeight(int rowIndex) {
        int maxRowHeight = 0;
        for (int j = 0; j < this.width; j++) {
            if (this.shapes[rowIndex][j] != null) {
                maxRowHeight = Math.max(maxRowHeight, this.shapes[rowIndex][j].getHeight());
            }
        }
        return maxRowHeight;
    }
}