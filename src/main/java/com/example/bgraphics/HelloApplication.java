package com.example.bgraphics;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import libraries.BGraphics.Premades.Vector;
import libraries.BGraphics.Processor.BProcessor;
import libraries.BGraphics.Processor.CanvasManager;
import libraries.BGraphics.Premades.Rectangle;
import libraries.BSetup.BSet;

import java.io.IOException;

import static libraries.BSetup.BSet.createCanvas;
import static libraries.BSetup.BSet.createWindow;


public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
       createWindow(500,500,true,true);

       BProcessor processor = new BProcessor();

       Canvas myCanvas = createCanvas(0,0,true,true,Color.WHITE);
       Vector myVector = new Vector(200,200,10,Color.BLACK);

       BProcessor.connect(myCanvas,myVector);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
