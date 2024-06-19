package org.example.lld.pen;

public class Ink {
    Color color;

    public Ink(Color color, float density) {
        this.color = color;
        this.density = density;
    }

    public Color getColor() {
        return color;
    }

    public float getDensity() {
        return density;
    }

    float density;
}
