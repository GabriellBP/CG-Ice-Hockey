package cg.ice.hockey.util;

import java.awt.Color;
import java.util.ArrayList;

public class Line {
    public Point p1, p2;
    public int thickness;
    public Color color;
    public ArrayList<Point> points = new ArrayList();

    public Line(Point p1, Point p2, int thickness, Color color) {
        this.p1 = p1;
        this.p2 = p2;
        this.thickness = thickness;
        this.color = color;
    }
    
    public void addPoint(int x, int y) {
        this.points.add(new Point(x, y));
    }
}
