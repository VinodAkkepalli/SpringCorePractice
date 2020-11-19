import com.practice.spring.shapes.Point;

import java.util.List;

/**
 * <b>Description</b> :
 *
 * @author Vinod Akkepalli
 */
public class Polygon {
    private List<Point> pointList;

    public Polygon(List<Point> pointList) {
        this.pointList = pointList;
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "pointList=" + pointList +
                "}, Number of Points: " + pointList.size();
    }
}
