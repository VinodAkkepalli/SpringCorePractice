package com.practice.spring;

import com.practice.spring.shapes.Point;

import java.util.List;

/**
 * <b>Description</b> :
 *
 * @author Vinod Akkepalli
 */
public class Triangle {

    private List<Point> points;

    public Triangle(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + points +
                '}';
    }
}
