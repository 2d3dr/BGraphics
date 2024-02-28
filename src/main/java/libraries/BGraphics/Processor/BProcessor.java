package libraries.BGraphics.Processor;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import libraries.BGraphics.Premades.Line;
import libraries.BGraphics.Premades.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BProcessor {

    private static Map<Canvas, List<Vector>> canvasToVectorsMap = new HashMap<>();
    private static Map<Canvas, List<Line>> canvasToLinesMap = new HashMap<>();

    public static void connect(Canvas canvas, Vector vector) {
        canvasToVectorsMap.computeIfAbsent(canvas, k -> new ArrayList<>()).add(vector);
        redraw(canvas);
    }

    public static void connectVector(Canvas canvas, Vector base, Vector child, Boolean updatePos) {
        Line line = new Line(base.getX(), base.getY(), child.getX(), child.getY(), base.getColor());
        canvasToLinesMap.computeIfAbsent(canvas, k -> new ArrayList<>()).add(line);
        redraw(canvas);
    }

    public static void setupWindowSizeChangeListener(Canvas canvas, Stage stage) {
        ChangeListener<Number> windowSizeListener = (observable, oldValue, newValue) -> {
            // Adjust the canvas size to match the window size
            canvas.setWidth(stage.getWidth());
            canvas.setHeight(stage.getHeight());

            // Redraw the canvas content
            redraw(canvas);
        };

        stage.widthProperty().addListener(windowSizeListener);
        stage.heightProperty().addListener(windowSizeListener);
    }

    private static void redraw(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0,   0, canvas.getWidth(), canvas.getHeight());

        // Draw all vectors
        List<Vector> vectors = canvasToVectorsMap.get(canvas);
        if (vectors != null) {
            for (Vector vector : vectors) {
                drawVector(gc, vector);
            }
        }

        // Draw all lines
        List<Line> lines = canvasToLinesMap.get(canvas);
        if (lines != null) {
            for (Line line : lines) {
                drawLine(gc, line);
            }
        }
    }

    private static void drawVector(GraphicsContext gc, Vector vector) {
        gc.setFill(vector.getColor());
        gc.fillOval(vector.getX(), vector.getY(), vector.getRadius(), vector.getRadius());
    }

    private static void drawLine(GraphicsContext gc, Line line) {
        gc.setStroke(line.getColor());
        gc.setLineWidth(2);
        gc.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
    }

    public static void drawRectangle(Canvas canvas, double x, double y, double width, double height, Color color) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(x, y, width, height);
    }
}
