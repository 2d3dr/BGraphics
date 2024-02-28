package libraries.BGraphics.Processor;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import libraries.BGraphics.Premades.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class CanvasManager {
    private Canvas canvas;
    private GraphicsContext gc;
    private List<Drawable> drawables = new ArrayList<>();

    public CanvasManager(Canvas canvas) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
    }

    public void addDrawable(Drawable drawable) {
        drawables.add(drawable);
        drawable.draw(gc);
    }

    public void redrawAll() {
        gc.clearRect(0,   0, canvas.getWidth(), canvas.getHeight());
        for (Drawable drawable : drawables) {
            drawable.draw(gc);
        }
    }

    public void setupWindowSizeChangeListener(Stage stage) {
        stage.widthProperty().addListener((observable, oldValue, newValue) -> {
            redrawAll();
        });
        stage.heightProperty().addListener((observable, oldValue, newValue) -> {
            redrawAll();
        });
    }

    public interface Drawable {
        void draw(GraphicsContext gc);
    }
}