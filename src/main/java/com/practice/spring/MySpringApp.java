package com.practice.spring;

import com.practice.spring.shapes.Circle;
import com.practice.spring.shapes.LineSegment;
import com.practice.spring.shapes.Point;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * <b>Description</b> :
 *
 * @author Vinod Akkepalli
 */
public class MySpringApp {
    public static void main(String[] args) {

//        annotationBasedConfiguration();
        annotationAndXMLBasedConfiguration();
    }

    private static void annotationBasedConfiguration() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Point point = (Point) applicationContext.getBean("point");
        point.setX(1);
        point.setY(2);
        System.out.println(point.toString());

        Circle circle = (Circle) applicationContext.getBean("circle");
        circle.setCenter(point);
        System.out.println(circle.toString());

        Point start = (Point) applicationContext.getBean("point");
        start.setX(0);
        start.setY(0);
        Point end = (Point) applicationContext.getBean("point");
        end.setX(1);
        end.setY(1);

        LineSegment lineSegment = (LineSegment) applicationContext.getBean("lineSegment");
        lineSegment.setStart(start);
        lineSegment.setEnd(end);
        System.out.println(lineSegment.toString());

        System.out.println("Retrieved message is: " + applicationContext.getMessage("circle.msg", new Object[]{12, 23}, Locale.getDefault()));
    }

    //uses spring.xml file for xml configuration
    private static void annotationAndXMLBasedConfiguration() {
        try (AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml")) {
			applicationContext.registerShutdownHook();

			Point point = (Point) applicationContext.getBean("zeroPoint");
			System.out.println(point.toString());

			Circle circle = (Circle) applicationContext.getBean("circle");
			System.out.println(circle.toString());
			circle.draw();

			LineSegment lineSegment = (LineSegment) applicationContext.getBean("lineSegment");
			System.out.println(lineSegment.toString());

			Circle circle2 = new Circle(new Point(2, 3));
//			circle2.setCenter(point);
			System.out.println("circle2 = " + circle2.toString());
			
			circle2.aopDemoMethod();
			
			System.out.println("Retrieved message is: " + applicationContext.getMessage("message", null, Locale.getDefault()));
		}
    }
}
