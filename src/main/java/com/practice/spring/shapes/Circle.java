package com.practice.spring.shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * <b>Description</b> : Circle class to demonstrate @Autowired annotation,
 * MessageSource usage
 *
 * @author Vinod Akkepalli
 */
@Component("circle")
public class Circle {

    //Autowiring by name
    @Autowired
    private Point center;
    @Autowired
    private MessageSource messageSource;

    public Circle() {
        System.out.println(this.getClass().getSimpleName() + ":: no arg constructor injection");
    }

    public Circle(Point center) {
        System.out.println(this.getClass().getSimpleName() + ":: constructor injection");
        this.center = center;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        System.out.println(this.getClass().getSimpleName() + ":: setter injection");
        this.center = center;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void draw() {
        System.out.println(messageSource.getMessage("circle.msg", new Object[]{center.getX(), center.getY()} , Locale.getDefault()));
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                '}';
    }
}
