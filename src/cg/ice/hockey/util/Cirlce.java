package cg.ice.hockey.util;

import java.util.ArrayList;

public class Cirlce {
    ArrayList<Point> points = new ArrayList();
    
    void addPoint(int x, int y) {
        this.points.add(new Point(x, y));
    }
}
