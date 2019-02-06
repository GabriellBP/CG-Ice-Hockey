package cg.ice.hockey.strategies.line;

import cg.ice.hockey.util.Line;
import cg.ice.hockey.util.Point;
import static java.lang.Math.abs;

public class LineEquationStrategy implements LineStrategy {

    @Override
    public Line generateLine(Point pp1, Point pp2) {
        Point p1 = new Point(pp1.x, pp1.y), p2 = new Point(pp2.x, pp2.y);
        boolean inverted = abs(p2.y - p1.y) > abs(p2.x - p1.x);
        if (inverted) {
            p1 = new Point(p1.y, p1.x);
            p2 = new Point(p2.y, p2.x);
        }
        
        if (p1.x > p2.x) {
            Point aux = p1; p1 = p2; p2 = aux;
        }
        
        double m = (p2.y - p1.y) / ((p2.x - p1.x) * 1.0);
        int x = p1.x, y = p1.y;
        
        Line line = new Line();
        if (inverted) {
            line.addPoint(y, x);
        } else {
            line.addPoint(x, y);
        }
        for (x = p1.x; x < p2.x; x++) {
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
