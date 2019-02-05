package cg.ice.hockey.strategies.circle;

import cg.ice.hockey.util.Circle;
import cg.ice.hockey.util.Point;
import static java.lang.Math.sqrt;

public class CircumferenceEquationStrategy implements CircleStrategy {

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
        
        int x, y = 1;
        for (x = 0; x < y; x++) {
            y = (int) sqrt(radius * radius - x * x);
            quadrant.points.add(new Point(center.x + x * (code == 1 || code == 4 ? 1 : -1), center.y + y * (code == 1 || code == 2 ? 1 : -1)));
        }
        
        x = radius;
        for (y = 0; y < x; y++) {
            x = (int) sqrt(radius * radius - y * y);
            quadrant.points.add(new Point(center.x + x * (code == 1 || code == 4 ? 1 : -1), center.y + y * (code == 1 || code == 2 ? 1 : -1)));
        }
        
        return quadrant;
    }

    @Override
    public Circle generateCircle(Point center, int radius, int[] codes) {
        Circle circle = new Circle(center, radius);
        
        for (int i = 0; i < codes.length; i++) {
            circle.points.addAll(generateQuadrant(center, radius, codes[i]).points);
        }
        
        return circle;
    }
    
}
