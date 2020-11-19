package com.practice.spring.shapes;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * <b>Description</b> : Class to demonstrate @Component @PostCreate @PreDestroy annotations
 * Data annotation of Project Lombok is used to avoid boilerplate code
 * @author Vinod Akkepalli
 */
@Data
@Component("lineSegment")
public class LineSegment {

    @Autowired
    private Point start;
    @Autowired
    private Point end;

    @PostConstruct
    public void intMethod() {
        System.out.println("PostConstruct of LineSegment");
    }

    //Shutdown hook needs to be defined for this predestroy method to execute
    @PreDestroy
    public void cleanupMethod() {
        System.out.println("PreDestroy of LineSegment");
    }
}
