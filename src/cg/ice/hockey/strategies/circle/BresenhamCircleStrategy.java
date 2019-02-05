package cg.ice.hockey.strategies.circle;

import cg.ice.hockey.util.Point;
import cg.ice.hockey.util.Circle;

public class BresenhamCircleStrategy implements CircleStrategy{

    @Override
    public Circle generateCircle(Point center, int radius) {
        Circle circle = new Circle();
        
        int x = 0;
        int y = radius;
        float d = (5/4) - radius;
        
        circle.addPoint(x, y);
        while (y > x) {
            if (d < 0) {
                /* escolhe E */
                d = d + 2 * x + 3;
                x++;
            } else {
                /* escolhe NE */
                d = d + 2 * (x - y) + 5;
                x++;
                y--;
            }
            circle.addPoint(x, y);
        }
        return circle;
    }
}
