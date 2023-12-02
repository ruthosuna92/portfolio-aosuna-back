package com.example.portfolioaosunaback.externalApi.graphs;

import org.springframework.stereotype.Component;

@Component
public class Point {
    private int x;
    private double y;


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
