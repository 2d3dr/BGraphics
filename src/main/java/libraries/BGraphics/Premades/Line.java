package libraries.BGraphics.Premades;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line {
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private Color color;

    public Line(double startX, double startY, double endX, double endY, Color color) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.color = color;
    }

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public double getEndX() {
        return endX;
    }

    public double getEndY() {
        return endY;
    }

    public Color getColor() {
        return color;
    }

    public void draw(GraphicsContext gc) {
        gc.setStroke(color);
        gc.setLineWidth(2);
        gc.strokeLine(startX, startY, endX, endY);
    }

    public void updatePosition(double startX, double startY, double endX, double endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
}
