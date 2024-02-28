package libraries.BGraphics.Premades;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.paint.Color;

public class Vector {
    private DoubleProperty x;
    private DoubleProperty y;
    private DoubleProperty radius;
    private Color color;

    public Vector(double x, double y, double radius, Color color) {
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.radius = new SimpleDoubleProperty(radius);
        this.color = color;
    }
    public Vector(double x, double y, Color color) {
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.color = color;
    }

    public double getX() {
        return x.get();
    }

    public void setX(double x) {
        this.x.set(x);
    }

    public double getY() {
        return y.get();
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public double getRadius() {
        return radius.get();
    }

    public void setRadius(double radius) {
        this.radius.set(radius);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public void addXListener(ChangeListener<Number> listener) {
        x.addListener(listener);
    }

    public void addYListener(ChangeListener<Number> listener) {
        y.addListener(listener);
    }

    public void addRadiusListener(ChangeListener<Number> listener) {
        radius.addListener(listener);
    }
}
