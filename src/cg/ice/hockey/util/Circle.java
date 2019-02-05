package cg.ice.hockey.util;

import java.util.ArrayList;

public class Circle {
    public Point center;
    public int radius;
    public ArrayList<Point> points = new ArrayList();

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }
    
    public void addPoint(int x, int y) {
        this.points.add(new Point(x, y));
    }
}
