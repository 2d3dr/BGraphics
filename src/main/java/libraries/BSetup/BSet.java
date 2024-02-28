package libraries.BSetup;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class BSet {
    private static Scene scene; // Global Scene variable

    public static void createWindow(int height, int width) throws IOException {
        createWindow(height, width, false, false);
    }

    public static void createWindow(int height, int width, boolean fullscreen) throws IOException {
        createWindow(height, width, false, true);
    }

    public static void createWindow(int height, int width, boolean fitsScreen, boolean fullscreen) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BSet.class.getResource("/com/example/bgraphics/hello-view.fxml"));
        VBox root = fxmlLoader.load();

        if (height >  0 && width >  0) {
            scene = new Scene(root, width, height);
        } else {
            scene = new Scene(root,  300,  300);
        }

        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        if (fitsScreen) {
            stage.setMaximized(true);
        }

        if (fullscreen) {
            stage.setFullScreen(true);
        }
    }


    public static Canvas createCanvas(int height, int width, boolean fitStage, boolean autoSize, Color color) {
        Canvas canvas = new Canvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        canvas.getGraphicsContext2D().setFill(color);

        double canvasWidth = width >  0 ? width : scene.getWidth();
        double canvasHeight = height >  0 ? height : scene.getHeight();
        canvas.setWidth(canvasWidth);
        canvas.setHeight(canvasHeight);

        gc.fillRect(0,  0, canvasWidth, canvasHeight);

        if (fitStage) {
            fitCanvasToStage(canvas);
        }

        if (autoSize) {
            autoResizeCanvas(canvas, color);
        }

        ((VBox) scene.getRoot()).getChildren().add(canvas);

        return canvas;
    }



    private static void fitCanvasToStage(Canvas canvas) {
        canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());
    }

    private static void autoResizeCanvas(Canvas canvas, Color color) {
        scene.widthProperty().addListener((observable, oldValue, newValue) -> {
            double newWidth = (double) newValue;
            canvas.setWidth(newWidth);
            redrawCanvas(canvas, color);
        });

        scene.heightProperty().addListener((observable, oldValue, newValue) -> {
            double newHeight = (double) newValue;
            canvas.setHeight(newHeight);
            redrawCanvas(canvas, color);
        });
    }

    private static void redrawCanvas(Canvas canvas, Color color) {
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, 0, canvasWidth, canvasHeight);
    }


    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene newScene) {
        scene = newScene;
    }
}
