/**
 * Represents a grid-based canvas that holds and manages multiple geometric shapes.
 *
 * <p>The canvas allows adding, removing, and rendering shapes in a two-dimensional grid,
 * as well as calculating aggregate properties like total area and total perimeter.
 */
public class Canvas {
    private Shape[][] shapes;
    private int width;
    private int height;

    /**
     * Constructs a new Canvas with the specified dimensions.
     *
     * @param height the number of rows in the canvas grid
     * @param width  the number of columns in the canvas grid
     */
    public Canvas(int height, int width) {
        this.height = height;
        this.width = width;
        this.shapes = new Shape[height][width];
    }

    /**
     * Adds a shape to the canvas at the specified grid coordinates if within bounds.
     *
     * @param shape the shape to be added
     * @param row   the row index where the shape should be placed
     * @param col   the column index where the shape should be placed
     */
    public void addShape(Shape shape, int row, int col) {
        if (row >= 0 && row < this.height && col >= 0 && col < this.width) {
            shapes[row][col] = shape;
        }
    }

    /**
     * Removes the shape from the specified grid coordinates if within bounds.
     *
     * @param row the row index of the shape to remove
     * @param col the column index of the shape to remove
     */
    public void removeShape(int row, int col) {
        if (row >= 0 && row < this.height && col >= 0 && col < this.width) {
            shapes[row][col] = null;
        }
    }

    /**
     * Calculates the total combined area of all shapes currently on the canvas.
     *
     * @return the total accumulated area as a double
     */
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

    /**
     * Calculates the total combined perimeter of all shapes currently on the canvas.
     *
     * @return the total accumulated perimeter as a double
     */
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

    /**
     * Indicates whether some other object is a Canvas with the same dimensions and shapes.
     *
     * @param other the reference object with which to compare
     * @return true if the other object is an identical Canvas; false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Canvas otherCanvas = (Canvas) other;
        if (this.height != otherCanvas.height || this.width != otherCanvas.width) {
            return false;
        }
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                Shape shape1 = this.shapes[i][j];
                Shape shape2 = otherCanvas.shapes[i][j];

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

    /**
     * Returns a multi-line string visually grid-rendering all shapes on the canvas.
     *
     * @return a row-by-row composite text representation of the canvas grid
     */

    @Override
    public String toString() {
        String result = "";
        final String SHAPE_SEPARATOR = "   ";

        int maxCanvasWidth = getMaxCanvasWidth();

        String emptyCellSpace = buildEmptySpace(maxCanvasWidth);

        for (int i = 0; i < this.shapes.length; i++) {

            int maxRowHeight = getMaxRowHeight(i);

            // If the row has no shapes, just print a new line and move to the next row
            if (maxRowHeight == 0) {
                result += "\n";
                continue;
            }
            // Split each shape's string into single lines so we can print them side-by-side later
            String[][] rowShapesLines = new String[this.width][];
            for (int j = 0; j < this.width; j++) {
                if (this.shapes[i][j] != null) {
                    rowShapesLines[j] = this.shapes[i][j].toString().split("\n");
                }
            }

            for (int lineIdx = 0; lineIdx < maxRowHeight; lineIdx++) {
                for (int j = 0; j < this.width; j++) {
                    if (this.shapes[i][j] == null) {
                        // The cell is empty. Print empty space matching the max canvas width.
                        result += emptyCellSpace;
                    } else if (lineIdx < rowShapesLines[j].length) {
                        // The current shape still has lines to print at this height.
                        result += rowShapesLines[j][lineIdx];
                    } else {
                        // The shape is finished (it is shorter than the max height).
                        // Fill the rest with empty spaces to keep the alignment correct.
                        result += buildEmptySpace(this.shapes[i][j].getWidth());
                    }
                    // Add a fixed space between shapes, but not after the last shape in the row
                    if (j < this.width - 1) {
                        result += SHAPE_SEPARATOR;
                    }
                }
                result += "\n";
            }
            // Add an extra empty line at the end of each canvas row, as requested in the instructions
            result += "\n";
        }

        return result;
    }

    /**
     * Builds an aligned sequence of empty character spaces.
     *
     * @param width the width in terms of shape units to be filled with spaces
     * @return a string containing the required amount of blank spaces to maintain alignment
     */
    private String buildEmptySpace(int width) {
        final int CHARS_PER_UNIT = 3;
        return " ".repeat(width * CHARS_PER_UNIT);
    }

    /**
     * Evaluates the maximum width among all placed shapes on the entire canvas.
     *
     * @return the maximum width found as an integer
     */
    private int getMaxCanvasWidth() {
        int maxCanvasWidth = 0;
        for (int i = 0; i < this.shapes.length; i++) {
            for (int j = 0; j < this.width; j++) {
                if (this.shapes[i][j] != null) {
                    if (this.shapes[i][j].getWidth() > maxCanvasWidth) {
                        maxCanvasWidth = this.shapes[i][j].getWidth();
                    }
                }
            }
        }
        return maxCanvasWidth;
    }

    /**
     * Evaluates the maximum height among shapes within a specific row grid.
     *
     * @param rowIndex the index of the row to check
     * @return the maximum height found in the specified row as an integer
     */
    private int getMaxRowHeight(int rowIndex) {
        int maxRowHeight = 0;
        for (int j = 0; j < this.width; j++) {
            if (this.shapes[rowIndex][j] != null) {
                if (this.shapes[rowIndex][j].getHeight() > maxRowHeight) {
                    maxRowHeight = this.shapes[rowIndex][j].getHeight();
                }
            }
        }
        return maxRowHeight;
    }
}