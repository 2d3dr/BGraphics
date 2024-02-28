package libraries.BGraphics.Premades;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import libraries.BGraphics.Processor.BProcessor;
import libraries.BGraphics.Processor.CanvasManager;

public class Rectangle implements CanvasManager.Drawable {
    private double x, y, width, height;
    private Color color;

    public Rectangle(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, width, height);
    }
}
