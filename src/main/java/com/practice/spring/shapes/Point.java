package com.practice.spring.shapes;

import lombok.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * <b>Description</b> : Point class representing a point on a plane
 *
 * @author Vinod Akkepalli
 */
@ToString
@Component("point")
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class Point {
    private float x;
    private float y;

    public Point() {
        System.out.println(this.getClass().getSimpleName() + ":: no arg constructor  injection");
    }

    public Point(float x, float y) {
        System.out.println(this.getClass().getSimpleName() + ":: arguments constructor injection");
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
