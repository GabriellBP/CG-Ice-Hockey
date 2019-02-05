package cg.ice.hockey.strategies.line;

import cg.ice.hockey.util.Line;
import cg.ice.hockey.util.Point;
import static java.lang.Math.abs;

public class LineEquationStrategy implements LineStrategy {

    @Override
    public Line generateLine(Point p1, Point p2) {
        boolean inverted = abs(p2.y - p1.y) > abs(p2.x - p1.x);
        if (inverted) {
            int aux = p1.x; p1.x = p1.y; p1.y = aux;
            aux = p2.x; p2.x = p2.y; p2.y = aux;
        }
        
        if (p1.x > p2.x) {
            Point aux = p1; p1 = p2; p2 = aux;
        }
        
        double m = (p2.y - p1.y) / ((p2.x - p1.x) * 1.0);
        int x, y;
        
        Line line = new Line();
        for (x = p1.x; x <= p2.x; x++) {
            y = (int) (p1.y + m * (x - p1.x));
            if (inverted) {
                line.addPoint(y, x);
            } else {
                line.addPoint(x, y);
            }
        }
        
        return line;
    }
}
