package cg.ice.hockey.strategies.circle;

import cg.ice.hockey.util.Point;
import cg.ice.hockey.util.Circle;

public class BresenhamCircleStrategy implements CircleStrategy {

    @Override
    public Circle generateCircle(Point center, int radius) {
        Circle fullCircle = new Circle(center, radius);
        
        fullCircle.points.addAll(generateQuadrant(center, radius, 1).points);
        fullCircle.points.addAll(generateQuadrant(center, radius, 2).points);
        fullCircle.points.addAll(generateQuadrant(center, radius, 3).points);
        fullCircle.points.addAll(generateQuadrant(center, radius, 4).points);
        
        return fullCircle;
    }

    @Override
    public Circle generateQuadrant(Point center, int radius, int code) {
        Circle quadrant = new Circle(center, radius);
        
        int x = 0;
        int y = radius;
        float d = (5/4) - radius;

        do {
            if (code == 1) {
                quadrant.addPoint(center.x + x, center.y + y);
                quadrant.addPoint(center.x + y, center.y + x);
            } else if (code == 2) {
                quadrant.addPoint(center.x - x, center.y + y);
                quadrant.addPoint(center.x - y, center.y + x);
            } else if (code == 3) {
                quadrant.addPoint(center.x - x, center.y - y);
                quadrant.addPoint(center.x - y, center.y - x);
            } else {
                quadrant.addPoint(center.x + y, center.y - x);
                quadrant.addPoint(center.x + x, center.y - y);
            }
            
            if (d < 0) {
                /* escolhe E */
                d = d + 2 * x + 3;
                x++;
            } else {
                /* escolhe SE */
                d = d + 2 * (x - y) + 5;
                x++;
                y--;
            }
        } while(y >= x);
        
        return quadrant;
    }

    @Override
    public Circle generateQuadrant(Point center, int radius, int[] codes) {
        Circle circle = new Circle(center, radius);
        
        for (int i = 0; i < codes.length; i++) {
            circle.points.addAll(generateQuadrant(center, radius, codes[i]).points);
        }
        
        return circle;
    }
}
